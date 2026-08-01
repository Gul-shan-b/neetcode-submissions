class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        backtracking(0, nums, result, new ArrayList<>());

        return result;
    }
    private void backtracking(int start, int[] nums, List<List<Integer>> result, List<Integer> cur){
        if(result.contains(cur)){
            return;
        }

        result.add(new ArrayList<>(cur));

        for(int i=start; i< nums.length; i++){
            cur.add(nums[i]);
            backtracking(i+1, nums, result, cur);
            cur.remove(cur.size()-1);
        }
    }
}
