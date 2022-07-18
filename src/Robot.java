/**
 * @author kcy
 * @date 2021/11/13 22:36
 */
public class Robot {
    int width;
    int height;
    int x=0;
    int y=0;
    int dir = 0;
    int c = 0;
    public Robot(int width, int height) {
        this.width=width;
        this.height=height;
        this.c = (width+height)*2;
    }

    public void move(int num) {
        num%=c;
        if(num==0)return;
        if(dir==0){
            if(num+x<width){
                x+=num;
            }else{
                num-=width-1-x;
                x=width-1;
                dir=1;
                move(num);
            }
        }else if(dir==1){
            if(num+y<height){
                y+=num;
            }else{
                num-=height-1-y;
                y=height-1;
                dir=2;
                move(num);
            }
        }else if(dir==2){
            if(x-num>=0){
                x-=num;
            }else{
                num-=x;
                x=0;
                dir=3;
                move(num);
            }
        }else{
            if(y-num>=0){
                y-=num;
            }else{
                num-=y;
                y=0;
                dir=0;
                move(num);
            }
        }
    }

    public int[] getPos() {
        return new int[]{x,y};
    }

    public String getDir() {
        if(dir==0)return "East";
        else if(dir==1)return "North";
        else if(dir==2)return "West";
        else return "South";
    }
}
