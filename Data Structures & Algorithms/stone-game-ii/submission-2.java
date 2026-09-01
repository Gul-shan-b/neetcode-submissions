class Solution {
    int[] prefix;
    int[][]dp;
    public int stoneGameII(int[] piles) {
        dp = new int[piles.length][piles.length];
        prefix = new int[piles.length+1];

        for (int i = 1; i < piles.length+1; i++) {
            prefix[i] = prefix[i-1]+piles[i-1];
        }

        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp.length; j++) {
                dp[i][j] = -1;
            }
        }

        return helper(piles, 0, 1);
    }

    public int helper(int[] piles, int i, int m) {
        if(piles.length-i <= 2*m) {
            return prefix[piles.length]-prefix[i];
        }

        if(dp[i][m] != -1) return dp[i][m];
        int res = -1;

        for (int k = 1; k <= 2*m; k++) {
            res = Math.max(res, prefix[piles.length] - prefix[i] - helper(piles, i+k, Math.max(m, k)));
        }

        dp[i][m] = res;

        return dp[i][m];
    }
}  