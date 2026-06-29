class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        ArrayList<List<Integer>> res = new ArrayList<List<Integer>>();
        int n = nums.length;
        Arrays.sort(nums);
        if(nums == null|| nums.length ==0){
            return res;
        }
        for(int i =0; i<n; i++){
            for(int j= i+1; j<n; j++){
                long target2 = (long)target- nums[i]-nums[j];

                int left = j+1;
                int right = n-1;
                while(left<right){
                    long sum = (long)nums[left] + nums[right];
                    if(sum<target2){
                        left++;
                    }
                    else if(sum> target2){
                        right--;
                    }

                    else{
                        List<Integer> x = new ArrayList<>();
                        x.add(nums[i]);
                        x.add(nums[j]);
                        x.add(nums[left]);
                        x.add(nums[right]);
                        res.add(x);

                        while(left<right && nums[left]== x.get(2)) ++left;
                        while(left<right && nums[right] == x.get(3)) -- right;
                    }

                }
                while(j+1<n && nums[j+1]== nums[j]) ++j;
            }
            while(i+1<n && nums[i+1]== nums[i]) ++i;
        }
        return res;

        
    }
}