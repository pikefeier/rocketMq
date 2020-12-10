package blockingQueue;

import java.util.concurrent.Callable;

/*生产者 对静态的blockingQueue进行写入
* */
public class BlockingQueueProducer implements Runnable {
    private String message;

    public  BlockingQueueProducer (String message){
        this.message = message;
    }

    @Override
    public void run() {
        System.err.println("生产者生产了："+message);
        BlockingQueueTest.blockingQueue.add(message);
    }
}
