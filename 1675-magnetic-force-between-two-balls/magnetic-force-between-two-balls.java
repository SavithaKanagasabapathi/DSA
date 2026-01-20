class Solution {
    public int maxDistance(int[] position, int m) {
        //TC-O(nlogn+nlogd) and SC-O(1)
        //nlogn for sorting, d is max position
        Arrays.sort(position);//position may be unsorted 
        int left = 1;//min distance
        int right = position[position.length - 1] - position[0];//max distance
        int result = 0;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (canPlace(position, m, mid)) {
                result = mid;//this gap works but wait for max gap
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return result;
    }

    public boolean canPlace(int[] position, int balls, int mid) {
        int ball = 1;//first ball in first position
        int nextPosition = position[0];
        for (int i = 1; i < position.length; i++) {
            if (position[i] - nextPosition >= mid) {
                nextPosition = position[i];
                if (++ball >= balls) {
                    return true;
                }
            }
        }
        return false;
    }
}