package com.example.first.thread;

/**
 * @author Mr.乐
 * @Description
 */
public class Demo02 {
    public static void main(String[] args) {
        MyRunnable myRun = new MyRunnable();//将一个任务提取出来，让多个线程共同去执行
        //封装线程对象
        Thread t01 = new Thread(myRun, "线程01");
        Thread t02 = new Thread(myRun, "线程02");
        Thread t03 = new Thread(myRun, "线程03");
        //开启线程
        t01.start();
        t02.start();
        t03.start();
        //通过匿名内部类的方式创建线程
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 20; i++) {
                    System.out.println(Thread.currentThread().getName() + " - " + i);
                }
            }
        },"线程04").start();
    }
}
//自定义线程类，实现Runnable接口
//这并不是一个线程类，是一个可运行的类，它还不是一个线程。
class MyRunnable implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 50; i++) {
            System.out.println(Thread.currentThread().getName() + " - " + i);
        }
    }
}