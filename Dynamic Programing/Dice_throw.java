/**
 * Dice_throw
 */
import java.util.Arrays;
public class Dice_throw {
    final  int mod = (int) Math.pow(10, 9) + 7;
    public Dice_throw(){

    }
    
    public  int numRollsToTarget(int n, int k, int target){
        int[][] dp = new int[n+1][target+1];
        for (int[] d : dp) {
            Arrays.fill(d, -1);
        }
        // bruteforce approach 
        return recursion(dp, n, k, target);
    }

    private int recursion(int[][] dp, int n, int k, int target) {
        // base case
        if(target == 0 && n == 0 ) return 1; //there is exactly one way to achieve this - return 1
        if(n == 0 || target <= 0) return 0;

        if(dp[n][target] != -1) { // If the result for the current state is already calculated (dp[n][target] != -1), return the stored result.
            return (int) (dp[n][target] % mod);
        }
        int ways = 0;
        for (int i = 1; i <= k; i++) {
            ways = (ways + recursion(dp, n-1, k, target-i)) % mod;
        }
        dp[n][target] = ways % mod; // Return the final count of ways modulo 10^9 + 7 to handle large values and provide the result.
        return dp[n][target]; 
    }

    public int numRollsToTargetOptamized(int n, int k, int target) {
        long mod = (long) Math.pow(10, 9) + 7;

        long[] prev = new long[target + 1];
        long[] curr = new long[target + 1];

        prev[0] = 1;

        //Uses dynamic programming to calculate the number of ways to achieve the target sum 'j' using 'i' dice rolls.

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= target; j++) {
                long ans = 0;
                for (int x = 1; x <= k; x++) { // The innermost loop iterates through all possible outcomes of a single dice roll to calculate the number of ways to reach the current sum
                    if (j - x >= 0) { // ut quite possible that  if target is less than the face value od dice then [j-x] is -ive in that casae we have to calculate only till dice(k) <= target
                        ans += prev[j - x] % mod; 
                    }
                }
                //Updates prev and curr arrays to move to the next dice roll iteration.
                curr[j] = ans;
            }  
            prev = curr.clone();
        }
        return (int) (prev[target] % mod);
    }

    public static void main(String[] args) {
        Dice_throw ways = new Dice_throw();
        int ans = ways.numRollsToTarget(30, 30, 500);
        System.out.println(ans);
    }
}