/*Brute Force — Recursion
Idea

For every number, we have 2 choices:

Add +num
Add -num

So we explore all possible combinations.

class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        return solve(nums, target, 0, 0);
    }

    private int solve(int[] nums, int target, int index, int sum) {

        // All numbers are processed
        if (index == nums.length) {
            return sum == target ? 1 : 0;
        }

        // Choice 1: add +
        int add = solve(nums, target, index + 1, sum + nums[index]);

        // Choice 2: add -
        int subtract = solve(nums, target, index + 1, sum - nums[index]);

        return add + subtract;
    }
}

Normal — Recursion + Memoization

import java.util.HashMap;

class Solution {
    public int findTargetSumWays(int[] nums, int target) {

        HashMap<String, Integer> memo = new HashMap<>();

        return solve(nums, target, 0, 0, memo);
    }

    private int solve(int[] nums, int target, int index,
                      int sum, HashMap<String, Integer> memo) {

        if (index == nums.length) {
            return sum == target ? 1 : 0;
        }

        String key = index + "," + sum;

        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        int add = solve(
            nums, target, index + 1,
            sum + nums[index], memo
        );

        int subtract = solve(
            nums, target, index + 1,
            sum - nums[index], memo
        );

        int result = add + subtract;

        memo.put(key, result);

        return result;
    }
}

Optimized — 1D DP / Subset Sum
class Solution {
    public int findTargetSumWays(int[] nums, int target) {

        int sum = 0;

        for (int num : nums) {
            sum += num;
        }

        // Impossible cases
        if (Math.abs(target) > sum) {
            return 0;
        }

        if ((sum + target) % 2 != 0) {
            return 0;
        }

        int subsetTarget = (sum + target) / 2;

        int[] dp = new int[subsetTarget + 1];

        dp[0] = 1;

        for (int num : nums) {

            for (int j = subsetTarget; j >= num; j--) {

                dp[j] += dp[j - num];
            }
        }

        return dp[subsetTarget];
    }
}
*/

class Solution {
    public int findTargetSumWays(int[] nums, int target) {

        int sum = 0;

        for (int num : nums) {
            sum += num;
        }

        // Impossible cases
        if (Math.abs(target) > sum) {
            return 0;
        }

        if ((sum + target) % 2 != 0) {
            return 0;
        }

        int subsetTarget = (sum + target) / 2;

        int[] dp = new int[subsetTarget + 1];

        dp[0] = 1;

        for (int num : nums) {

            for (int j = subsetTarget; j >= num; j--) {

                dp[j] += dp[j - num];
            }
        }

        return dp[subsetTarget];
    }
}