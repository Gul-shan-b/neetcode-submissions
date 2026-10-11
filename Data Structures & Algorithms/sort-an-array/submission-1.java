class Solution {
    public int[] sortArray(int[] nums) {
        merge(nums,0, nums.length-1);
        return nums;
        
    }
    public void merge(int[] nums, int l, int r){
        while(l>=r){
            return;

        }
        int m = (l+r)/2;
        merge(nums, l,m);
        merge(nums,m+1, r);
        mergesort(nums, l, r, m);
    }
    public void mergesort(int[] nums, int l, int r, int m){
        int i =l;
        int j = m+1;
        List<Integer> temp = new ArrayList<>();
        while(i<=m && j<=r){
            if(nums[i]<nums[j]){
                temp.add(nums[i]);
                i++;

            }
            else{
                temp.add(nums[j]);
                j++;
            }
        }
        while(i<=m){
            temp.add(nums[i]);
            i++;
        }
        while(j<=r){
            temp.add(nums[j]);
            j++;
        }
        for(int k= l; k<=r; k++){
            nums[k] = temp.get(k-l);

        }
    }

}