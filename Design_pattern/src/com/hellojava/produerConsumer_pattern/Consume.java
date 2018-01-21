package com.hellojava.produerConsumer_pattern;

public class Consume implements Runnable{
    SyncStack ss = null;
    public Consume(SyncStack ss){
        super();
        this.ss = ss;
    }
    @Override
    public void run() {
        for(int i=0;i<20;i++){
            SteamBread stb = ss.pop();
            System.out.println("消费了"+stb);
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
