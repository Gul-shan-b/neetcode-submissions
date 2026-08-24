class Solution {
    public int longestCommonSubsequence(String a, String b) {

        int m = a.length();
        int n = b.length();

        int[] dp = new int[n + 1];

        for (int i = 1; i <= m; i++) {

            int diagonal = 0;

            for (int j = 1; j <= n; j++) {

                int temp = dp[j];

                if (a.charAt(i - 1) == b.charAt(j - 1)) {
                    dp[j] = 1 + diagonal;
                } else {
                    dp[j] = Math.max(dp[j], dp[j - 1]);
                }

                diagonal = temp;
            }
        }

        return dp[n];
    }
}