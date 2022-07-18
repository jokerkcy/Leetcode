import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author kcy
 * @date 2022/2/17 13:13
 */
public class Ticket implements Runnable{
    private int ticket = 50;
    Lock lock = new ReentrantLock();
    @Override
    public void run() {
        while(true){
            lock.lock();
            if(ticket>0){
                try {
                    Thread.sleep(50);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
                String name = Thread.currentThread().getName();
                System.out.println(name+"正在卖："+ticket--);
            }
            lock.unlock();
        }
    }


}
