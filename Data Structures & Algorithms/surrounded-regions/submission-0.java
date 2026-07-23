class Solution {
    int [][] dir = {{1,0},{0,1},{-1,0},{0,-1}};
    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;

        // TRAVERSING FIRST AND LAST COLUMN;

        for(int i =0; i<m; i++){
            if(board[i][0]=='O'){
                dfs(board, i,0);
            }
            if(board[i][n-1]=='O'){
                dfs(board, i,n-1);
            }
        }

        //TRAVERSING FIRST AND LAST ROW 

        for(int j =0 ;j<n; j++){
            if(board[0][j]=='O'){
                dfs(board,0,j);
            }
            if(board[m-1][j]=='O'){
                dfs(board,m-1,j);
            }
        }

        for(int i =0; i<m; i++){
            for(int j =0; j<n; j++){
                if(board[i][j] =='O'){
                    board[i][j] ='X';
                }
                else if( board[i][j] =='#'){
                    board[i][j] ='O';
                }
            }
        }
    }
        private void dfs(char[][] board, int r, int c){
            board[r][c] = '#';

            for(int[] d: dir){
                int nr = r+ d[0];
                int nc = c+ d[1];

                if(nr<0 || nc<0 || nr>=board.length|| nc >= board[0].length){
                    continue;
                }
                if(board[nr][nc]!='O'){
                    continue;
                }
                dfs(board, nr,nc);

            }
        }      
    
}
