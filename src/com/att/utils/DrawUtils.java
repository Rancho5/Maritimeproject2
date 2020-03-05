package com.att.utils;

import com.att.Constants;
import com.att.Edge;
import com.att.Sea;
import com.att.node.Node;

import java.awt.*;
import java.util.List;

/**
 * 画图的工具类
 */
public class DrawUtils {

    /**
     * 画海的边框
     * @param g
     */
    public static void drawSea(Graphics g){
        g.setColor(Constants.SEACOLOR);
        g.drawRect(Sea.getInstance().getX(),Sea.getInstance().getY(),
                Sea.getInstance().getWidth(),Sea.getInstance().getHeight());
    }

    /**
     * 画节点
     * @param g
     * @param nodesList 需要绘制的节点数组
     */
    public static void drawNode(Graphics g, List<Node> nodesList){
        //节点运动
        /*for(Node node:nodesList)
            node.moveRandom();*/

        g.setColor(Constants.NODECOLOR);
        for(Node node:nodesList){
            node.draw(g);
        }
    }

    /**
     * 画链路
     * @param g
     * @param edgesList
     */
    public static void drawEdges(Graphics g, List<Edge> edgesList){
        g.setColor(Constants.EDGECOLOR);
        for(Edge edge:edgesList){
            drawOneEdge(g, edge);
        }
    }

    /**
     * 画预测的拓扑，并统计预测准确率
     * @param g
     * @param edgesList 实际存在的链路
     * @param inferList 预测出的链路
     */
    public static void drawInferEdge(Graphics g, List<Edge> edgesList, List<Edge> inferList){
        int successEdges = 0;
        for(Edge edge:inferList){
            if(edgesList.contains(edge)){       //预测成功
                successEdges++;
                g.setColor(new Color(0, 200, 0));
                drawOneEdge(g, edge);
            }else {                 //冗余的预测
                g.setColor(new Color(255, 215, 0));
                drawOneEdge(g, edge);
            }
        }
        //控制台打印预测成功率等数据
        int totalEdges = edgesList.size();
        System.out.print("实际的链路共 "+totalEdges+" 条，");
        System.out.print("成功预测中了 "+successEdges+" 条，");
        System.out.print("预测成功率 "+successEdges*100/totalEdges+"%，");
        int moreEdges = inferList.size()-successEdges;
        System.out.print("另外，冗余预测了 "+moreEdges+" 条，");
        System.out.println("预测冗余率 "+moreEdges*100/totalEdges+"%");
    }

    /**
     * 画某一条边
     * @param edge
     */
    private static void drawOneEdge(Graphics g, Edge edge){
        g.drawLine(edge.from.getX() + edge.from.getSizeX()/2, edge.from.getY() + edge.from.getSizeY()/2,
                edge.to.getX() + + edge.to.getSizeX()/2, edge.to.getY() + + edge.to.getSizeY()/2);
    }



}
