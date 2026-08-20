class Solution {
    HashSet<String> set = new HashSet<>();
    public boolean wordBreak(String s, List<String> wordDict) {
     set.addAll(wordDict); 
     int max = 0;
     for(String word : wordDict){
        max = Math.max(max, word.length());
     }

     int n = s.length();
     boolean[] dp = new boolean[n+1];
     dp[0]= true;

     for(int i =1; i<=n; i++){
        int start = Math.max(0, i - max);
        for(int j =start; j<i; j++){
            String cur = s.substring(j,i);
            if(set.contains(cur)&& dp[j]==true){
                dp[i] = true;
                break;
            }
        }
     }
     return dp[n];
    }
}
