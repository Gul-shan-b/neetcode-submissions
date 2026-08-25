class Solution {

    int n;
    int[][] dp;

    int solve(int i, int[] coins, int amount) {

        if (amount == 0) {
            return 1;
        }

        if (i == n) {
            return 0;
        }

        if (dp[i][amount] != -1) {
            return dp[i][amount];
        }

        if (coins[i] > amount) {
            return dp[i][amount] =
                    solve(i + 1, coins, amount);
        }

        int take = solve(i, coins, amount - coins[i]);

        int skip = solve(i + 1, coins, amount);

        return dp[i][amount] = take + skip;
    }

    public int change(int amount, int[] coins) {

        n = coins.length;

        dp = new int[n][amount + 1];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }

        return solve(0, coins, amount);
    }
}