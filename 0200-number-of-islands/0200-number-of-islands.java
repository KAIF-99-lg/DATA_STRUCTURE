class Solution {
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length==0){
            return 0;
        }

        int rows = grid.length;
        int cols = grid[0].length;
        int c = 0;

        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(grid[i][j]=='1'){
                    dfs(grid,i,j);
                    c++;
                }
            }
        }
        return c;
    }

    public void dfs(char[][] grid,int i,int j){
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length 
            || grid[i][j] == '0') {
            return;
        }

        // Mark current cell as visited
        grid[i][j] = '0';

        // Visit all 4 directions (up, down, left, right)
        dfs(grid, i + 1, j); // down
        dfs(grid, i - 1, j); // up
        dfs(grid, i, j + 1); // right
        dfs(grid, i, j - 1); // left
    }
}