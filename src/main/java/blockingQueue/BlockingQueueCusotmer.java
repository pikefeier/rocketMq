package blockingQueue;

import java.util.concurrent.Callable;

/*消费者 对静态的blockingQueue进行消费
* */
public class BlockingQueueCusotmer implements Callable {

    @Override
    public Object call() throws Exception {
        String take = "";
        while (true){
            take = BlockingQueueTest.blockingQueue.take();
            System.err.println("消费者消费了："+take);
        }
    }
}
