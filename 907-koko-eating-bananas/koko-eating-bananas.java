class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        //TC-O(nlog(max(piles))) and SC-O(1)
        int left = 1, right = 0, speed = 0;
        for (int pile : piles) {
            right = Math.max(right, pile);
        }
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (canEat(piles, h, mid)) {
                right = mid;//can eat but wait for min
            } else {
                left = mid + 1;
            }
        }
        return right;//return any left or right because while loop stops if left=right
    }

    public boolean canEat(int[] piles, int hour, int speed) {
        int totalTime = 0;
        for (int pile : piles) {
            totalTime += (pile + speed - 1) / speed;
            //Math.ceil((double)pile / speed), which is slow due to type casting and floating-point
            //So rule, (pile + speed - 1) / speed
            if (totalTime > hour) {
                return false;
            }
        }
        return totalTime <= hour;
    }
}