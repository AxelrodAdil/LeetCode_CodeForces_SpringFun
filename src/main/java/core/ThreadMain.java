package core;

import java.util.concurrent.Semaphore;

public class ThreadMain {
    public static void main(String[] args) throws InterruptedException {
        example1();
        Thread.yield();
//        example2();

    }

    static void example2(){
        Semaphore semaphore = new Semaphore(2, true);
        System.out.println(semaphore.toString());
        System.out.println(semaphore.drainPermits());
        System.out.println(semaphore.availablePermits());
    }

    static void example1() throws InterruptedException {
        MyThread myThread = new MyThread();
        MyThread myThread1 = new MyThread();
        myThread1.join();
        myThread.setPriority(1);
        myThread1.setPriority(10);
        Thread.yield();

        myThread.start();
//        myThread.join();
        myThread1.start();


        myThread.printIt();
        for (int i = 0; i < 100; i++) {
            System.out.println("Main "+i);
        }
        System.out.println("-----------------------------------------------");
        System.out.println(myThread.getThreadGroup());
        System.out.println(myThread.getPriority());
        System.out.println("-----------------------------------------------");
    }
}

class MyThread extends Thread {
    @Override
    public void run() {
        printIt();
        System.out.println("************************************************");
        System.out.println(this.getThreadGroup());
        System.out.println(this.getPriority());
        System.out.println("************************************************");
    }

    public synchronized void printIt(){
        for (int i = 0; i < 100; i++) {
            System.out.println("Hello "+ Thread.currentThread().getName() + " " + i);
//            if(i>60) throw new RuntimeException();
//            if(Thread.currentThread().getName().equals("main")) throw new RuntimeException();
        }
    }
}