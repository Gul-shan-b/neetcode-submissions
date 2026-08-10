class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int min =1;
        int max = 0;
        for(int pile:piles){
            max= Math.max(max, pile);
        }
        while(min<max){
            int mid = min+(max-min)/2;
            if(canieat(piles,h,mid)){
                max = mid;
            }
            else{
                min = mid+1;
            }
        }
        return min;
        
    }
    private boolean canieat(int[] piles, int h, int speed){
        int hours =0;
        for(int pile:piles){
            hours += (int)Math.ceil((double)pile/speed);
        }
        return hours <= h;
    }
}
