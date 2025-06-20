class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        if(grid == null || grid.length == 0){
            return 0;
        }

        int rows = grid.length;
        int cols = grid[0].length;
        boolean[][] visited = new boolean[rows][cols];
        int maxArea=0;

        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(grid[i][j] == 1 && !visited[i][j]){
                    int area = dfs(grid,i,j,visited);
                    maxArea = Math.max(maxArea,area);
                }
            }
        }

        return maxArea;
    }

    public int dfs(int[][] grid,int i, int j,boolean[][] visited){
        if(i<0||i>=grid.length||j<0||j>=grid[0].length||grid[i][j]==0||visited[i][j]){
            return 0;
        }

        visited[i][j]=true;
        int area=1;

        area+=dfs(grid,i-1,j,visited);
        area+=dfs(grid,i+1,j,visited);
        area+=dfs(grid,i,j-1,visited);
        area+=dfs(grid,i,j+1,visited);

        return area;

        
    }
}