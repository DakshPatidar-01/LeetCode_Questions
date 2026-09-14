class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        char board[][] =  new char[n][n];
        for(char[] row:board){Arrays.fill(row,'.');}
        placeQueen(0, board,ans);
        return ans;
    }

    private void placeQueen(int i,char board[][],List<List<String>> ans){
        if(i==board.length){
            ans.add(makeBoard(board));
            return;
        }
        for(int col=0;col<board.length;col++){
            if(! isValid(i, col, board))continue;
            board[i][col]='Q';
            placeQueen(i+1, board, ans);
            board[i][col]='.';
        }
    }

    private boolean isValid(int row,int col,char[][] board){
        for(int i=0;i<row;i++){if(board[i][col]=='Q')return false;}
        for(int i=row-1,j=col-1;i>=0 && j>=0;i--,j--){if(board[i][j]=='Q')return false;}
        for(int i=row-1,j=col+1;i>=0 && j<board.length;i--,j++){if(board[i][j]=='Q')return false;}
        return true;
    }

    private List<String> makeBoard(char board[][]){
        List<String> curr = new ArrayList<>();
        for(char row[]:board){curr.add(new String(row));}
        return curr;
    }
}