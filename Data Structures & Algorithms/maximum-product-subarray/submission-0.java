class Solution {
    public int maxProduct(int[] nums) {

        int[] max = new int[nums.length];
        int[] min = new int[nums.length];

        max[0] = nums[0];
        min[0] = nums[0];

        int answer = nums[0];

        for (int i = 1; i < nums.length; i++) {

            int currentMax = Math.max(
                nums[i],
                Math.max(
                    max[i - 1] * nums[i],
                    min[i - 1] * nums[i]
                )
            );

            int currentMin = Math.min(
                nums[i],
                Math.min(
                    max[i - 1] * nums[i],
                    min[i - 1] * nums[i]
                )
            );

            max[i] = currentMax;
            min[i] = currentMin;

            answer = Math.max(answer, max[i]);
        }

        return answer;
    }
}