/*1. Brute Force — Recursion
Logic

Try every possible way of assigning each stone to either group and find the minimum difference between the two group sums.

class Solution {
    public int lastStoneWeightII(int[] stones) {
        return solve(stones, 0, 0);
    }

    private int solve(int[] stones, int index, int sum) {
        if (index == stones.length) {
            int total = 0;
            for (int stone : stones) {
                total += stone;
            }
            return Math.abs(total - 2 * sum);
        }

        int take = solve(stones, index + 1, sum + stones[index]);
        int skip = solve(stones, index + 1, sum);

        return Math.min(take, skip);
    }
}

Time: O(2^n × n)
Space: O(n) recursion stack

2. Normal — 2D DP
Logic

Find the maximum subset sum that is at most totalSum / 2, then the remaining difference is the minimum possible final stone weight.

class Solution {
    public int lastStoneWeightII(int[] stones) {

        int n = stones.length;
        int totalSum = 0;

        for (int stone : stones) {
            totalSum += stone;
        }

        int target = totalSum / 2;

        boolean[][] dp = new boolean[n + 1][target + 1];

        for (int i = 0; i <= n; i++) {
            dp[i][0] = true;
        }

        for (int i = 1; i <= n; i++) {
            for (int sum = 1; sum <= target; sum++) {

                dp[i][sum] = dp[i - 1][sum];

                if (sum >= stones[i - 1]) {
                    dp[i][sum] =
                        dp[i][sum] ||
                        dp[i - 1][sum - stones[i - 1]];
                }
            }
        }

        for (int sum = target; sum >= 0; sum--) {
            if (dp[n][sum]) {
                return totalSum - 2 * sum;
            }
        }

        return 0;
    }
}

Time: O(n × target)
Space: O(n × target)

3. Optimized — 1D DP
Logic

Use a 1D subset-sum DP to find the largest achievable sum up to totalSum / 2, minimizing the difference between the two groups.

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

Time: O(n × target)
Space: O(target)
*/
class Solution {
    public int lastStoneWeightII(int[] stones) {
        int total = 0;
        for(int stone : stones){
            total += stone;
        }
        int best = 0;
        for(int i=total/2;i>=0;i--){
            if(f(0,i,stones)){
                best = i;
                break;
            }
        }
        return total - 2*best;
    }
    boolean f(int idx,int sum,int[] stones){
        if(sum == 0) return true;
        if(idx >= stones.length || sum < 0) return false;
        return f(idx+1,sum-stones[idx],stones) || f(idx+1,sum,stones);
    }
}