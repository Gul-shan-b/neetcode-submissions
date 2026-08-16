class Solution {
    public int minCostClimbingStairs(int[] cost) {
        
        int n = cost.length;
        
        int prev2 =0;
        int prev1 = 0;
        int ans =0;
        for(int i =2; i<=n; i++){
            int onestep = cost[i-1]+prev1;
            int secondstep= cost[i-2]+prev2;
            ans = Math.min(onestep, secondstep);
            prev2 = prev1;
            prev1 = ans;

        }
        return ans;
        
    }
}
