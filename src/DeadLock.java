/**
 * @author kcy
 * @date 2021/12/23 23:48
 */
public class DeadLock implements Runnable {

    int condition;
    static Object object1 = new Object();
    static Object object2 = new Object();

    public static void main(String[] args) {
        DeadLock deadLock1 = new DeadLock();
        DeadLock deadLock2 = new DeadLock();
        deadLock1.condition = 1;
        deadLock2.condition = 2;

        Thread t1 = new Thread(deadLock1);
        Thread t2 = new Thread(deadLock2);

        t1.start();
        t2.start();
    }

    @Override
    public void run() {
        System.out.println("当前是线程：" + condition);
        if (condition == 1) {
            synchronized (object1) {
                System.out.println("线程1" + "得到object1锁");

                System.out.println("线程1，卡在下一行代码");
                synchronized (object2) {
                    System.out.println("打印出此行，表示线程1同时获得两把锁");
                }
                System.out.println("线程1执行完毕");
            }
        }
        if (condition == 2) {
            synchronized (object2) {
                System.out.println("线程2" + "得到object2锁");

                System.out.println("线程2，卡在下一行代码");
                synchronized (object1) {
                    System.out.println("打印出此行，表示线程2同时获得两把锁");
                }
                System.out.println("线程2执行完毕");
            }
        }
    }
}


