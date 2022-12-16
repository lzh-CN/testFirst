package com.example.first.snake;

import javax.swing.*;

public class Index extends JFrame/**/{

    public static void main(String[] args) {
        new Index().init();
    }

    /**
     * 一个900x720的界面,不可拉伸
     * 添加一个游戏面板类用来画图
     */
    public void init(){
        //JFrame jFrame = new JFrame();

        setBounds(100,100,900,720);
        setResizable(false);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

        add(new GamePanel());
    }

}
