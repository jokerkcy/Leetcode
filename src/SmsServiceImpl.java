/**
 * @author kcy
 * @date 2021/12/22 23:30
 */
public class SmsServiceImpl implements SmsService{
    @Override
    public String send(String message) {
        System.out.println("send message:"+message);
        return message;
    }
}
