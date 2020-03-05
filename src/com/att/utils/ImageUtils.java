package com.att.utils;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.URL;

/**
 * 读取图片的工具类
 */
public class ImageUtils {
    /**
     * 根据路径获取图片
     */
    public static Image getImage(String path){
        BufferedImage img=null;
        try {
            img = ImageIO.read(new File(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return img;
    }

    public static Image getBlackShip(){
        return getImage("src\\resources\\black.png");
    }


}
