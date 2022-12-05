package com.example.first.thread.waitnotify.one;

public class WaitNotify {
    public static void main(String[] args) {
        Box box = new Box();//实例化奶箱类

        Producer producer = new Producer(box);//生产者对象
        Customer customer = new Customer(box);//消费者对象

        Thread tp = new Thread(producer);//创建生产者线程
        Thread tc = new Thread(customer);//创建消费者线程

        //启动线程
        tp.start();
        tc.start();
    }
}
