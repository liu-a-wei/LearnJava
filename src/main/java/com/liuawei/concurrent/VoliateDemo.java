package com.liuawei.concurrent;

public class VoliateDemo {
    public static void main(String[] args) {
        final SynTest synTest = new SynTest();
        for(int i=0;i<10;i++){
            new Thread(){
                public void run() {
                    for(int j=0;j<1000;j++)
                    	synTest.increase();
                };
            }.start();
        }
        
        while(Thread.activeCount()>1)  //保证前面的线程都执行完
            Thread.yield();
        System.out.println(synTest.inc);
        
        
        final VolTest volTest = new VolTest();
        for(int i=0;i<10;i++){
            new Thread(){
                public void run() {
                    for(int j=0;j<1000;j++)
                    	volTest.increase();
                };
            }.start();
        }
        
        while(Thread.activeCount()>1)  //保证前面的线程都执行完
            Thread.yield();
        System.out.println(volTest.inc);
        
        
        
    }
} 
class SynTest {
    public  int inc = 0;
    
    public synchronized void increase() {
        inc++;
    }
}

class VolTest {
	public volatile int inc = 0;

	public void increase() {
		inc++;  //i++操作不具备原子性
	}
}