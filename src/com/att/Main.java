package com.att;

import javax.swing.*;
/**
 *负责JFrame，开一个线程负责JPanel
 */

public class Main {
    public static void main(String[] args) {
        MyPanel p = new MyPanel();
        Thread panelThread = new Thread(p);
        JFrame frame = new JFrame();
        frame.setSize(1500, 1000);
        frame.add(p);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panelThread.start();
    }
}
