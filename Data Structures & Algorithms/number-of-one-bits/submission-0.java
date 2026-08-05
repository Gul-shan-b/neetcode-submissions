class Solution {
    public int hammingWeight(int n) {
        int count=0;
        int res =1;
        while(n!=0){
           count++;
           n = n&n-1;
            
        }
        return count;
        
    }
}
