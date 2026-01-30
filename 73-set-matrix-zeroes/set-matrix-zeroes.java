class Solution {
    //If we see 0, and make that row, col 0, if we do it there itself, we get confused 
    //which 0 we did and which are already present, so will make copy of matrix and do 
    //but it's SC will be O(MN)
    //If we create 2 lists of m and n size with adding which row and column have zero and others false
    //it's SC will be O(M+N)
    //So if we check first row and column having zero and mark and traverse other cells 
    //and it they have mark its row and column's first cell as 0, 
    //later fill these rows and cols with zero. if first row ad col zero-mark those as zero
    //It's SC will be O(1) in place

    //TC-O(MN) and SC-O(1)
    public void setZeroes(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        boolean firstRowZero = false, firstColZero = false;

        for (int i = 0; i < cols; i++) {
            if (matrix[0][i] == 0) {
                firstRowZero = true;//if first row has any zero, set true
            }
        }
        for (int i = 0; i < rows; i++) {
            if (matrix[i][0] == 0) {
                firstColZero = true;//if first coln has any zero, set true
            }
        }
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                if (matrix[i][j] == 0) {//check remaining cells, if 0 present
                    matrix[i][0] = 0;//set first row  0
                    matrix[0][j] = 0;//set first coln 0
                }
            }
        }
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {//if first row/coln 0,
                    matrix[i][j] = 0;//set cell as 0
                }
            }
        }
        if (firstRowZero) {
            for (int i = 0; i < cols; i++) {
                matrix[0][i] = 0;//set first row to 0, if true
            }
        }
        if (firstColZero) {
            for (int i = 0; i < rows; i++) {
                matrix[i][0] = 0;//set first coln to 0, if true
            }
        }
    }
}