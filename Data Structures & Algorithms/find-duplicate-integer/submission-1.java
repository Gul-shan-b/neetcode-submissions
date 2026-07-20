class Solution {
    public int findDuplicate(int[] nums) {
        int s=nums[0], fast= nums[0];
        do{
            s = nums[s];
            fast =nums[nums[fast]];

        }while(s!=fast);
        s=nums[0];
        while(s!=fast){
            s=nums[s];
            fast=nums[fast];
        }
        return s;
    }
}