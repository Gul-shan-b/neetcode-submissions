/*

class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m+1][n+1];
        //dp[0][0] =0;
        

        for(int i =0; i<=m; i++){
            dp[i][0] = i;
        }

        for(int j =0; j<=n; j++){
            dp[0][j] = j;
        }

        for(int i =1; i<=m; i++){
            for(int j =1; j<=n; j++){
                if(word1.charAt(i-1)== word2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                }
                else{
                    dp[i][j] = 1+ Math.min(dp[i-1][j], Math.min(dp[i-1][j-1], dp[i][j-1]));
                }
            }
        }
        return dp[m][n];
        
    }
}

Optimized Code
class Solution {
    public int minDistance(String word1, String word2) {

        int m = word1.length();
        int n = word2.length();

        int[] dp = new int[n + 1];

        for (int j = 0; j <= n; j++) {
            dp[j] = j;
        }

        for (int i = 1; i <= m; i++) {

            int diagonal = dp[0];
            dp[0] = i;

            for (int j = 1; j <= n; j++) {

                int temp = dp[j];

                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[j] = diagonal;
                } else {
                    dp[j] = 1 + Math.min(
                        diagonal,
                        Math.min(dp[j], dp[j - 1])
                    );
                }

                diagonal = temp;
            }
        }

        return dp[n];
    }
} 

class Solution {
    public int minDistance(String word1, String word2) {

        int m = word1.length();
        int n = word2.length();

        int[] dp = new int[n + 1];

        for (int j = 0; j <= n; j++) {
            dp[j] = j;
        }

        for (int i = 1; i <= m; i++) {

            int diagonal = dp[0];
            dp[0] = i;

            for (int j = 1; j <= n; j++) {

                int temp = dp[j];

                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[j] = diagonal;
                } else {
                    dp[j] = 1 + Math.min(
                        diagonal,
                        Math.min(dp[j], dp[j - 1])
                    );
                }

                diagonal = temp;
            }
        }

        return dp[n];
    }
} */
class Solution {
    public int f(String word1,String word2,int i,int j,int[][]dp){
        if(i == 0){
            return j;
        }
        if(j == 0){
            return i;
        }

        

        if(dp[i][j] == 0){
            if(word1.charAt(i - 1) == word2.charAt(j - 1)){
                dp[i][j] = f(word1,word2,i-1,j-1,dp);
                return dp[i][j];
            }
            else{
                dp[i][j] =  1 + Math.min(f(word1,word2,i-1,j,dp),Math.min(f(word1,word2,i,j - 1,dp),f(word1,word2,i-1,j-1,dp)));
                return dp[i][j];
            }  
        }
        else{
            return dp[i][j];
        }
    }
    public int minDistance(String word1, String word2) {
        int i = word1.length();
        int j = word2.length();

        int dp[][] = new int[i+1][j+1];

        return f(word1,word2,i,j,dp);


        
    }
}