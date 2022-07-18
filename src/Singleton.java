/**
 * @author kcy
 * @date 2022/3/14 15:37
 */
public class Singleton {

    private Singleton(){};

    private static class  SingleIn{
        private static final Singleton instance = new Singleton();
    }

    public static Singleton getInstance(){
        return SingleIn.instance;
    }


}
