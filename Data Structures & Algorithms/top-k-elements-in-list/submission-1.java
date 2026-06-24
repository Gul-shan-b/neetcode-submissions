class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> f = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            f.put(nums[i], f.getOrDefault(nums[i], 0) + 1);
        }
        
        List<int[]> p = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : f.entrySet()) {
            p.add(new int[]{entry.getValue(), entry.getKey()});
        }
        
        p.sort((a, b) -> Integer.compare(b[0], a[0]));
        
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = p.get(i)[1];
        }
        return res;
    }
}