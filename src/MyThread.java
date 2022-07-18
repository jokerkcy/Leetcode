import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @author kcy
 * @date 2022/2/17 12:34
 */
public class MyThread extends Thread{

    public static void main(String[] args) {
        final BlockingQueue<String> bq = new ArrayBlockingQueue<String>(10);

        Runnable producerRunnable = new Runnable() {
            int i =0;
            @Override
            public void run() {
                while(true){
                    try {
                        System.out.println("我生产了一个"+i++);
                        bq.put(i+"");
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };

        Runnable customerRunnable = new Runnable() {
            @Override
            public void run() {
                while(true){
                    try {
                        System.out.println("我消费了一个"+bq.take());
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };

        Thread producerThread = new Thread(producerRunnable);
        Thread customerThread = new Thread(customerRunnable);
        producerThread.start();
        customerThread.start();

    }

}
