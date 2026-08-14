class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 1){
            return nums[0];
        }
        int prev1 = nums[0];
        int prev2 = 0;
        int ans =0;
        for(int i =2; i<n+1; i++){
            int pick = nums[i-1] + prev2;
            int notpick = 0+ prev1;
            ans = Math.max(pick, notpick);
            prev2 = prev1;
            prev1 = ans;
        }
        return ans ;
        
    }
}
