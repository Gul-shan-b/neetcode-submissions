/*
// Definition for a QuadTree node.
class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;

    
    public Node() {
        this.val = false;
        this.isLeaf = false;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = topLeft;
        this.topRight = topRight;
        this.bottomLeft = bottomLeft;
        this.bottomRight = bottomRight;
    }
}
*/

class Solution {
    public boolean isallsame(int[][] grid, int x, int y, int n){
        int value = grid[x][y];
        for(int i =x; i<x+n; i++){
            for(int j =y; j<y+n; j++){
                if(grid[i][j]!=value){
                    return false;
                }
            }
        }
        return true;
    }


    public Node solve(int[][] grid, int x, int y, int n){
        if(isallsame(grid, x,y, n)){
            return new Node(grid[x][y]==1, true);
        }

         Node root = new Node(true, false);
         int half = n/2;
        root.topLeft = solve(grid, x, y, half);

        root.topRight = solve(grid, x, y + half, half);

        root.bottomLeft = solve(grid, x + half, y, half);

        root.bottomRight = solve(grid, x + half, y + half, half);

        return root;



    }
    public Node construct(int[][] grid) {
        return solve(grid, 0,0,grid.length);
        
    }
}