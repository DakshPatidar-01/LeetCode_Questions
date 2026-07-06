class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        
        char[][] board = new char[n][n];
        for (char[] row : board) {
            Arrays.fill(row, '.');
        }
        
        solve(0, board, result);
        return result;
    }
    
    private void solve(int row, char[][] board, List<List<String>> result) {
        if (row == board.length) {
            result.add(construct(board));
            return;
        }
        
        for (int col = 0; col < board.length; col++) {
            if (isSafe(row, col, board)) {
                board[row][col] = 'Q';
                solve(row + 1, board, result);
                board[row][col] = '.'; 
            }
        }
    }
    
    private boolean isSafe(int row, int col, char[][] board) {
        int r = row;
        int c = col;
        
        while (r >= 0) {
            if (board[r][c] == 'Q') return false;
            r--;
        }
    
        r = row;
        c = col;
        while (r >= 0 && c >= 0) {
            if (board[r][c] == 'Q') return false;
            r--;
            c--;
        }

        r = row;
        c = col;
        while (r >= 0 && c < board.length) {
            if (board[r][c] == 'Q') return false;
            r--;
            c++;
        }
        
        return true;
    }
    
    private List<String> construct(char[][] board) {
        List<String> list = new ArrayList<>();
        for (char[] row : board) {
            list.add(new String(row));
        }
        return list;
    }
}