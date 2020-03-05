package com.att.TopoAlgo;

import com.att.Constants;
import com.att.Edge;
import com.att.Sea;
import com.att.node.Node;

import java.util.ArrayList;
import java.util.List;

public class TopoInfer implements TopoAlgorithm{
    @Override
    public List<Edge> geneEdges(List<Node> nodes) {
        if(nodes == null)
            return null;
        int commuDisInfer = getComDis(0.45);    //预测的节点通信距离
        //System.out.println(commuDisInfer);
        int dis;            //节点实际的距离
        Node node1;
        Node node2;
        List<Edge> edges = new ArrayList<>();
        for(int i = 0; i < nodes.size(); i++){
            node1 = nodes.get(i);
            for(int j = i+1; j < nodes.size(); j++){
                node2 = nodes.get(j);
                dis = node1.getDistance(node2);
                if(dis <= commuDisInfer)
                    edges.add(new Edge(node1, node2, dis));
            }
        }
        return edges;
    }

    /**
     * 根据公式预测节点的关键通信距离
     * 参考文献：
     * Research on Non-cooperative Topology Inference Method Based on Node Location Information
     * @param k
     * @return
     */
    private static int getComDis(double k){
        int l = Sea.getInstance().getWidth();   //拓扑预测公式的参数l
        return (int) Math.sqrt(k*Math.pow(l, 2)*Math.log(l)/Constants.NODE_NUMBER);     //预测的节点通信距离
    }

}
