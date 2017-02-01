package com.javarush.test.level30.lesson04.home01;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.TransferQueue;

/**
 * Created by Danya on 30/01/2017.
 */
public class Consumer implements Runnable {
    private TransferQueue<ShareItem> queue;

    public Consumer(TransferQueue<ShareItem> queue) {this.queue = queue;}

    @Override
    public void run() {
        try {
            TimeUnit.MILLISECONDS.sleep(500);

            while (!Thread.currentThread().isInterrupted()) {
                System.out.println("Processing " + queue.take().toString());
            }
        } catch (InterruptedException e) {}
    }
}
