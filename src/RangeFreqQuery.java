import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author kcy
 * @date 2021/11/21 10:46
 */
public class RangeFreqQuery {


    Map<Integer, List<Integer>> map;
    public RangeFreqQuery(int[] arr) {
        this.map = new HashMap<>();
        for(int i=0;i<arr.length;i++){
            if(map.containsKey(arr[i])){
                map.get(arr[i]).add(i);
            }else{
                map.put(arr[i],new ArrayList<>());
                map.get(arr[i]).add(i);
            }
        }
    }

    public int query(int left, int right, int value) {

        List<Integer> temp = map.get(value);
        if(temp==null)return 0;
        int i=0,j=temp.size()-1;
        if(temp.get(j)<left||temp.get(i)>right)return 0;
        while(i<j){
            //寻找左边端点所在的位置
            int mid = (j-i)/2+i;
            if(temp.get(mid)>=left){
                j=mid;
            }else{
                i=mid+1;
            }
        }
        int a=i;

        i=a;
        j=temp.size()-1;
        /*
        找到列表中从右往左第一个小于等于right的值的索引
         */
        while(i<j){
            int mid = (j-i)/2+i;
            if(temp.get(mid)<=right){
                i=mid;
            }else{
                j=mid-1;
            }
        }
        int b=j;
        return b-a+1;
    }
}
