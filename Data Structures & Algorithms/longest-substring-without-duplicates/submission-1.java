class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int count=0;
        HashMap<Character,Integer> map = new HashMap<>();
        int left =0;
        int right =0;
        while(right<n){
            if(map.containsKey(s.charAt(right))){
                left = Math.max(left, map.get(s.charAt(right))+1);
            }
            map.put(s.charAt(right),right);

            
            count = Math.max(count,right-left+1);
            right++;
            
        }

        
        return count;
        
    }
}
