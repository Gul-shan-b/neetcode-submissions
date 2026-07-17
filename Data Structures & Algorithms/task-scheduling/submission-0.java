class Solution {
    public int leastInterval(char[] tasks, int n) {
        int count[] = new int[26];
        for(char tast:tasks){
            count[tast-'A']++;
        }

        Arrays.sort(count);
        int maxfeq = count[25];
        int gaps = maxfeq -1;
        int idealslots = gaps*n;
        for(int i=24 ; i>=0; i--){
            idealslots -= Math.min(count[i], gaps);
        }
        if(idealslots>0){
            return tasks.length + idealslots;
        }
        return tasks.length;
        
    }
}
