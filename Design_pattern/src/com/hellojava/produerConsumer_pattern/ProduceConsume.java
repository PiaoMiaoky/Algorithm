package com.hellojava.produerConsumer_pattern;

public class ProduceConsume {
    public static void main(String[] args) {
        SyncStack ss = new SyncStack();//新建筐
        Producer p = new Producer(ss);//新建生产者
        Consume c = new Consume(ss);//新建消费者
        Thread tp = new Thread(p);
        Thread tc = new Thread(c);
        tp.start();
        tc.start();
    }
}
