import lombok.extern.slf4j.Slf4j;

import java.util.LinkedList;

/**
 * @Author: fengluo
 * @Date: 2022/8/8 13:24
 */
@Slf4j(topic = "c.Test21")
public class Test21 {

    public static void main(String[] args) {
        MessageQueue messageQueue = new MessageQueue(2);

        for (int i = 0; i < 3; i++) {
            int finalI = i;
            new Thread(() -> {
                messageQueue.put(new Message(finalI, "值" + finalI));
            }, "生产者" + i).start();
        }

        new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(1);
                    Message take = messageQueue.take();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "消费者").start();
    }

}

@Slf4j(topic = "c.MessageQueue")
class MessageQueue {

    private LinkedList<Message> list = new LinkedList<>();
    private int capacity;

    public MessageQueue(int capacity) {
        this.capacity = capacity;
    }

    public Message take() {
        synchronized (list) {
            while (list.isEmpty()) {
                try {
                    log.debug("队列为空，消费者线程等待");
                    list.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            Message message = list.removeFirst();
            log.debug("已消费消息 {}", message);
            list.notifyAll();
            return message;
        }
    }

    public void put(Message message) {
        synchronized (list) {
            while (list.size() == capacity) {
                try {
                    log.debug("队列满了，生产者线程等待");
                    list.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            list.addLast(message);
            log.debug("已生产消息 {}", message);
            list.notifyAll();
        }
    }

}

@Slf4j(topic = "c.Message")
final class Message {
    private int id;
    private Object value;

    public Message(int id, Object value) {
        this.id = id;
        this.value = value;
    }

    public int getId() {
        return id;
    }

    public Object getValue() {
        return value;
    }

}



