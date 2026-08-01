class Solution {

    public List<List<Integer>> permuteUnique(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();

        Arrays.sort(nums);

        backtracking(nums, result, new ArrayList<>(), new boolean[nums.length]);

        return result;
    }

    private void backtracking(int[] nums,
                              List<List<Integer>> result,
                              List<Integer> cur,
                              boolean[] used) {

        if (cur.size() == nums.length) {
            result.add(new ArrayList<>(cur));
            return;
        }

        for (int i = 0; i < nums.length; i++) {

            // Skip already used element
            if (used[i]) {
                continue;
            }

            // Skip duplicate elements
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                continue;
            }

            used[i] = true;
            cur.add(nums[i]);

            backtracking(nums, result, cur, used);

            cur.remove(cur.size() - 1);
            used[i] = false;
        }
    }
}