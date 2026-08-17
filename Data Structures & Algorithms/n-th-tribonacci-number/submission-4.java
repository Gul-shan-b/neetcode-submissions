class Solution {
    public int tribonacci(int n) {
        if(n==2){
            return 1;
        }
        if(n==1){
            return 1;
        }
        if(n==0){
            return 0;
        }
        int prev1 =1;
        int prev2 =1;
        int prev3 = 0;
        int cur =0;
        for(int i=3; i<=n; i++){
            cur = prev1+prev2+prev3;
            prev3 = prev2;
            prev2= prev1;
            prev1= cur;
        }
        return cur;
        
    }
}