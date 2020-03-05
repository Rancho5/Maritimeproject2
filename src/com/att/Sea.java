package com.att;

public class Sea {
    private int x=0;   //海洋的起始位置
    private int y=0;

    private int width = Constants.WIDTH - 2*x;
    private int height = Constants.HEIGHT - 2*y;

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    private static Sea sea = new Sea();
    public static Sea getInstance(){
        return sea;
    }
}
