class Solution {
    public int maxProfit(int[] prices) {
        int t =0; 
        for(int i =1; i<prices.length; i++){
            int dp = prices[i]-prices[i-1];
            t += Math.max(0,dp);
        }
        return t;
        
    }
}