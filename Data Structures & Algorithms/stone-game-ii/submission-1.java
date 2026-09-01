class Solution {

    int[][] dp;
    int[] suffix;
    int n;

    public int stoneGameII(int[] piles) {

        n = piles.length;

        // Suffix sum
        suffix = new int[n + 1];

        for (int i = n - 1; i >= 0; i--) {
            suffix[i] = piles[i] + suffix[i + 1];
        }

        // dp[i][M]
        dp = new int[n][n + 1];

        for (int i = 0; i < n; i++) {
            for (int M = 1; M <= n; M++) {
                dp[i][M] = -1;
            }
        }

        return dfs(0, 1);
    }

    private int dfs(int i, int M) {

        // Can take all remaining piles
        if (2 * M >= n - i) {
            return suffix[i];
        }

        // Already calculated
        if (dp[i][M] != -1) {
            return dp[i][M];
        }

        int best = 0;

        for (int X = 1; X <= 2 * M; X++) {

            int opponent = dfs(
                i + X,
                Math.max(M, X)
            );

            int current = suffix[i] - opponent;

            best = Math.max(best, current);
        }

        dp[i][M] = best;

        return best;
    }
}