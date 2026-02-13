class Solution {
    //TC-O(1) and SC-O(1)
    //If given n is multiple of m+1, he will fail
    //here m is no. of stones we can take from heap = 3
    public boolean canWinNim(int n) {
        return n % 4 != 0;
    }
}