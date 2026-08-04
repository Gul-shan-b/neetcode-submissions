class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int n = nums.length;
        Arrays.sort(nums);
        int l=0, r= n-1;
        while(l<r){
            int temp = nums[l];
            nums[l] = nums[r];
            nums[r] = temp;
            l++;
            r--;
        }

        int sum = Arrays.stream(nums).sum();
        if(sum%k != 0){
            return false;
        }
        int target = sum/k;

        if(nums[0]>target){
            return false;
        }
        int[] sums = new int[k];
        return backtrack(nums, k,sums, target,0);
        
    }

   private boolean backtrack(int[] nums, int k, int[] sums, int target, int index){

    if(index == nums.length){
        return true;
    }

    for(int i = 0; i < sums.length; i++){

        if(i > 0 && sums[i] == sums[i-1]){
            continue;
        }

        if(sums[i] + nums[index] > target){
            continue;
        }

        sums[i] += nums[index];

        if(backtrack(nums, k, sums, target, index + 1)){
            return true;
        }

        sums[i] -= nums[index];

        if(sums[i] == 0){
            break;
        }
    }

    return false;
}
}