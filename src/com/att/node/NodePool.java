package com.att.node;

import com.att.Constants;
import com.att.Sea;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class NodePool{
    private static NodePool nodesPool = new NodePool();
    public static NodePool getInstance(){
        return nodesPool;
    }

    List<Node> nodesList = new ArrayList<>();

    public List<Node> getNodesList() {
        return nodesList;
    }

    private NodePool() {
        int beginX = Sea.getInstance().getX();
        int beginY = Sea.getInstance().getY();
        int width = Sea.getInstance().getWidth();
        int height = Sea.getInstance().getHeight();
        Random random = new Random(1);
        for (int i = 0; i < Constants.NODE_NUMBER; i++) {
            int x = random.nextInt(width-Constants.NODE_WIDTH) + beginX;
            int y = random.nextInt(height-Constants.NODE_HEIGHT) + beginY;
            int speedX = (int)(Math.random() * Constants.MAX_SPEED);
            int speedY = (int)(Math.random() * Constants.MAX_SPEED);
            //Node node = new Node(x,y);
            Node node = new Node(x, y, speedX, speedY);
            nodesList.add(node);
        }
    }
}
