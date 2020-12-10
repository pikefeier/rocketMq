package suscrible;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;

/*消费者 对静态的blockingQueue进行消费
* */
public class BlockingQueueCusotmer implements Callable {
    private String topic;
    public  BlockingQueueCusotmer (String topic){
        this.topic = topic;
    }
    @Override
    public Object call() throws Exception {
        while (true){
            BlockingQueue<String> queue = BlockingQueueTest.topic.get(topic);
            if (queue!=null){
                String poll = queue.take();//没有数据会返回null
                System.err.println("消费了"+topic+"上的："+poll);
            }
        }
    }
}
