class Solution {
    public int majorityElement(int[] nums) {
        int candidate =0;
        int balence =0;
        for(int i: nums){
            
            if(balence==0){
                candidate = i;

            }
            if(candidate==i){
                balence++;

            }
            else{
                balence--;
            }
        }
        return candidate;
    }
}