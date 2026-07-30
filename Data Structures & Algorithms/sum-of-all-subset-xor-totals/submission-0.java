class Solution {
    public int subsetXORSum(int[] nums) {
        return findxor(nums, 0,0);

        
    }
    private int findxor(int[] nums, int index, int xor){
        if(index== nums.length){
            return xor;
        }
        int pick = findxor(nums, index+1,xor ^nums[index]);
        int notpick = findxor(nums, index+1, xor);
        int sum = pick + notpick;
        return sum;
    }
}