
class Solution {

    public boolean makesquare(int[] matchsticks) {
        int n=matchsticks.length;

        int sum = Arrays.stream(matchsticks).sum();

        if (sum % 4 != 0)
            return false;

        int target = sum / 4;

        
        Arrays.sort(matchsticks);

        int l=0, r= n-1;

        while(l<r){
            int temp = matchsticks[l];
            matchsticks[l] = matchsticks[r];
            matchsticks[r] = temp;
            l++;
            r--;
        }

        int[] sides = new int[4];

        return backtrack(matchsticks, sides, target, 0);
    }

    private boolean backtrack(int[] matchsticks, int[] sides, int target, int index) {

        // All sticks are used
        if (index == matchsticks.length) {
            return true;
        }

        for (int i = 0; i < 4; i++) {

            // Don't exceed the target side length
            if (sides[i] + matchsticks[index] <= target) {

                sides[i] += matchsticks[index];

                if (backtrack(matchsticks, sides, target, index + 1))
                    return true;

                // Backtrack
                sides[i] -= matchsticks[index];
            }
        }

        return false;
    }
}