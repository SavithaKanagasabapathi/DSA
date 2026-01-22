class Solution {
    public int totalNQueens(int n) {
        //TC-O(n!) and SC-O(n), 
        //eachtime n is reducing cols or any diag is blocked, n for boolean array & recursion stack
        //int result = 0;//pass by value-wrong always return 0
        int[] result = new int[1];//pass by reference, 
        boolean[] cols = new boolean[n];
        boolean[] diags = new boolean[2 * n];
        boolean[] antidiags = new boolean[2 * n];
        backtrack(result, n, 0, cols, diags, antidiags);
        return result[0];
    }

    private void backtrack(int[] result, int n, int row,
            boolean[] cols, boolean[] diags, boolean[] antidiags) {
        if (row == n) {
            result[0]++;
            return;
        }
        for (int c = 0; c < n; c++) {
            int diagIndex = row - c + n;//Every diag have same diff (0,0, 1,1, 2,2, 3,3)
            int antidiagIndex = row + c;//Every antidiag have same sum(0,3, 1,2, 2,1, 3,0)
            if (cols[c] || diags[diagIndex] || antidiags[antidiagIndex]) {
                continue;
            }
            cols[c] = diags[diagIndex] = antidiags[antidiagIndex] = true;
            backtrack(result, n, row + 1, cols, diags, antidiags);//row+1
            cols[c] = diags[diagIndex] = antidiags[antidiagIndex] = false;
        }
    }
}