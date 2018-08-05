package com.example.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class CheckLocks {
    public static void main(String[] args) {
        CheckLocks checkLocks = new CheckLocks();
        checkLocks.quickLock();
    }

    private void quickLock() {
        Lock lock = new ReentrantLock();

        try {
            lock.tryLock(100, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        lock.lock();
        System.out.println("I'm locked");

        lock.unlock();
        System.out.println("lock released");
    }
}
