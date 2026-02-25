class Solution {
    public int[][] updateMatrix(int[][] mat) {
        //TC-O(M*N) and SC-O(1)
        //DP - 2 pass from (top and left) and from (bottom and right)
        int m = mat.length, n = mat[0].length, inf = m + n;//max possible inf
        for (int i = 0; i < m; i++) {//from top and left
            for (int j = 0; j < n; j++) {
                if (mat[i][j] != 0) {
                    int top = (i > 0) ? mat[i - 1][j] : inf;
                    int left = (j > 0) ? mat[i][j - 1] : inf;
                    mat[i][j] = Math.min(top, left) + 1;
                }
            }
        }
        for (int i = m - 1; i >= 0; i--) {//from bottom and right
            for (int j = n - 1; j >= 0; j--) {
                if (mat[i][j] != 0) {
                    int bottom = (i < m - 1) ? mat[i + 1][j] : inf;
                    int right = (j < n - 1) ? mat[i][j + 1] : inf;
                    mat[i][j] = Math.min(mat[i][j], Math.min(bottom, right) + 1);
                    //min of itself from first pass and min of bottom and right+1  
                }
            }
        }
        return mat;

        //TC-O(M*N) and SC-O(M*N)
        //BFS
        // int m = mat.length, n = mat[0].length;
        // Queue<int[]> queue = new LinkedList<>();
        // for (int i = 0; i < m; i++) {
        //     for (int j = 0; j < n; j++) {
        //         if (mat[i][j] == 0) {
        //             queue.offer(new int[] { i, j });
        //         } else {
        //             mat[i][j] = Integer.MAX_VALUE;
        //         }
        //     }
        // }
        // int[][] dirs = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
        // while (!queue.isEmpty()) {
        //     int[] curr = queue.poll();
        //     for (int[] d : dirs) {
        //         int r = curr[0] + d[0], c = curr[1] + d[1];
        //         if (r >= 0 && r < m && c >= 0 && c < n && mat[r][c] > mat[curr[0]][curr[1]] + 1) {
        //             mat[r][c] = mat[curr[0]][curr[1]] + 1;
        //             queue.offer(new int[] { r, c });
        //         }
        //     }
        // }
        // return mat;
    }
}