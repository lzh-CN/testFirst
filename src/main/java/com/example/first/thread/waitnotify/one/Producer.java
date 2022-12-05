package com.example.first.thread.waitnotify.one;

public class Producer implements Runnable {
    private Box b;

    public Producer(Box b){
        this.b = b;
    }

    @Override
    public void run() {
        for (int i = 1; i < 8; i++) {
            b.put(i);//放牛奶，放几瓶
        }
    }
}
