class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] indegree = new int[n+1];
        int [] outdegree = new int[n+1];
        for(int [] i: trust){
            int u = i[0];
            int v = i[1];
            outdegree[u]++;
            indegree[v]++;
        }
        for(int i =1; i<=n; i++){
            if(indegree[i]== n-1 && outdegree[i]==0){
                return i;
            }
        }
        return -1;
        
    }
}