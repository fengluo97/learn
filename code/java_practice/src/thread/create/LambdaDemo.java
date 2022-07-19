package thread.create;

/**
 * @Author: fengluo
 * @Date: 2022/7/17 18:56
 */
public class LambdaDemo {

    public static void main(String[] args) {
        // 匿名内部类创建多线程
        new Thread("A") {
            @Override
            public void run() {
                for (int i = 0; i < 1000; i++) {
                    System.out.println(Thread.currentThread().getName() + ": " + i);
                }
            }
        }.start();

        // lambda创建多线程，推荐
        new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                System.out.println(Thread.currentThread().getName() + ": " + i);
            }
        }, "B").start();

        for (int i = 0; i < 1000; i++) {
            System.out.println(Thread.currentThread().getName() + ": " + i);
        }
    }

}
