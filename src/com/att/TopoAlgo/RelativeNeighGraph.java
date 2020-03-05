package com.att.TopoAlgo;

import com.att.Edge;
import com.att.node.Node;

import java.util.ArrayList;
import java.util.List;

/**
 * RNG图算法：Relative Neighbourhood Graph
 * 当且仅当分别以节点from和节点end为圆心，以|from,end|长度为半径的两个圆公共区域内不含其他节点时才建立链路
 */
public class RelativeNeighGraph implements TopoAlgorithm {
    @Override
    public List<Edge> geneEdges(List<Node> nodes) {
        List<Edge> allEdges = new UnitDiskGraph().geneEdges(nodes);
        List<Edge> result = new ArrayList<>();
        Node from;
        Node end;
        int dis1;       //到节点from的距离平方
        int dis2;       //到节点end的距离平方
        int radius2;    //节点from，to的距离平方
        boolean flag;
        for(Edge e : allEdges){
            if(!result.contains(e)){
                flag = true;
                from = e.from;
                end = e.to;
                radius2 = (int)(Math.pow(from.getX() - end.getX(), 2) + Math.pow(from.getY() - end.getY(), 2));
                for(Node n : nodes){
                    if(n != from && n != end){
                        //求该点到节点from的距离平方
                        dis1 = (int)(Math.pow(n.getX() - from.getX(), 2) + Math.pow(n.getY() - from.getY(), 2));
                        //求该点到节点end的距离平方
                        dis2 = (int)(Math.pow(n.getX() - end.getX(), 2) + Math.pow(n.getY() - end.getY(), 2));
                        //判断是否处在公共区域内
                        if(dis1 < radius2 && dis2 < radius2){
                            flag = false;
                            break;
                        }
                    }
                }
                if(flag)
                    result.add(e);
            }
        }
        return result;
    }
}
