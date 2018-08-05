package com.example.queue;

public class BlockingQueueUsingArray  extends BasicQueue {

    public  BlockingQueueUsingArray(int size) {
        super(size);
    }

    public synchronized void put(Object o) {
        while(isFull()) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        doPut(o);

        notifyAll();
    }

    public synchronized Object take() {
        while(isEmpty()) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        Object val = doTake();

        return val;
    }
}
