package thread.create;

/**
 * @Author: fengluo
 * @Date: 2022/7/17 18:30
 */
public class ThreadDemo {
    public static void main(String[] args) {
        MyThread1 myThread1 = new MyThread1();
        myThread1.start();
        for (int i = 0; i < 1000; i++) {
            System.out.println("主线程：" + i);
        }
    }
}

class MyThread1 extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            System.out.println("分：" + i);
        }
    }
}