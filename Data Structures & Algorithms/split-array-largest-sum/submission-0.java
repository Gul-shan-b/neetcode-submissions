class Solution {
    public int splitArray(int[] nums, int k) {
        int min =0;
        int max =0;
        for(int num: nums){
            min = Math.max(min, num);
            max += num;
        }
        while(min<max){
            int mid = min+(max-min)/2;

            if(calcpart(nums, k, mid)){
                max = mid;
            }
            else{
                min = mid+1;
            }
        }
        return min;
    }
    private boolean calcpart(int[] nums, int k, int mid){
        int count =0;
        int part =1;
        for(int num:nums){
            if(num+count>mid){
                part++;
                count = num;
            }
            else{
                count +=num;
            }
        }
        return part<= k;
    }
}