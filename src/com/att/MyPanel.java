package com.att;

import com.att.TopoAlgo.*;
import com.att.node.*;
import com.att.utils.DrawUtils;

import javax.swing.*;
import java.awt.*;
import java.util.List;

/**
 * 负责实现paint，实现run，计算时间
 *
 */
public class MyPanel extends JPanel implements Runnable {

    public MyPanel() {
        this.setBackground(Constants.BACKCOLOR);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        //画海
        DrawUtils.drawSea(g);

        //画点    NodePool和ShipPool切换可以决定画出来的是点还是船
        List<Node> nodesList = ShipPool.getInstance().getNodesList();
        DrawUtils.drawNode(g, nodesList);

        //画边    实例化时可以拓扑控制策略
        List<Edge> edgesList = new RelativeNeighGraph().geneEdges(nodesList);
        DrawUtils.drawEdges(g, edgesList);

        //画拓扑预测
        List<Edge> inferList = new TopoInfer().geneEdges(nodesList);
        DrawUtils.drawInferEdge(g, edgesList, inferList);

    }

    @Override
    public void run() {
        while (true) {

            this.repaint();

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }




}