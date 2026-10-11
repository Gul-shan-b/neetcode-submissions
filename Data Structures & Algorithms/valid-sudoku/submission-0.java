class Solution {
    public boolean isValidSudoku(char[][] board) {
        boolean[][] rows = new boolean[9][9];
        boolean[][] col = new boolean[9][9];
        boolean[][] boxs = new boolean[9][9];

        for(int i =0; i<9; i++){
            for(int j =0; j<9; j++){
                if(board[i][j]!='.'){
                    int num = board[i][j] -'1';
                    int boxind = (i/3)*3 +(j/3);
                    if(rows[i][num]|| col[j][num]|| boxs[boxind][num]){
                        return false;
                    }
                    rows[i][num] = col[j][num] = boxs[boxind][num] = true;
                }

            }

        }
        return true;
        
    }
}
