/**
 * @author kcy
 * @date 2022/3/1 19:00
 */
public class Service {

    public static void print(String sp){
        try{
            synchronized (sp){
                while(true){
                    System.out.println(Thread.currentThread().getName());
                    Thread.sleep(1000);
                }
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
