class Solution {

    public int numIslands(char[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        boolean[][] visited = new boolean[rows][cols];
        int count = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                    if (grid[i][j] == '1' && !visited[i][j]) {
                    count++;
                    dfs(grid, i, j, visited);
                }
            }
        }
        return count;
    }

    private void dfs(char[][] grid, int i, int j, boolean[][] visited) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length)return;
        if (grid[i][j] == '0' || visited[i][j])return;
        visited[i][j] = true;
        dfs(grid, i - 1, j, visited); // Up
        dfs(grid, i + 1, j, visited); // Down
        dfs(grid, i, j - 1, visited); // Left
        dfs(grid, i, j + 1, visited); // Right
    }
}