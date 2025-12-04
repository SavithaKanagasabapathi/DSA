class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<Character>[] rows = new HashSet[9];
        Set<Character>[] columns = new HashSet[9];
        Set<Character>[] grids = new HashSet[9];

        for (int i = 0; i < 9; i++) {
            rows[i] = new HashSet<>();
            columns[i] = new HashSet<>();
            grids[i] = new HashSet<>();
        }

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char currentValue = board[i][j];
                int gridNumber = (i / 3) * 3 + (j / 3);
                if (currentValue != '.') {
                    if ((!rows[i].contains(currentValue)) && (!columns[j].contains(currentValue)) &&
                            (!grids[gridNumber].contains(currentValue))) {
                        rows[i].add(currentValue);
                        columns[j].add(currentValue);
                        grids[gridNumber].add(currentValue);
                    } else {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}