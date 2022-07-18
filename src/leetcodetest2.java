import java.util.Arrays;

/**
 * @author kcy
 * @date 2021/8/12 23:56
 */
public class leetcodetest2 {

    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
    }

    class ListNode {
        int val;
        ListNode next;
        ListNode random;

        public ListNode(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        int ans = splitArray(new int[]{7,2,5,10,8},2);
        System.out.println(ans);
    }

    public static int splitArray(int[] nums, int m) {
        int n = nums.length;
        //dp[i][k]代表nums从0到i,分割成k个子数组，最大和的最小值
        //状态转移方程：dp[i][k]=Math.min(dp[j][k-1],sum(j+1,i));
        int[][] dp = new int[n][m+1];
        int[] sums = new int[n];
        for(int[] a:dp){
            Arrays.fill(a,Integer.MAX_VALUE);
        }
        sums[0]=nums[0];
        dp[0][1]=nums[0];
        for(int i=1;i<n;i++){
            sums[i]=sums[i-1]+nums[i];
            dp[i][1]=sums[i];
        }

        for(int i=0;i<n;i++){
            for(int k=2;k<=m;k++){
                if(i+1<k)continue;
                for(int j=0;j<i;j++){
                    dp[i][k]=Math.min(dp[i][k],Math.max(dp[j][k-1],sums[i]-sums[j]));
                }
            }
        }
        return dp[n-1][m];
    }



}
