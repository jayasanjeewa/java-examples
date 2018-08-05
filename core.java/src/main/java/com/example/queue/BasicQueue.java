package com.example.queue;

public class BasicQueue<V> {

    private V [] dataArray;
    private int head;
    private int tail;
    private int count;

    public BasicQueue(int size) {
        if (size <= 0) {
            throw new IllegalArgumentException("Incorrect queue size");
        }
        dataArray = (V[]) new Object[size];
    }

    public synchronized void doPut(V o) {
        dataArray[tail] = o;

        if (++tail == dataArray.length) {
            tail = 0;
        }

        count++;
    }

    public synchronized V doTake() {
        V val = dataArray[head];
        dataArray[head] = null;

        if (++head == dataArray.length) {
            head = 0;
        }

        count--;

        return val;

    }

    protected synchronized boolean isFull () {
        return count == dataArray.length;
    }

    protected synchronized boolean isEmpty() {
        return count == 0;
    }

}
