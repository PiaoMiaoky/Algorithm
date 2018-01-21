package com.hellojava.produerConsumer_pattern;

public class Producer implements Runnable{
    SyncStack ss = null;
    Producer(SyncStack ss){
        this.ss = ss;
    }
    @Override
    public void run() {
        //开始生产馒头
        for(int i=0;i<20;i++){
            SteamBread stb = new SteamBread(i);
            ss.push(stb);
            System.out.println("生产了"+stb);
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
