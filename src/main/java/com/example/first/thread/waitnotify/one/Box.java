package com.example.first.thread.waitnotify.one;

public class Box {
    private int milk;  //放入奶箱中的第几瓶牛奶
    private boolean state = false; //默认奶箱为空

    /**
     * 生产者生产（放）牛奶
     * @param milk  第几瓶
     */
    public synchronized void put(int milk){
        if(state){  //true表示奶箱中有牛奶
            try {
                wait();  //等待，需要有人唤醒
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //没有牛奶，需要生产牛奶
        this.milk = milk;
        System.out.println("王五将第" + this.milk + "瓶你牛奶放进了奶箱中");
        this.state = true;//将奶箱状态调整成有牛奶
        notifyAll();//唤醒全部正在等待的线程
    }
    /**
     * 消费者取牛奶
     */
    public synchronized void get(){
        if(!state){  //true表示奶箱中有牛奶
            try {
                wait();  //等待，需要有人唤醒
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //有牛奶，需要取牛奶
        System.out.println("张三将第" + this.milk + "瓶牛奶拿走补了身体！");
        this.state = false;//将奶箱状态改变成空
        notifyAll();//唤醒全部正在等待的线程
    }

}
