class Solution {
    public int[][] highestPeak(int[][] isWater) {
        //TC-O(M*N) and SC-O(1), DP with two pass
        //1 is water, return height[][] so water cell will be 0
        int m = isWater.length, n = isWater[0].length, inf = m + n;//max possible inf
        int[][] height = new int[m][n];
        for (int i = 0; i < m; i++) {//from top and left
            for (int j = 0; j < n; j++) {
                if (isWater[i][j] == 1) {//if water, height 0
                    height[i][j] = 0;
                } else if (isWater[i][j] == 0) {//only consider land
                    int top = (i > 0) ? height[i - 1][j] : inf;
                    int left = (j > 0) ? height[i][j - 1] : inf;
                    height[i][j] = Math.min(top, left) + 1;
                }
            }
        }
        for (int i = m - 1; i >= 0; i--) {//from bottom and right
            for (int j = n - 1; j >= 0; j--) {
                if (isWater[i][j] == 0) {//only consider land
                    int bottom = (i < m - 1) ? height[i + 1][j] : inf;
                    int right = (j < n - 1) ? height[i][j + 1] : inf;
                    height[i][j] = Math.min(height[i][j], Math.min(bottom, right) + 1);
                    //min of itself from first pass and min of bottom and right+1  
                }
            }
        }
        return height;

        //TC-O(M*N) and SC-O(M*N), BFS
        // int m = isWater.length, n = isWater[0].length;
        // int[][] height = new int[m][n];
        // Queue<int[]> queue = new LinkedList<>();
        // for (int i = 0; i < m; i++) {
        //     for (int j = 0; j < n; j++) {
        //         if (isWater[i][j] == 1) {
        //             height[i][j] = 0; // Water is height 0
        //             queue.offer(new int[] { i, j });
        //         } else {
        //             height[i][j] = -1; // Mark land as unvisited
        //         }
        //     }
        // }
        // int[][] dirs = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
        // while (!queue.isEmpty()) {
        //     int[] curr = queue.poll();
        //     int r = curr[0];
        //     int c = curr[1];
        //     for (int[] d : dirs) {
        //         int nr = r + d[0];
        //         int nc = c + d[1];
        //         // If neighbor is within bounds and hasn't been visited
        //         if (nr >= 0 && nr < m && nc >= 0 && nc < n && height[nr][nc] == -1) {
        //             height[nr][nc] = height[r][c] + 1;
        //             queue.offer(new int[] { nr, nc });
        //         }
        //     }
        // }
        // return height;
    }
}