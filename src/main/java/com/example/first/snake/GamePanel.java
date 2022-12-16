package com.example.first.snake;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

/**
 * 主程序要有一个游戏面板
 *
 * 实现paintComponent方法
 * 留着super方法清屏
 *
 * 一个功能的实现一般经过三个过程
 * 定义数据,静态实现,动态实现
 */
public class GamePanel extends JPanel implements KeyListener, ActionListener {

    private int length;
    private int[] snakeX = new int[100];
    private int[] snakeY = new int[100];
    private String hear;

    private boolean start;

    private Timer timer = new Timer(150,this);

    private int[] food = new int[2];

    Random random = new Random();

    private boolean fail;

    private String body;

    public GamePanel(){
        this.init();

        /**
         * 让当前组件获取焦点
         *
         * 游戏一开始就要运行
         */
        setFocusable(true);
        addKeyListener(this);
        timer.start();
    }

    private void init(){
        /**
         * 初始化蛇的长度,x,y座标.
         * 一个格子25度
         *
         * java是以;号为结尾的
         *
         * 在初始化方法中给属性赋初始值
         * 添加功能时知道程序最后都会回到初始
         */
        hear = "R";

        body = "L";

        start = false;

        length = 3;
        snakeX[0] = 100;snakeY[0] = 100;
        snakeX[1] = 75;snakeY[1] = 100;
        snakeX[2] = 50;snakeY[2] = 100;

        food[0] = 25 + (25 * random.nextInt(34));
        food[1] = 75 + (25 * random.nextInt(24));

        fail = true;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponents(g);

        /**
         * 绘制广告头
         * 中间是个实心矩形
         */
        this.setBackground(new Color(0x2626D1));

        Data.header.paintIcon(this,g,25,11);

        g.fillRect(25,75,850,600);

        /**
         * 食物画在蛇前面,
         * 蛇吃食物时是遮住食物的
         *
         * 画上小蛇,默认向右
         *
         * 变成动态的,小于length
         *
         * 设置默认头的方向
         *
         * 设置初始化提示语
         */

        g.setColor(new Color(0x4BE91B));
        g.setFont(new Font("微软雅黑",1,40));
        g.drawString("分数:" + length,730,50);

        Data.food.paintIcon(this,g,food[0],food[1]);

        for (int i = 1; i < length; i++) {
            Data.body.paintIcon(this,g,snakeX[i],snakeY[i]);
        }

        switch (hear){
            case "U":
                Data.up.paintIcon(this,g,snakeX[0],snakeY[0]);
                break;
            case "D":
                Data.down.paintIcon(this,g,snakeX[0],snakeY[0]);
                break;
            case "L":
                Data.left.paintIcon(this,g,snakeX[0],snakeY[0]);
                break;
            default:
                Data.right.paintIcon(this,g,snakeX[0],snakeY[0]);
        }

        if(start == false){
            g.setColor(new Color(0xF1E240));
            g.setFont(new Font("方正舒体",1,60));
            g.drawString("按下空格开始游戏",200,300);
        }

        /**
         * 游戏失败,重新开始
         */
        if(fail == false){
            g.setColor(new Color(0xD50C0C));
            g.setFont(new Font("方正舒体",1,40));
            g.drawString("游戏失败,按下空格重新开始,总得分:"+length,100,300);
        }

    }


    @Override
    public void keyTyped(KeyEvent e) {}

    /**
     * 监听空格键
     *
     * 别忘了重画
     */
    @Override
    public void keyPressed(KeyEvent e) {

        int key = e.getKeyCode();

        /**
         * 按下空格如果失败了游戏重新开始
         */
        if(key == KeyEvent.VK_SPACE){

            if(fail == false){
                init();
            }else {
                start = !start;
            }

            repaint();

        }

        /**
         * 开始和结束界面不允许操作
         *
         * 上下左右的改变方向
         *
         * 如果按键时头是相反的方向,方向不变
         */
        if(fail != false && start != false){
            switch (key){

                case KeyEvent.VK_UP:
                    if(hear != "D"){
                        hear = "U";
                    }
                    break;
                case KeyEvent.VK_DOWN:
                    if(hear != "U") {
                        hear = "D";
                    }
                    break;
                case KeyEvent.VK_LEFT:
                    if(hear != "R"){
                        hear = "L";
                    }
                    break;
                case KeyEvent.VK_RIGHT:
                    if(hear != "L"){
                        hear = "R";
                    }
                    break;
            }

        }

        repaint();

    }

    @Override
    public void keyReleased(KeyEvent e) {}

    @Override
    public void actionPerformed(ActionEvent e) {
        /**
         * 界面动起来的条件:
         * 不需要按空格启动并且游戏没有失败
         *
         * 游戏开始就要不停的动
         *
         * 当前座标变成上一个座标
         *
         * 不能超过边界
         */
        if(start && fail){
            for (int i = length - 1; i > 0; i--) {
                snakeX[i] = snakeX[i -1];
                snakeY[i] = snakeY[i -1];
            }

            switch (hear){
                case "U":
                    snakeY[0] -= 25;
                    if(snakeY[0] < 75){
                        snakeY[0] = 650;
                    }
                    break;
                case "D":
                    snakeY[0] += 25;
                    if(snakeY[0] > 650){
                        snakeY[0] = 75;
                    }
                    break;
                case "L":
                    snakeX[0] -= 25;
                    if(snakeX[0] < 25){
                        snakeX[0] = 850;
                    }
                    break;
                case "R":
                    snakeX[0] += 25;
                    if(snakeX[0] > 850){
                        snakeX[0] = 25;
                    }
                    break;

            }

            /**
             * 蛇的身体和食物重叠
             * 食物被吃,重新刷新
             */
            if(snakeX[0] == food[0] && snakeY[0] == food[1]){
                length++;
                food[0] = 25 + (25 * random.nextInt(34));
                food[1] = 75 + (25 * random.nextInt(24));
            }


            /**
             * 头和身体重合 = 失败
             *
             * 按下空格重新开始
             */
            for (int i = 1; i < length; i++) {
                if(snakeX[0] == snakeX[i] && snakeY[0] == snakeY[i]){
                    fail = false;
                }

            }

            if(snakeY[0] <= 75 || snakeY[0] >= 650 || snakeX[0] <= 25 || snakeX[0] >= 850){
                fail = false;
            }

            repaint();

        }

        timer.start();

    }

}

