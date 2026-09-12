class Solution {
    public boolean exist(char[][] board, String word) {
        int n=board.length,m=board[0].length;
        boolean visited[][] = new boolean[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(board[i][j]==word.charAt(0)){
                    if(solve(i, j, 0, visited, board, word))return true;
                }
            }
        }
        return false;
    }

    private boolean solve(int i,int j,int idx,boolean[][] visted ,char[][] board,String word){
        if(i<0 || i>=board.length ||j<0 || j>=board[0].length)return false;
        if(visted[i][j])return false;
        if(board[i][j]!=word.charAt(idx))return false;
        if(idx==word.length()-1)return true;
        visted[i][j]=true;
        boolean found = 
            solve(i-1, j, idx+1,visted, board, word)||
            solve(i+1, j, idx+1,visted, board, word)||
            solve(i, j-1, idx+1,visted, board, word)||
            solve(i, j+1, idx+1,visted, board, word);
        visted[i][j]=false;
        return found;

    }
}