/*
You are given coins of different denominations and a total amount of money amount. Write a function to compute the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.

Example 1:
coins = [1, 2, 5], amount = 11
return 3 (11 = 5 + 5 + 1)

Example 2:
coins = [2], amount = 3
return -1.

Note:
You may assume that you have an infinite number of each kind of coin.
*/

public class Solution {
    public int coinChange(int[] coins, int amount) {
        if(coins.length == 0 || amount <= 0){
            return 0;
        }
        int [] dp = new int [amount+1];
        dp[0] = 0;
        for(int i = 1;i <= amount;i++){
            dp[i] = amount+1;
        }
        
        for(int i = 1;i <= amount;i++){
            for(int j = 0;j < coins.length;j++){
                if(coins[j] <= i && dp[i] > dp[i-coins[j]]+1){
                    dp[i] = dp[i-coins[j]]+1;
                }
            }
        }
        
        return dp[amount] == amount+1?-1:dp[amount];
    }
}

public class Solution {
        public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        if(n == 0){
            return 0;
        }
        int [][] dp = new int [n][amount+1];
        dp[0][0] = 0;
        for(int j = 0;j <= amount;j++){
            dp[0][j] = j%coins[0]==0?j/coins[0]:-1;
        }
        for(int i = 1;i < n;i++){
            for(int j = 1;j <= amount;j++){
                dp[i][j] = dp[i-1][j];
                if(coins[i] <= j && dp[i][j-coins[i]] !=-1 && (dp[i][j] == -1 || dp[i][j] > dp[i][j-coins[i]] + 1)){
                    dp[i][j] = dp[i][j-coins[i]]+1;
                }
            }
        }
        return dp[n-1][amount];
    }
}
