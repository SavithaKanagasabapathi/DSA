class Solution {
    public List<List<String>> solveNQueens(int n) {
        //TC-O(n!) and SC-O(n^2), eachtime n is reducing cols or any diag is blocked, n^2 for board n*n
        List<List<String>> result = new ArrayList<>();
        char[][] board = new char[n][n];
        Arrays.stream(board).forEach(row -> Arrays.fill(row, '.'));
        boolean[] cols = new boolean[n];
        boolean[] diags = new boolean[2 * n];
        boolean[] antidiags = new boolean[2 * n];
        backtrack(result, n, board, 0, cols, diags, antidiags);
        return result;
    }

    private void backtrack(List<List<String>> result, int n, char[][] board, int row,
            boolean[] cols, boolean[] diags, boolean[] antidiags) {
        if (row == n) {
            result.add(formatOutput(board));
            return;
        }
        for (int c = 0; c < n; c++) {
            int diagIndex = row - c + n;//Every diag have same diff (0,0, 1,1, 2,2, 3,3)
            int antidiagIndex = row + c;//Every antidiag have same sum(0,3, 1,2, 2,1, 3,0)
            if (cols[c] || diags[diagIndex] || antidiags[antidiagIndex]) {
                continue;
            }
            board[row][c] = 'Q';
            cols[c] = diags[diagIndex] = antidiags[antidiagIndex] = true;
            backtrack(result, n, board, row + 1, cols, diags, antidiags);//row+1
            board[row][c] = '.';
            cols[c] = diags[diagIndex] = antidiags[antidiagIndex] = false;
        }
    }

    private List<String> formatOutput(char[][] board) {
        return Arrays.stream(board).map(String::new).toList();//char[] to string to list["","","",""]
    }
}