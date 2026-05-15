class Solution {
    public int longestConsecutive(int[] nums) {
        int res =0;
        Set<Integer> store = new HashSet<>();
        for(int num:nums){
            store.add(num);
        }
        for(int num: nums){
            int streak = 0, cur = num;
            while(store.contains(cur)){
                streak++;
                cur++;
            }
            res = Math.max(res,streak);
        }
        return res;
        
    }
}
