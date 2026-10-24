class Solution {
    public int characterReplacement(String s, int k) {
        int n = s.length();
        HashMap<Character,Integer> map = new HashMap<>();
        int left =0;
        int right =0;
        int count =0;
        int maxfre =0;
        while(right<n){
            char ch = s.charAt(right);
            map.put(ch,map.getOrDefault(s.charAt(right),0)+1);
            maxfre = Math.max(maxfre,map.get(ch));

            if((right-left+1)-maxfre>k){
                char leftchar = s.charAt(left);
                map.put(leftchar,map.get(leftchar)-1);
                left++;
            }
            count = Math.max(count,right-left+1);
            right++;
        }
        

        return count;
    }
}
