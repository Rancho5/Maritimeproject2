package com.att.node;

import com.att.Constants;
import com.att.utils.ImageUtils;

import java.awt.*;

public class Ship extends Node {
    private Image shipImg;

    public Ship(int x, int y){
        super(x, y);
        this.sizeX = Constants.SHIP_WIDTH;
        this.sizeY = Constants.SHIP_HEIGHT;
        shipImg = ImageUtils.getBlackShip().getScaledInstance(sizeX, sizeY, Image.SCALE_FAST);
    }

    public Ship(int x, int y, int speedX, int speedY){
        this(x,y);
        this.speedX = speedX;
        this.speedY = speedY;
    }

    @Override
    public int getSizeX() {
        return sizeX;
    }

    @Override
    public int getSizeY() {
        return sizeY;
    }

    @Override
    public void draw(Graphics g){
        g.drawImage(shipImg, this.getX(), this.getY(), null);
    }

}
