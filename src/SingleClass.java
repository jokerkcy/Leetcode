/**
 * @author kcy
 * @date 2022/2/23 16:57
 */
public class SingleClass {

    private static volatile SingleClass instance;

    private SingleClass(){}

    public static SingleClass getInstance(){
        if(instance==null){
            synchronized (SingleClass.class){
                if(instance==null){
                    instance=new SingleClass();
                }
            }
        }
        return instance;
    }

}
