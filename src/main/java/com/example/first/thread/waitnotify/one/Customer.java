package com.example.first.thread.waitnotify.one;

public class Customer implements Runnable {
    private Box b;

    public Customer(Box b){
        this.b = b;
    }

    @Override
    public void run() {
        while (true){
            b.get();//消费者取牛奶
        }
    }
}
