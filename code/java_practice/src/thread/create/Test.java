package thread.create;

/**
 * @Author: fengluo
 * @Date: 2022/8/7 12:17
 */
public class Test extends Thread {
    /**
     * synchronized、lock、volatile
     */
    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            System.out.println("i am thread");
        }
    }

    public static void main(String[] args) {

        Test t = new Test();
        t.start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < 1000; i++) {
            System.out.println("main");
        }
    }
}
