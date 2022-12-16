package com.example.first.xkl;

import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author MingRong
 *
 */
public class MyGameFrame  extends  Frame {
    private BufferedImage image;
    private Graphics2D g2;

    Image   planeImg  = GameUtil.getImage("images/long1.png");
    Image   planeImg2  = GameUtil.getImage("images/long2.png");
    Image   bgImg1  = GameUtil.getImage("images/map.png");
    Image   bgImg2  = GameUtil.getImage("images/map1.png");
    Image   bg  = GameUtil.getImage("images/map1.png");
    Image   obstacleImg  = GameUtil.getImage("images/cactus03.png");
    Image   overImg  = GameUtil.getImage("images/game_over.png");
    private Dinasaur dinasaur = new Dinasaur(planeImg, 250, 225);
    private object obj = new object(obstacleImg,250,225);//
    private BackgroundImage background = new BackgroundImage();
    int stepTime = 0;
    static final int fresh = 10;
    boolean live = true;
    int count = 0;
    @Override
    public void paint(Graphics g) {
        if (live) {
            obj.randomplace();
            background.roll();
            dinasaur.move();
            Color   c =  g.getColor();
            g.drawImage(bgImg2, (int)background.x1, (int)background.y2, this);
            g.drawImage(obj.obstacle, obj.x, obj.y, this);
            g.drawImage(planeImg, 0, 0, null);
            g.drawImage(dinasaur.image2, (int)dinasaur.x, (int)dinasaur.y, this);
            boolean  peng = dinasaur.getRect().intersects(obj.getRect());
            if (peng) {
                count+=1;
                g.drawImage(overImg, (int)background.x1, (int)background.y2, this);
                System.out.print("ruin");
                if (count ==3) {
                    live = false;
                }
            }
            stepTime += fresh;
            g.setColor(c);
        }
    }
    /**
     * 刷新贞
     * @author Mingrong
     *
     */
    class  PaintThread  extends  Thread  {
        @Override
        public void run() {
            while(true){
                repaint();

                try {
                    Thread.sleep(40);       //1s=1000ms
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }


    class   KeyMonitor extends  KeyAdapter  {

        @Override
        public void keyPressed(KeyEvent e) {
//          dinasaur.addDirection(e);
            int code = e.getKeyCode();

            if (code == KeyEvent.VK_LEFT) {
                dinasaur.left();
            }
            if (code == KeyEvent.VK_RIGHT) {
                dinasaur.right();
            }
            if (code == KeyEvent.VK_UP) {
                dinasaur.up();
            }
            if (code == KeyEvent.VK_DOWN) {
                dinasaur.down();
            }
            if (code == KeyEvent.VK_SPACE) {
                dinasaur.jump();
            }
        }

        @Override
        public void keyReleased(KeyEvent e) {

            dinasaur.minusDirection(e);
        }
    }

    public  void  launchFrame(){
        this.setTitle("game");
        this.setVisible(true);
        this.setSize(Constant.GAME_WIDTH    , Constant.GAME_HEIGHT);
        this.setLocation(500, 500);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        new PaintThread().start();
        addKeyListener(new KeyMonitor());
    }

    public static void main(String[] args) {
        MyGameFrame  f = new MyGameFrame();
        f.launchFrame();
    }
    private Image offScreenImage = null;
    public void update(Graphics g) {
        if(offScreenImage == null)
            offScreenImage = this.createImage(Constant.GAME_WIDTH,Constant.GAME_HEIGHT);
        Graphics gOff = offScreenImage.getGraphics();
        paint(gOff);
        g.drawImage(offScreenImage, 0, 0, null);
    }
}
