class Solution {
    public int orangesRotting(int[][] grid) {
        if(grid == null || grid.length==0) return -1;
        int rows = grid.length, col = grid[0].length, freshcount =0, min=0;
        
        Queue<int[]> queue = new LinkedList<>();
        
        for(int r =0; r<rows; r++){
            for(int c=0; c<col;c++){
                if(grid[r][c] ==2) queue.offer(new int[]{r,c});
                else if(grid[r][c] ==1) freshcount++;
            }
        }
        if(freshcount ==0) return 0;

        int[][] directions = {{0,1},{0,-1},{1,0},{-1,0}};


        while(!queue.isEmpty() && freshcount >0){
            int size = queue.size();
            
            for(int i =0; i<size; i++){
                int[] curr = queue.poll();
                for(int[] d:directions){
                    int nr = curr[0] + d[0], nc = curr[1]+ d[1];
                    if(nr >= 0 && nr<rows && nc >= 0 && nc < col && grid[nr][nc] == 1){
                        grid[nr][nc] =2;
                        freshcount--;
                        queue.offer(new int[]{nr,nc});
                    }
                }
            }
            min++;
        }
        return freshcount == 0 ? min : -1;
        
    }
}