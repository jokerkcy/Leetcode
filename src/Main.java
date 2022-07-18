import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author kcy
 * @date 2022/3/10 20:13
 */
public class Main {
    static int i=0;
    static Thread thread1 = new Thread(new Runnable() {
        @Override
        public void run() {
            System.out.println("thread1"+i);
            i++;
        }
    });

    static Thread thread2 = new Thread(new Runnable() {
        @Override
        public void run() {
            System.out.println("thread2"+i);
            i++;
        }
    });

    static Thread thread3 = new Thread(new Runnable() {
        @Override
        public void run() {
            System.out.println("thread3"+i);
            i++;
        }
    });

    static ExecutorService executorService = Executors.newSingleThreadExecutor();

    public static void main(String[] args) throws InterruptedException {
        //方式一：通过Join方式让主线程等待子线程完成后在执行 原理：调用 Object 的wait()方式。
//        thread1.start();
//        thread1.join();
//        thread2.start();
//        thread2.join();
//        thread3.start();
//        thread3.join();

        //方式二：用队列的方式FIFO(先进先出)来保证顺序
        executorService.submit(thread1);
        executorService.submit(thread2);
        executorService.submit(thread3);
        executorService.shutdown();
        System.out.println(i);
    }

}
