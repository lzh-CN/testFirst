package com.example.first.xkl;


import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

public class object extends GameObject {

    Random r = new Random();
    public int x = 500;
    public int x2 = 50;
    public int y = 225;
    public boolean judge=false;

    public static final int SPEED = 11;// 滚动速度
    int temp = r.nextInt(4) + 1;//1-2-3
    Image obstacle;
    Image   obstacleImg  = GameUtil.getImage("images/cactus01.png");
    Image   obstacleImg2  = GameUtil.getImage("images/cactus03.png");
    int stepTime = 0;//计时器
    static final int fresh = 10;
    public  object(Image  img, double x, double y){
        this.img = img;
        this.x = (int)x;
        this.y = (int)y;
        this.speed = 3;
        this.width = img.getWidth(null) ;
        this.height = img.getHeight(null);

    }

    public object() {
        this.x =500;
        this.width = img.getWidth(null) ;
        this.height = img.getHeight(null);
    }
    public void randomplace() {
        int tmp = stepTime / 100 % 20;
        if (tmp == 1) {
            obstacle = obstacleImg;
        } else {
            obstacle = obstacleImg2;
        }

        stepTime += fresh;
        x -= SPEED;// 第一幅图片左移

        if (x <= -500) {// 如果第一幅图片移出屏幕
            x =500;// 回到屏幕右侧
        }

    }
    public void moving() {

        x -= SPEED;// 第一幅图片左移

        if (x <= -500) {// 如果第一幅图片移出屏幕
            x =500;// 回到屏幕右侧
        }
    }
    public  Rectangle   getRect(){
//      return  new Rectangle((int)x+10,(int)y,20,10);
        return  new Rectangle((int)x, (int)y, width, height);
    }
}