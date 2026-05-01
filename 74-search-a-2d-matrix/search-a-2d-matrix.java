class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // //TC-O(log(m*n)) and SC-O(1), binary search TC is logn, here we are treating 2d as m*n 1d
        //If no.s are arranged in rowwise, take col for divide and mod
        //If no.s are arranged in columnwise, take row for divide and mod
        int m = matrix.length, n = matrix[0].length, low = 0, high = m * n - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;//int overflow if low+high/2, so low+(high-low)/1
            //convert 1d mid to 2d mid
            int midValue = matrix[mid / n][mid % n];//row=mid/col, col=mid%col
            if (midValue == target) {
                return true;
            } else if (midValue < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }

        }
        return false;
    }
}