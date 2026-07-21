class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

       
        int max =0;
        for(int i =0; i<rows; i++){
            for(int j =0; j<cols; j++){
                if(grid[i][j]==1){
                    int area= dfs(grid,i,j);
                    
                    max = Math.max(max,area);
                    
                }
                

            }
        }
        //max = Math.max(max,count);
        
        return max;
    }
    private int dfs(int[][] grid, int i, int j){
        int rows = grid.length;
        int cols = grid[0].length;
        if(i < 0 || i >= rows || j < 0 || j >= cols || grid[i][j] == 0){
            return 0;
        }
        
        grid[i][j] = 0;
        return 1+ dfs(grid, i+1, j)
        +dfs(grid, i-1, j)
        +dfs(grid, i, j+1)
        +dfs(grid, i, j-1);
        
    }
        
}


