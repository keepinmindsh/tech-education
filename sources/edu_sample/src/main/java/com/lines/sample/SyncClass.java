package com.lines.sample;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SyncClass {

    private int value = 100;

    public synchronized void setValue(int value){
        this.value = value;
    }

    public synchronized int getValue(){
        return value;
    }

    public void doProcess(int value){
        int assignedValue = value;


    }
}

interface Sync {
    void getValue();
}

class SyncSample implements Sync {
    private final int value;


    SyncSample(int value) {
        this.value = value;
    }

    public void getValue(){

    }
}

class MainSample {

    private final static ExecutorService executorService = Executors.newFixedThreadPool(100);

    public static void main(String[] args) {

        SyncClass syncClass = new SyncClass();

        for (int i = 0; i < 100; i++) {
            executorService.submit(() -> {
                syncClass.setValue(new Random().nextInt());

                syncClass.getValue();
            });
        }
    }
}