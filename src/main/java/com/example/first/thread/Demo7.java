package com.example.first.thread;

/**
 * @author Mr.乐
 * @Description  线程的调度
 */
public class Demo7 {
    public static void main(String[] args) {
        //创建线程
        MyThread t01 = new MyThread("线程01");
        MyThread t02 = new MyThread("线程02");
        MyThread t03 = new MyThread("线程03");
        //获取线程优先级，默认是5
//        System.out.println(t01.getPriority());
//        System.out.println(t02.getPriority());
//        System.out.println(t03.getPriority());
        //设置线程优先级
        t01.setPriority(Thread.MIN_PRIORITY); //低  - 理论上来讲，最后完成
        t02.setPriority(Thread.NORM_PRIORITY); //中
        t03.setPriority(Thread.MAX_PRIORITY); //高  - 理论上来讲，最先完成
        //开启线程
        t01.start();
        t02.start();
        t03.start();
    }
}
