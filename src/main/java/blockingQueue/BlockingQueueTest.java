package blockingQueue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;

public class BlockingQueueTest {
    //一个公共的队列，生产者写入，消费者写出
    public static BlockingQueue<String> blockingQueue = new LinkedBlockingDeque<String>();

    public static void main(String[] args) throws Exception{
        //生成多个消费者
        //生成多个生产者
        //开启线程
        ExecutorService service = Executors.newCachedThreadPool();
        BlockingQueueCusotmer cusotmer = new BlockingQueueCusotmer();
        service.submit(cusotmer);
        BlockingQueueProducer producer1 = new BlockingQueueProducer("生产者1");
        BlockingQueueProducer producer2 = new BlockingQueueProducer("生产者2");
        BlockingQueueProducer producer3 = new BlockingQueueProducer("生产者3");
        service.submit(producer1);
        Thread.sleep(3000);
        service.submit(producer2);
        Thread.sleep(3000);
        service.submit(producer3);

        service.shutdown();
    }
}
