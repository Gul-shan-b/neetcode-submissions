class Solution {
    Map<Integer, Integer> hm = new HashMap<>();
    public int climbStairs(int n) {
        if(hm.containsKey(n)){
            return hm.get(n);
        }
        if(n==1){
            return 1;

        }
        if(n==2){
            return 2;
        }
        int result = climbStairs(n-1) + climbStairs(n-2);
        hm.put(n,result);
        return result;

        
    }
}
