package suscrible;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

/*生产者 对静态的blockingQueue进行写入
* */
public class BlockingQueueProducer implements Runnable {
    private String message;
    private String topic;
    public  BlockingQueueProducer (String topic,String message){
        this.message = message;
        this.topic = topic;
    }

    @Override
    public void run() {
        if (BlockingQueueTest.topic.get(topic)!=null){
            System.err.println("生产者再次生产了："+topic+message);
            BlockingQueue<String> existQueue = BlockingQueueTest.topic.get(topic);
            existQueue.add(message);
            BlockingQueueTest.topic.put(topic,existQueue);
        }else{
            System.err.println("生产者生产了："+topic+message);
            BlockingQueue<String> newQueue = new LinkedBlockingDeque<>();
            newQueue.add(message);
            BlockingQueueTest.topic.put(topic,newQueue);
        }
    }
}
