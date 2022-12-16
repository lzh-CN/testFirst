package com.example.first.xkl;


/**
 * 滚动背景
 *
 * @author mingrong
 *
 */
public class BackgroundImage extends GameObject {
    public int x1 = 0;
    public int x2 = 50;
    public int y2 = 25;
    public static final int SPEED = 10;// 滚动速度

    public BackgroundImage() {

    }
    /**
     * 滚动
     */
    public void roll() {
        x1 -= SPEED;// 第一幅图片左移
        if (x1 <= -50) {// 如果第一幅图片移出屏幕
            x1 =50;// 回到屏幕右侧
        }
    }
}