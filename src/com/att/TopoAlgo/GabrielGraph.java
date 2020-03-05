package com.att.TopoAlgo;

import com.att.Edge;
import com.att.node.Node;

import java.util.ArrayList;
import java.util.List;

/**
 * GG图生成算法：Gabriel Graph
 */
public class GabrielGraph implements TopoAlgorithm {
    @Override
    public List<Edge> geneEdges(List<Node> nodes) {
        List<Edge> allEdges = new UnitDiskGraph().geneEdges(nodes);
        List<Edge> result = new ArrayList<>();
        Node from;
        Node end;
        int centerX;
        int centerY;
        int dis;
        int radius2;    //半径的平方
        boolean flag;
        for(Edge e : allEdges){
            if(!result.contains(e)){
                flag = true;
                from = e.from;
                end = e.to;
                centerX = (from.getX() + end.getX()) / 2;
                centerY = (from.getY() + end.getY()) / 2;
                radius2 = (int)(Math.pow(from.getX() - centerX, 2) + Math.pow(from.getY() - centerY, 2));
                for(Node n : nodes){
                    if(n != from && n != end){
                        //求该点到圆心的距离平方
                        dis = (int)(Math.pow(n.getX() - centerX, 2) + Math.pow(n.getY() - centerY, 2));
                        //判断是否在圈内
                        if(dis < radius2){
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
