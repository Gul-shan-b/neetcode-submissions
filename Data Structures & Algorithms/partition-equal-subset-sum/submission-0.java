class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum =0;
        
        
        for(int num: nums){
            sum += num;
        }
        if(sum%2!=0){
            return false;
        }
        int target = sum/2;
        boolean[] dp = new boolean[target+1];
        dp[0] =true;
        for(int i:nums){
            for(int j =target; j>=i ; j--){
                if(dp[j-i]){
                    dp[j] = true;
                }
            }
        }
        return dp[target];

        
    }
}
