class Solution {
    public boolean stoneGame(int[] piles) {

        int n = piles.length;
        int[] dp = new int[n];

        // Base case: one pile
        for (int i = 0; i < n; i++) {
            dp[i] = piles[i];
        }

        // Consider intervals of increasing length
        for (int l = n - 2; l >= 0; l--) {

            for (int r = l + 1; r < n; r++) {

                // Maximum score difference for piles[l...r]
                dp[r] = Math.max(
                    piles[l] - dp[r],
                    piles[r] - dp[r - 1]
                );
            }
        }

        // Positive difference means Alice wins
        return dp[n - 1] > 0;
    }
}