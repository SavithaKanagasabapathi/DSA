class Solution {
    public boolean backspaceCompare(String s, String t) {
        //TC-O(n+m) and SC-O(1)
        int i = s.length() - 1, j = t.length() - 1;//from backwards
        while (i >= 0 || j >= 0) {
            i = getNextValidIndex(s, i);
            j = getNextValidIndex(t, j);
            if ((i >= 0) != (j >= 0)) {//check this condn, it will short 2 if loops
                return false;
            }
            if (i >= 0 && j >= 0 && s.charAt(i) != t.charAt(j)) {
                return false;
            }
            i--;
            j--;
        }
        return true;
    }

    private int getNextValidIndex(String s, int index) {
        int skip = 0;
        while (index >= 0) {
            if (s.charAt(index) == '#') {
                skip++;
                index--;
            } else if (skip > 0) {
                skip--;
                index--;
            } else {
                break;
            }
        }
        return index;
    }
}