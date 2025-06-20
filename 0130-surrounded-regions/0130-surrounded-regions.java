
class Solution {
    public void solve(char[][] board) {
        if (board == null || board.length == 0) return;

        int rows = board.length;
        int cols = board[0].length;

        // Step 1: Mark all 'O's connected to the border
        for (int i = 0; i < rows; i++) {
            dfs(board, i, 0);
            dfs(board, i, cols - 1);
        }
        for (int j = 0; j < cols; j++) {
            dfs(board, 0, j);
            dfs(board, rows - 1, j);
        }

        // Step 2: Flip surrounded 'O' to 'X', and temporary 'T' back to 'O'
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X'; // Surrounded
                } else if (board[i][j] == 'T') {
                    board[i][j] = 'O'; // Border-connected
                }
            }
        }
    }

    private void dfs(char[][] board, int i, int j) {
        int rows = board.length;
        int cols = board[0].length;

        if (i < 0 || i >= rows || j < 0 || j >= cols || board[i][j] != 'O') {
            return;
        }

        board[i][j] = 'T'; // Temporarily mark as safe

        dfs(board, i - 1, j); // up
        dfs(board, i + 1, j); // down
        dfs(board, i, j - 1); // left
        dfs(board, i, j + 1); // right
    }
}
