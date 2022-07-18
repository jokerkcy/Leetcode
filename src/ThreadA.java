/**
 * @author kcy
 * @date 2022/3/1 19:12
 */
public class ThreadA extends Thread{
    private Service service;
    public ThreadA(Service service){
        super();
        this.service=service;
    }


    @Override
    public void run(){
        service.print("AA");
    }
}
