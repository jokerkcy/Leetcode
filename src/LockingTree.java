import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author kcy
 * @date 2021/9/4 23:03
 */
public class LockingTree {
    public class tree{
        int value;
        tree left;
        tree right;
        int userid;
        boolean islock;

        public tree(int value) {
            this.value=value;
        }
    }
    tree parent0;
    public LockingTree(int[] parent) {
        Deque<tree> stack = new ArrayDeque<>();
        int index = 0;
        this.parent0 = new tree(0);
        stack.add(parent0);
        while(index<parent.length&&!stack.isEmpty()){
            tree temp = stack.pop();
            temp.left = new tree(index);
            index++;
            stack.add(temp.left);
            temp.right = new tree(index);
            index++;
            stack.add(temp.right);
        }
    }

    public boolean lock(int num, int user) {
        Deque<tree> stack = new ArrayDeque<>();
        if(parent0.value==num){
            if(parent0.islock)
                return false;
            else {
                parent0.islock=true;
                parent0.userid=user;
                return true;
            }
        }else{
            stack.add(parent0);
            while(!stack.isEmpty()){
                tree temp = stack.pop();
                if(temp.left.value==num){
                    if(temp.left.islock)
                        return false;
                    else {
                        temp.left.islock=true;
                        temp.left.userid=user;
                        return true;
                    }
                }else{
                    stack.add(temp.left);
                }
                if(temp.right.value==num){
                    if(temp.right.islock)
                        return false;
                    else {
                        temp.right.islock=true;
                        temp.right.userid=user;
                        return true;
                    }
                }else{
                    stack.add(temp.right);
                }
            }
        }
        return false;
    }

    public boolean unlock(int num, int user) {
        Deque<tree> stack = new ArrayDeque<>();
        if(parent0.value==num){
            if(parent0.islock&&parent0.userid==user){
                parent0.islock=false;
                return true;
            }else
                return false;
        }else{
            stack.add(parent0);
            while(!stack.isEmpty()){
                tree temp = stack.pop();
                if(temp.left.value==num){
                    if(temp.left.islock&&temp.left.userid==user){
                        temp.left.islock=false;
                        return true;
                    }else
                        return false;
                }else{
                    stack.add(temp.left);
                }
                if(temp.right.value==num){
                    if(temp.right.islock&&temp.right.userid==user){
                        temp.right.islock=false;
                        return true;
                    }else
                        return false;
                }else{
                    stack.add(temp.right);
                }
            }
        }
        return false;
    }


}
