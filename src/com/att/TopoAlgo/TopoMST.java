package com.att.TopoAlgo;

import com.att.Edge;
import com.att.node.Node;
import com.att.utils.EdgeComparator;

import java.util.*;

/**
 * 最小生成树算法
 */
public class TopoMST implements TopoAlgorithm{
    @Override
    public List<Edge> geneEdges(List<Node> nodes) {
        if(nodes == null)
            return null;

        for(Node n : nodes){
            n.getEdgs().clear();
        }

        //修改UDG算法，将在通信范围内的边加入节点的edges中
        int dis;
        Node node1;
        Node node2;
        Edge edge;
        for(int i = 0; i < nodes.size(); i++){
            node1 = nodes.get(i);
            for(int j = i+1; j < nodes.size(); j++){
                node2 = nodes.get(j);
                dis = node1.getDistance(node2);
                if(dis <= node1.getCommuDis() && dis <= node2.getCommuDis()){
                    //注意：添加时两个节点对应边的from和to是相反的
                    edge = new Edge(node1, node2, dis);
                    node1.getEdgs().add(edge);
                    edge = new Edge(node2, node1, dis);
                    node2.getEdgs().add(edge);
                }
            }
        }
        return primMST(nodes);
    }

    /**
     * 普利姆算法
     * @param nodes
     * @return
     */
    public List<Edge> primMST(List<Node> nodes) {
        PriorityQueue<Edge> priorityQueue = new PriorityQueue<>(new EdgeComparator());
        HashSet<Node> set = new HashSet<>();    //已经连通的节点集合
        List<Edge> result = new ArrayList<>();
        for (Node node : nodes) {
            if (!set.contains(node)) {
                set.add(node);
                priorityQueue.addAll(node.getEdgs());
                while (!priorityQueue.isEmpty()) {
                    Edge edge = priorityQueue.poll();
                    Node toNode = edge.to;
                    if (!set.contains(toNode)) {
                        set.add(toNode);
                        result.add(edge);
                        priorityQueue.addAll(toNode.getEdgs());
                    }
                }
            }
        }
        return result;
    }

}


