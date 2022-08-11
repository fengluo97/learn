import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @Author: fengluo
 * @Date: 2022/8/7 12:53
 */
@Slf4j(topic = "c.Test2")
public class Test1 {

    static final Object lock = new Object();
    static int counter = 0;

    public static void main(String[] args){

        synchronized (lock) {
            counter++;
        }
        String str = new String("dwadwa");
    }

}
