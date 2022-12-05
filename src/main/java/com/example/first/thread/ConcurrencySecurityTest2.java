package com.example.first.thread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * @author Mr.乐
 * @Description 并发安全 synchronized
 */
public class ConcurrencySecurityTest2 {
    static int a = 0;
    static int count = 2000;

    public static void main(String[] args) throws InterruptedException {
        ExecutorService service = Executors.newCachedThreadPool();
        //闭锁 在一些条件下可放开  参数:加多少把锁
        CountDownLatch countDownLatch = new CountDownLatch(count);
        //信号量
        Semaphore semaphore = new Semaphore(1);
        for (int i = 0; i < count; i++) {
            service.execute(new Runnable() {
                @Override
                public void run() {
                    try {  //拿走一个信号
                        semaphore.acquire();
                        a++;
                        //解一把锁
                        countDownLatch.countDown();
                    } catch (Exception e) {
                        e.printStackTrace();
                    } finally {
                        //释放信号
                        semaphore.release();
                    }
                }
            });
        }
        service.shutdown();
        //会进入阻塞状态  什么时候把锁全解了   阻塞状态才会解除
        countDownLatch.await();
        System.out.println(a);
        //2000
    }
}