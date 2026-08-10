class CountSquares {
    Map<Integer, Set<Integer>> x_map;
    Map<Integer, Set<Integer>> y_map;
    int[][] count;

    public CountSquares() {
        x_map = new HashMap<>();
        y_map = new HashMap<>();
        count = new int[1001][1001];     
    }
    
    public void add(int[] point) {
        
        int x= point[0];
        int y = point[1];
        count[x][y]++;

        Set<Integer> xset = x_map.computeIfAbsent(x,(k)->new LinkedHashSet<>());
        xset.add(y);
        Set<Integer> yset = y_map.computeIfAbsent(y,(k)->new LinkedHashSet<>());
        yset.add(x);
        
    }
    
    public int count(int[] point) {
        int x1 = point[0];
        int y1 = point[1];
        int result =0;
        for(int y2:x_map.getOrDefault(x1, Collections.emptySet())){
            for(int x2:y_map.getOrDefault(y1, Collections.emptySet())){
                if(x1 != x2 && y1 !=y2 && Math.abs(x1-x2)==Math.abs(y1-y2)){
                    result += count[x2][y2]* count[x1][y2]* count[x2][y1];
                }
            }

        }
        return result;
        
    }
}
