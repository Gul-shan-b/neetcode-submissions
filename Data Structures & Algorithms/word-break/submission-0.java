class Solution {
    HashSet<String> set = new HashSet<>();
    public boolean wordBreak(String s, List<String> wordDict) {
     set.addAll(wordDict);  
     int n = s.length();
     boolean[] dp = new boolean[n+1];
     dp[0]= true;
     for(int i =1; i<=n; i++){
        for(int j =0; j<i; j++){
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
