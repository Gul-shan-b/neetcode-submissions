class Solution {
    public int coinChange(int[] coins, int amount) {
        
        int [] dp = new int[amount+1];
        Arrays.fill(dp,amount+1);
        dp[0] =0;
        for(int i =1; i<=amount; i++){
            for(int coin:coins){
                if(coin<=i){
                    int remaining = i-coin;
                    int candidate = 1+dp[remaining];
                    dp[i] = Math.min(dp[i], candidate);
                }
            }
        

        }
        if(dp[amount]==amount+1){
            return -1;
        }
        return dp[amount];
  
    }
}