class Solution {
    //TC-O(M*N) and SC-O(1)
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if (matrix == null || matrix.length == 0) {
            return result;
        }
        int top = 0;
        int bottom = matrix.length - 1;//-1 is important
        int left = 0;
        int right = matrix[0].length - 1;
        while (top <= bottom && left <= right) {
            for (int i = left; i <= right; i++) {
                result.add(matrix[top][i]);//x-i
            }
            top++;
            for (int i = top; i <= bottom; i++) {
                result.add(matrix[i][right]);//i-x
            }
            right--;
            if (top <= bottom) {//if condition imp
                for (int i = right; i >= left; i--) {
                    result.add(matrix[bottom][i]);//x-i
                }
                bottom--;
            }
            if (left <= right) {//if condition imp
                for (int i = bottom; i >= top; i--) {
                    result.add(matrix[i][left]);//i-x
                }
                left++;
            }
        }
        return result;
    }
}