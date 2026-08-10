class Solution {
    public int mySqrt(int x) {
        int l=0;
        int h=x;
        int ans =0;
        int mid =0;
        while(l<=h){
            mid = l+(h-l)/2;
            if((long)mid*mid <=x){
                ans = mid;
                l = mid+1;

            }
            else{
                h = mid-1;
            }
            
        }
        return ans;
        
    }
}