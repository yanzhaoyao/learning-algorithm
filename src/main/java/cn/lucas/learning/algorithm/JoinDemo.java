package cn.lucas.learning.algorithm;

/**
 * @author lucas
 * @date 2020-11-24
 */
public class JoinDemo extends Thread {
    int i;
    Thread previousThread; //上一个线程

    public JoinDemo(Thread previousThread, int i) {
        this.previousThread = previousThread;
        this.i = i;
    }

    @Override
    public void run() {
        System.out.println("num:" + i);
        try {
            //调用上一个线程的join方法，大家可以自己演示的时候可以把这行代码注释掉
            previousThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Thread previousThread = Thread.currentThread();
        int[] arr = new int[]{1, 2, 3, 4, 5};

        for (int i = 0; i < arr.length; i++) {
            JoinDemo joinDemo = new JoinDemo(previousThread, arr[i]);
            joinDemo.start();
            previousThread = joinDemo;
        }
    }
}

