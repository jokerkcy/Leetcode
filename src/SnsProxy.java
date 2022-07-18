/**
 * @author kcy
 * @date 2021/12/22 23:32
 */
public class SnsProxy implements SmsService{
    private final SmsService smsService;

    public SnsProxy(SmsService smsService) {
        this.smsService = smsService;
    }

    @Override
    public String send(String message) {
        //调用方法之前，我们可以添加自己的操作
        System.out.println("before method send()");
        smsService.send(message);
        System.out.println("after method send()");
        return null;
    }
}
