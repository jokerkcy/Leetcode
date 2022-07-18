import java.lang.reflect.Proxy;

/**
 * @author kcy
 * @date 2021/12/23 14:41
 */
public class JdkProxyFactory {
    public static Object getProxy(Object target){
        return Proxy.newProxyInstance(
          target.getClass().getClassLoader(),
          target.getClass().getInterfaces(),
          new DebugInvocationHandler(target)
        );
    }
}
