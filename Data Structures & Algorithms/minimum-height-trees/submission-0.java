class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        
        if(n<=2){
            List<Integer> result = new ArrayList<>();
            for(int i =0; i<n; i++){
                result.add(i);
            }
            return result;
        }
        List<Set<Integer>> adj = new ArrayList<>();
        for(int i =0; i<n; i++){
            adj.add(new HashSet<>());
        }

        for(int[] edge: edges){
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        Queue<Integer> leave = new ArrayDeque<>();
        for(int i =0; i<n; i++){
            if(adj.get(i).size()==1){
                leave.add(i);
            }

        }
        int remain =n;
        while(remain>2){
            int leavecount = leave.size();
            remain -= leavecount;

            for(int i =0; i<leavecount; i++){
                int leaf = leave.poll();
                int neigbor = adj.get(leaf).iterator().next();
                adj.get(neigbor).remove(leaf);
                if(adj.get(neigbor).size()==1){
                    leave.add(neigbor);
                }
            }
        }
        return new ArrayList<>(leave);
    }
}