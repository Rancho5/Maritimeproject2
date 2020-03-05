package com.att.node;

import com.att.Constants;
import com.att.Sea;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ShipPool {
    private static ShipPool shipPool = new ShipPool();
    public static ShipPool getInstance(){
        return shipPool;
    }

    List<Node> nodesList = new ArrayList<>();

    public List<Node> getNodesList() {
        return nodesList;
    }

    private ShipPool() {
        int beginX = Sea.getInstance().getX();
        int beginY = Sea.getInstance().getY();
        int width = Sea.getInstance().getWidth();
        int height = Sea.getInstance().getHeight();
        Random random = new Random(1);
        for (int i = 0; i < Constants.NODE_NUMBER; i++) {
            int x = random.nextInt(width-Constants.SHIP_WIDTH) + beginX;
            int y = random.nextInt(height-Constants.SHIP_HEIGHT) + beginY;
            int speedX = (int)(Math.random() * Constants.MAX_SPEED);
            int speedY = (int)(Math.random() * Constants.MAX_SPEED);
            //Node node = new Node(x,y);
            Node node = new Ship(x, y, speedX, speedY);
            nodesList.add(node);
        }
    }
}
