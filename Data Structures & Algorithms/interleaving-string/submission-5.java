/*1. Brute Force — Recursion
Logic

At each position, try taking the next character from either s1 or s2 and check whether it can form s3.

class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {

        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }

        return solve(s1, s2, s3, 0, 0, 0);
    }

    private boolean solve(String s1, String s2, String s3,
                          int i, int j, int k) {

        if (k == s3.length()) {
            return true;
        }

        boolean takeS1 = false;
        boolean takeS2 = false;

        if (i < s1.length() &&
            s1.charAt(i) == s3.charAt(k)) {
            takeS1 = solve(s1, s2, s3, i + 1, j, k + 1);
        }

        if (j < s2.length() &&
            s2.charAt(j) == s3.charAt(k)) {
            takeS2 = solve(s1, s2, s3, i, j + 1, k + 1);
        }

        return takeS1 || takeS2;
    }
}

Time: O(2^(m+n))
Space: O(m+n) — recursion stack

2. Normal — 2D DP
Logic

dp[i][j] tells whether the first i characters of s1 and first j characters of s2 can form the first i+j characters of s3.

class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {

        int m = s1.length();
        int n = s2.length();

        if (m + n != s3.length()) {
            return false;
        }

        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;

        for (int i = 1; i <= m; i++) {
            dp[i][0] = dp[i - 1][0] &&
                       s1.charAt(i - 1) == s3.charAt(i - 1);
        }

        for (int j = 1; j <= n; j++) {
            dp[0][j] = dp[0][j - 1] &&
                       s2.charAt(j - 1) == s3.charAt(j - 1);
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {

                int k = i + j - 1;

                dp[i][j] =
                    (dp[i - 1][j] &&
                     s1.charAt(i - 1) == s3.charAt(k))
                    ||
                    (dp[i][j - 1] &&
                     s2.charAt(j - 1) == s3.charAt(k));
            }
        }

        return dp[m][n];
    }
}

Time: O(m × n)
Space: O(m × n)

3. Optimized — 1D DP

This is the version you provided.

Logic

Use a single dp array because each state only needs the current value and the previous row's value.

class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {

        int m = s1.length();
        int n = s2.length();

        if (m + n != s3.length()) {
            return false;
        }

        boolean[] dp = new boolean[n + 1];
        dp[0] = true;

        for (int j = 1; j <= n; j++) {
            dp[j] = dp[j - 1] &&
                    s2.charAt(j - 1) == s3.charAt(j - 1);
        }

        for (int i = 1; i <= m; i++) {

            dp[0] = dp[0] &&
                    s1.charAt(i - 1) == s3.charAt(i - 1);

            for (int j = 1; j <= n; j++) {

                int k = i + j - 1;

                boolean s1s = dp[j] &&
                    s1.charAt(i - 1) == s3.charAt(k);

                boolean s2s = dp[j - 1] &&
                    s2.charAt(j - 1) == s3.charAt(k);

                dp[j] = s1s || s2s;
            }
        }

        return dp[n];
    }
}

Time: O(m × n)
Space: O(n)
*/
class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {

        int m = s1.length();
        int n = s2.length();

        if (m + n != s3.length()) {
            return false;
        }

        boolean[] dp = new boolean[n + 1];
        dp[0] = true;

        for (int j = 1; j <= n; j++) {
            dp[j] = dp[j - 1] &&
                    s2.charAt(j - 1) == s3.charAt(j - 1);
        }

        for (int i = 1; i <= m; i++) {

            dp[0] = dp[0] &&
                    s1.charAt(i - 1) == s3.charAt(i - 1);

            for (int j = 1; j <= n; j++) {

                int k = i + j - 1;

                boolean takeS1 = dp[j] &&
                        s1.charAt(i - 1) == s3.charAt(k);

                boolean takeS2 = dp[j - 1] &&
                        s2.charAt(j - 1) == s3.charAt(k);

                dp[j] = takeS1 || takeS2;
            }
        }

        return dp[n];
    }
}