/*1. Brute Force — Recursion

Tries both choices: take the current coin or skip it.

class Solution {
    int n;

    int solve(int i, int[] coins, int amount) {

        if (amount == 0) return 1;
        if (i == n) return 0;

        if (coins[i] > amount) {
            return solve(i + 1, coins, amount);
        }

        int take = solve(i, coins, amount - coins[i]);
        int skip = solve(i + 1, coins, amount);

        return take + skip;
    }

    public int change(int amount, int[] coins) {
        n = coins.length;
        return solve(0, coins, amount);
    }
}
2. Normal — Memoization

Stores already calculated (coin index, amount) states to avoid repeated recursion.

class Solution {
    int n;
    int[][] dp;

    int solve(int i, int[] coins, int amount) {

        if (amount == 0) return 1;
        if (i == n) return 0;

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

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return solve(0, coins, amount);
    }
}
3. Optimized — 1D DP

Uses a single array to reduce space from O(n × amount) to O(amount).

class Solution {

    public int change(int amount, int[] coins) {

        int[] dp = new int[amount + 1];

        dp[0] = 1;

        for (int coin : coins) {

            for (int j = coin; j <= amount; j++) {

                dp[j] += dp[j - coin];
            }
        }

        return dp[amount];
    }
}
Quick memory trick
Brute Force  → Recursion
Normal       → Recursion + 2D DP
Optimized    → 1D DP

*/



class Solution {

    public int change(int amount, int[] coins) {

        int[] dp = new int[amount + 1];

        dp[0] = 1;

        for (int coin : coins) {

            for (int j = coin; j <= amount; j++) {

                dp[j] += dp[j - coin];
            }
        }

        return dp[amount];
    }
}