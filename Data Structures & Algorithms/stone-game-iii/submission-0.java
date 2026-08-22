class Solution {
    public String stoneGameIII(int[] stoneValue) {
        int n = stoneValue.length;
        int[] dp = new int[n+1];
        dp[n] =0;
        for(int i =n-1; i>=0; i--){
            int best = Integer.MIN_VALUE;

            int t1 = stoneValue[i]- dp[i+1];
            best = Math.max(best,t1);


            if(i+1<n){
                int t2 = stoneValue[i] + stoneValue[i+1]- dp[i+2];
                best = Math.max(best, t2);
            }
            
            if(i+2<n){
                int t3 = stoneValue[i] +stoneValue[i+1] + stoneValue[i+2] - dp[i+3];
            best = Math.max(best,t3);
            }
            
            dp[i] = best;
            
        }  
        if (dp[0] > 0) {
            return "Alice";
        } else if (dp[0] < 0) {
            return "Bob";
        } else {
            return "Tie";
        }
 
    }
}