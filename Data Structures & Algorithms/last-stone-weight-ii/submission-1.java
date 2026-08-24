class Solution {
    public int lastStoneWeightII(int[] stones) {

        int totalSum = 0;

        for (int stone : stones) {
            totalSum += stone;
        }

        int target = totalSum / 2;

        boolean[] dp = new boolean[target + 1];

        dp[0] = true;

        for (int stone : stones) {

            for (int sum = target; sum >= stone; sum--) {

                dp[sum] = dp[sum] || dp[sum - stone];
            }
        }

        for (int sum = target; sum >= 0; sum--) {

            if (dp[sum]) {
                return totalSum - 2 * sum;
            }
        }

        return 0;
    }
}