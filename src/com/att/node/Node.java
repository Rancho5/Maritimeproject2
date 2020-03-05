package com.att.node;

import com.att.Constants;
import com.att.Edge;
import com.att.Sea;

import java.awt.*;
import java.util.ArrayList;

public class Node{
    int x;
    int y;
    int speedX;
    int speedY;
    int sizeX = Constants.NODE_WIDTH;  //节点的长
    int sizeY = Constants.NODE_HEIGHT;  //节点的宽
    int commuDis = 100;   //通信距离
    ArrayList<Edge> edgs = new ArrayList<>();

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getSpeedX() {
        return speedX;
    }

    public void setSpeedX(int speedX) {
        this.speedX = speedX;
    }

    public int getSpeedY() {
        return speedY;
    }

    public void setSpeedY(int speedY) {
        this.speedY = speedY;
    }

    public int getSizeX() {
        return sizeX;
    }

    public int getSizeY() {
        return sizeY;
    }

    public int getCommuDis() {
        return commuDis;
    }

    public void setCommuDis(int commuDis) {
        this.commuDis = commuDis;
    }

    public ArrayList<Edge> getEdgs() {
        return edgs;
    }

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Node(int x, int y, int speedX, int speedY){
        this(x, y);
        this.speedX = speedX;
        this.speedY = speedY;
    }

    public void draw(Graphics g){
        g.fillOval(x, y, sizeX, sizeY);
        //绘制通信范围圆
        //g.drawOval(x-commuDis, y-commuDis, commuDis*2, commuDis*2);
    }

    public void moveRandom(){
        Sea sea = Sea.getInstance();
        if(x+speedX <= sea.getX() || x+speedX+sizeX >= sea.getX()+sea.getWidth())
            speedX = -speedX;
        if(y+speedY <= sea.getY() || y+speedY+sizeY >= sea.getY() + sea.getHeight())
            speedY = -speedY;
        x += speedX;
        y += speedY;
    }

    /**
     * 计算两个节点间的距离
     * @param n
     * @return
     */
    public int getDistance(Node n){
        if(n == null)
            return Integer.MAX_VALUE;
        return (int)Math.sqrt(Math.pow(this.getX() - n.getX(), 2)
                + Math.pow(this.getY() - n.getY(), 2));
    }

}
