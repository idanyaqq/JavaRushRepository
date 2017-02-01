package com.javarush.test.level30.lesson04.home01;


import java.util.Locale;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TransferQueue;

/**
 * Created by Danya on 30/01/2017.
 */
public class Producer implements Runnable {
    private TransferQueue<ShareItem> queue;

    public Producer(TransferQueue<ShareItem> queue) {this.queue = queue;}

    @Override
    public void run() {
        //)
        try {
            for (int i = 1; i <= 9; i++)
                if (!Thread.currentThread().isInterrupted()) {
                    System.out.format(Locale.UK,"Элемент 'ShareItem-%d' добавлен%n", i);
                    queue.offer(new ShareItem("ShareItem-" + i, i));

                    TimeUnit.MILLISECONDS.sleep(100);

                    if (queue.hasWaitingConsumer())
                        System.out.println("Consumer в ожидании!");
                }
        } catch (InterruptedException e) {
            return;
        }
    }
}