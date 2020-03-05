package com.att.TopoAlgo;

import com.att.Edge;
import com.att.node.Node;

import java.util.ArrayList;
import java.util.List;

/**
 * UnitDiskGraph：单位圆图
 * 只要节点a和节点b的距离既≤a的通信距离，也≤b的通信距离，就建立链接
 */
public class UnitDiskGraph implements TopoAlgorithm{
    @Override
    public List<Edge> geneEdges(List<Node> nodes) {
        if(nodes == null)
            return null;
        int dis;
        Node node1;
        Node node2;
        List<Edge> edges = new ArrayList<>();
        for(int i = 0; i < nodes.size(); i++){
            node1 = nodes.get(i);
            for(int j = i+1; j < nodes.size(); j++){
                node2 = nodes.get(j);
                dis = node1.getDistance(node2);
                if(dis <= node1.getCommuDis() && dis <= node2.getCommuDis())
                    edges.add(new Edge(node1, node2, dis));
            }
        }
        return edges;
    }
}
