class Solution {
    int x, y;
    Boolean[][] dp;

    public boolean isInterleave(String s1, String s2, String s3) {

        x = s1.length();
        y = s2.length();

        if (x + y != s3.length()) {
            return false;
        }

        dp = new Boolean[x + 1][y + 1];

        return solve(0, 0, s1, s2, s3);
    }

    private boolean solve(int i, int j,
                          String s1, String s2, String s3) {

        // All characters used
        if (i == x && j == y) {
            return true;
        }

        // Already calculated
        if (dp[i][j] != null) {
            return dp[i][j];
        }

        int k = i + j;

        boolean result = false;

        // Take character from s1
        if (i < x && s1.charAt(i) == s3.charAt(k)) {
            result = solve(i + 1, j, s1, s2, s3);
        }

        // Take character from s2
        if (!result && j < y && s2.charAt(j) == s3.charAt(k)) {
            result = solve(i, j + 1, s1, s2, s3);
        }

        return dp[i][j] = result;
    }
}