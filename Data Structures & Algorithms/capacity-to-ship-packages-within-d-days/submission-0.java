class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int min  =0;
        int max =0;
        for(int weight:weights){
            min = Math.max(min, weight);
            max += weight;
        }
        while(min<max){
            int mid = min+(max-min)/2;
            if(weightsofday(weights,days, mid)){
                max = mid;
            }
            else{
                min = mid+1;
            }
            
        }
        return min;
        
    }
    private boolean weightsofday(int[] weights, int days, int capacity) {
    int day = 1;
    int currentWeight = 0;

    for (int weight : weights) {

        if (currentWeight + weight > capacity) {
            day++;
            currentWeight = 0;
        }

        currentWeight += weight;
    }

    return day <= days;
}
}