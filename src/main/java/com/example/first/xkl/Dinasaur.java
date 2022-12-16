package com.example.first.xkl;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

public class Dinasaur extends GameObject {
    boolean  left,up,right,down;
    boolean  live = true;
    int stepTime = 0;//计时器
    static final int fresh = 10;
    private boolean jumpState = false;// 跳跃状态
    private final int JUMP_HIGHT = 100;// 跳起最大高度
    private final int LOWEST_Y = 220;// 落地最低坐标
    private int jumpValue = 0;// 跳跃的增变量

    Image   dinasaurImg  = GameUtil.getImage("images/long1.png");
    Image   dinasaurImg2  = GameUtil.getImage("images/long2.png");
    Image image2;
    public  void  drawSelf(Graphics  g){
        if(live){
            g.drawImage(img, (int)x,(int) y, null);

            if(left){
                x -=speed;
            }
            if(right){
                x += speed;
            }
            if(up){
                y -=speed;    //y = y-speed;
            }
            if(down){
                y += speed;
            }
        }else{

        }

    }
    public  Dinasaur(Image  img, double x, double y){
        this.img = img;
        this.x = x+3;
        this.y = y+3;
        this.speed = 3;
        this.width = img.getWidth(null) ;
        this.height = img.getHeight(null);

    }

    public void move() {
        step();// 不断踏步
        if (jumpState) {// 如果正在跳跃
            if (y >= LOWEST_Y) {// 如果纵坐标大于等于最低点
                jumpValue = -14;// 增变量为负值
            }
            if (y <= LOWEST_Y - JUMP_HIGHT) {// 如果跳过最高点
                jumpValue = 14;// 增变量为正值
            }
            y += jumpValue;// 纵坐标发生变化
            if (y >= LOWEST_Y) {// 如果再次落地
                jumpState = false;// 停止跳跃
            }
        }
    }
    void step() {
        int tmp = stepTime / 100 % 2;
        if (tmp == 1) {
            image2 = dinasaurImg;
        } else {
            image2 = dinasaurImg2;
        }

        stepTime += fresh;

    }
    public void jump() {

        jumpState = true;// 处于跳跃状态
    }

    public void left() {
        x -= 5;
    }
    public void right() {
        x += 5;
    }
    public void up() {
        y -= 5;
    }
    public void down() {
        y += 5;
    }

    //按下某个键，增加相应的方向
    public  void   addDirection(KeyEvent  e){
        switch (e.getKeyCode()) {
            case KeyEvent.VK_LEFT:
                left = true;
                break;
            case KeyEvent.VK_UP:
                up = true;
                break;
            case KeyEvent.VK_RIGHT:
                right = true;
                break;
            case KeyEvent.VK_DOWN:
                down = true;
                break;
        }
    }

    //按下某个键，取消相应的方向
    public  void   minusDirection(KeyEvent  e){
        switch (e.getKeyCode()) {
            case KeyEvent.VK_LEFT:
                left = false;
                break;
            case KeyEvent.VK_UP:
                up = false;
                break;
            case KeyEvent.VK_RIGHT:
                right = false;
                break;
            case KeyEvent.VK_DOWN:
                down = false;
                break;
        }
    }

    public  Rectangle   getRect(){
//              return  new Rectangle((int)x+10,(int)y,20,10);
        return  new Rectangle((int)x, (int)y, width, height);
    }
}
