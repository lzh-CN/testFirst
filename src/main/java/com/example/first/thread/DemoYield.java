package com.example.first.thread;

/**
 * @author Mr.乐
 * @Description 线程让位
 */
public class DemoYield {
    public static void main(String[] args) {
        //创建线程
        MyThread5 t01 = new MyThread5("线程01");
        MyThread5 t02 = new MyThread5("线程02");
        MyThread5 t03 = new MyThread5("线程03");

        //开启线程
        t01.start();
        t02.start();
        t03.start();
    }
}
class MyThread5 extends Thread{
    public MyThread5() {
    }

    public MyThread5(String name) {
        super(name);
    }

    @Override
    public void run() {
        for (int i = 0; i < 50; i++) {
            if(30 == i){
                Thread.yield();//当循i环到30时，让线程让步
                //1、回到抢占队列中，又争夺到了执行权
                //2、回到抢占队列中，没有争夺到执行权
            }
            System.out.println(this.getName() + ":" + i);
        }
    }
}