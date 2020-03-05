package com.att.TopoAlgo;

import com.att.Edge;
import com.att.node.Node;
import com.att.utils.EdgeComparator;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 拓扑控制的LMA算法，该算法使节点度保持在某个目标值左右，将发射功率设置为一个足以发射到最远节点的值
 */
public class TopoLMA implements TopoAlgorithm {
    @Override
    public List<Edge> geneEdges(List<Node> nodes) {
        if(nodes == null)
            return null;
        int dis;                    //节点的实际距离
        int degree;                 //节点度
        int degreeAim = 3;          //期望的节点度
        Node node1;
        Node node2;
        List<Edge> result = new ArrayList<>();
        PriorityQueue<Edge> help = new PriorityQueue<>(new EdgeComparator());
        Edge temp;

        for(Node n : nodes){
            n.getEdgs().clear();
        }

        for(int i = 0; i < nodes.size(); i++) {
            node1 = nodes.get(i);
            degree = node1.getEdgs().size();
            help.clear();
            for (int j = i + 1; j < nodes.size(); j++) {
                node2 = nodes.get(j);
                dis = node1.getDistance(node2);
                if (dis <= node1.getCommuDis() && dis <= node2.getCommuDis()) {
                    help.add(new Edge(node1, node2, dis));
                }
            }
            //将边加入结果集，直到达到了目标节点度或没有边可以加入
            for(int d = degree; help.size()>0 && d<degreeAim; d++){
                temp = help.poll();
                result.add(temp);
                node1.getEdgs().add(temp);
                temp.to.getEdgs().add(temp);
            }
        }

        return result;
    }


}
