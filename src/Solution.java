import java.util.Arrays;
//n=number of throws,k=number of faces on the dice, target=target to roll

public class Solution {

public static void main (String[] args) {
    Solution solution = new Solution();
    int result1=solution.numRollsToTarget(1,6,3);
    int result2=solution.numRollsToTarget(2,6,7);
    int result3=solution.numRollsToTarget(30,30,500);
    System.out.println(result1);
    System.out.println(result2);
    System.out.println(result3);

}
    public int numRollsToTarget(int n, int k, int target) {

        int[][] dp = new int[n + 1][target + 1];


        dp[0][0] = 1;

        for (int dice = 1; dice <= n; dice++) {
            for (int sum = 1; sum <= target; sum++) {
                dp[dice][sum] = 0;
                for (int face = 1; face <= k; face++) {
                    if (sum - face >= 0) {
                        dp[dice][sum] = (dp[dice][sum] + dp[dice - 1][sum - face]) % 1000000007;
                    }
                }
            }
        }
        for(int i=0 ; i < dp.length;i++){
            System.out.println(Arrays.toString(dp[i]));
        }
        return dp[n][target];
    }
}
