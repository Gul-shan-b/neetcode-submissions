class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtracking( nums, result, new ArrayList<>());
        
        return result;       
    }

    private void backtracking(int[] nums, List<List<Integer>> result, List<Integer> cur){
        if(cur.size()== nums.length){
            result.add(new ArrayList<>(cur));
            return;

        }
        
        for(int i:nums){
            if(cur.contains(i)){
                continue;
            }
            cur.add(i);
            backtracking(nums, result, cur);
            cur.remove(cur.size()-1);
        }

    }
}
