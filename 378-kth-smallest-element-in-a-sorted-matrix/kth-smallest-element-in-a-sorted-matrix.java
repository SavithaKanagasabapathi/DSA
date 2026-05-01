class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        //TC-O(n.log(max-min)) and SC-O(1)
        //Binary search on min to max values
        int n = matrix.length, left = matrix[0][0], right = matrix[n - 1][n - 1];
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (countLessThanEqualToMid(matrix, mid) < k) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    private int countLessThanEqualToMid(int[][] matrix, int mid) {
        int n = matrix.length, row = n - 1, col = 0, count = 0;//start from bottom left
        //if last row first col value is <=mid, that entire col must be < mid, so row+1
        //Then, go to next col in same last row
        //Else, go to before row in first col
        while (row >= 0 && col < n) {
            if (matrix[row][col] <= mid) {
                count += row + 1;
                col++;
            } else {
                row--;
            }
        }
        return count;
    }
}