/**
 * @author kcy
 * @date 2022/3/1 19:14
 */
public class ThreadB extends Thread{
    private Service service;
    public ThreadB(Service service){
        super();
        this.service=service;
    }

    @Override
    public void run(){
        service.print("AA");
    }

}
