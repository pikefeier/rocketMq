package suscrible;

import java.util.concurrent.*;

public class BlockingQueueTest {
    //一个公共的队列，生产者写入，消费者写出
    public static ConcurrentHashMap<String,BlockingQueue<String>> topic = new ConcurrentHashMap<>();



    public static void main(String[] args) throws Exception{
        //生成多个消费者
        //生成多个生产者
        //开启线程
        ExecutorService service = Executors.newCachedThreadPool();
        BlockingQueueCusotmer cusotmer4 = new BlockingQueueCusotmer("topic4");
        service.submit(cusotmer4);
        BlockingQueueCusotmer cusotmer1 = new BlockingQueueCusotmer("topic1");
        service.submit(cusotmer1);
        BlockingQueueCusotmer cusotmer2 = new BlockingQueueCusotmer("topic2");
        service.submit(cusotmer2);
        BlockingQueueCusotmer cusotmer3 = new BlockingQueueCusotmer("topic3");
        service.submit(cusotmer3);

        BlockingQueueProducer producer1 = new BlockingQueueProducer("topic1","生产者1");
        service.submit(producer1);
        Thread.sleep(1000);
        BlockingQueueProducer producer11 = new BlockingQueueProducer("topic1","生产者11111");
        service.submit(producer11);
        Thread.sleep(1000);
        BlockingQueueProducer producer2 = new BlockingQueueProducer("topic2","生产者2");
        service.submit(producer2);
        Thread.sleep(1000);
        BlockingQueueProducer producer3 = new BlockingQueueProducer("topic3","生产者3");
        service.submit(producer3);
        Thread.sleep(1000);
        BlockingQueueProducer producer5 = new BlockingQueueProducer("topic5","生产者5");
        service.submit(producer5);
        Thread.sleep(1000);
        service.shutdown();
    }
}
