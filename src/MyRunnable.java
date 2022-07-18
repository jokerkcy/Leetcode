/**
 * @author kcy
 * @date 2022/2/17 12:55
 */
public class MyRunnable implements Runnable{
    @Override
    public void run() {
        System.out.println("我要一个教练");
        try{
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+"线程id");
    }
}
