class Solution {
    //if it is happy, somepoint it will give 1
    //if it is unhappy, somepoint same number will come, so use set or detect cycle, to return false
    public boolean isHappy(int n) {
        //TC-O(logn) and SC-O(logn), we process every digit, no of digits in n is logn
        // Set<Integer> seen = new HashSet<>();
        // while (n != 1 && !seen.contains(n)) {
        //     seen.add(n);
        //     n = getNext(n);
        // }
        // return n == 1;

        //TC-O(logn) and SC-O(1), we process every digit, no of digits in n is logn, space is 1
        //Floyd's Cycle-Finding (Tortoise and Hare)
        int slow = n, fast = getNext(n);
        while (fast != 1 && fast != slow) {
            slow = getNext(slow);
            fast = getNext(getNext(fast));
        }
        return fast == 1;
    }

    private int getNext(int n) {
        int sum = 0;
        while (n != 0) {
            int digit = n % 10;
            sum += digit * digit;
            n = n / 10;
        }
        return sum;
    }
}