class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if(n==0) return new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        if(n==1){
            result.add(0);
            return result;
        } 
        List<Integer>[] arr = new ArrayList[n];

        for (int i = 0; i < n; i++){
            arr[i] = new ArrayList<>();
        }
            

        for(int[] edge : edges){
            arr[edge[0]].add(edge[1]);
            arr[edge[1]].add(edge[0]);
        }

        int[] edgeCount = new int[n];
        Queue<Integer> leaves = new ArrayDeque<>();

        for(int i=0; i<n; i++){
            edgeCount[i] = arr[i].size();
            if(edgeCount[i]==1){
                leaves.offer(i);
            }
        }
        
        while(!leaves.isEmpty()){
            if (n <= 2) return new ArrayList<>(leaves);
            int size = leaves.size();
            for (int i = 0; i < size; ++i) {
                int node = leaves.poll();
                n--;
                for (int nei : arr[node]) {
                    edgeCount[nei]--;
                    if (edgeCount[nei] == 1)
                        leaves.offer(nei);
                }
            }
        }
        return result;
    }
}