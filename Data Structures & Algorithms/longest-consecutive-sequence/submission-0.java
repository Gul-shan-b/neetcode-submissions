class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int count=0;
        for(int i: nums){
            set.add(i);
        }
        for(int j:set){
            if(!set.contains(j-1)){
                int length =1;
                while(set.contains(j+length)){
                    length++;
                }
                count = Math.max(count,length);
            }
        }
        return count;
        
    }
}
