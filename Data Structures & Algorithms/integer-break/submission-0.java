class Solution {
    public int integerBreak(int n) {
        int[] dp = new int[n+1];
        dp[0]=0;
        dp[1] =1;
        for(int i =2; i<=n; i++){
            for(int j =1; j<i; j++){
                int notbreak = j*(i-j);
                int breakpart = j* dp[i-j];
                dp[i] = Math.max(dp[i],Math.max(notbreak, breakpart));
            }
        }
        return dp[n];
        
    }
}