class Solution {
    public List<List<Integer>> combinationSum2(int[] nums, int target) {
        List<List<Integer>> finalResult = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(0, nums, target, new ArrayList<>(), finalResult);
        return finalResult;
    }

    private void backtrack(int idx, int[] nums, int target, List<Integer> current, List<List<Integer>> finalResult) {
        if (target == 0) {
            finalResult.add(new ArrayList<>(current));
            return;
        }

        for (int i = idx; i < nums.length; i++) {
            if (i > idx && nums[i] == nums[i - 1]) continue;
            if (nums[i] > target) break;

            current.add(nums[i]);
            backtrack(i + 1, nums, target - nums[i], current, finalResult);
            current.remove(current.size() - 1);
        }
    }
}