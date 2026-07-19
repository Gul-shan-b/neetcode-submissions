class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        TreeMap<Integer, Integer> event = new TreeMap<>();
        for(int [] trip: trips){
            int passenger = trip[0];
            int start = trip[1];
            int end = trip[2];

            event.put(start, event.getOrDefault(start, 0)+passenger);
            event.put(end, event.getOrDefault(end,0)-passenger);
        }
        int curpass =0;
        for(int change:event.values()){
            curpass += change;
            if(curpass>capacity){
                return false;
            }
        }
        return true;
        
    }
}