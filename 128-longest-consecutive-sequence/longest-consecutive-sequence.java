class Solution {
    public int longestConsecutive(int[] nums) {
        //TC-O(n) and SC-O(n)
        //2 loops it should be n^2 but we are checking only if num-1 present
        //So it will be very less so O(n)
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int longest = 0;
        for (int num : set) {
            if (!set.contains(num - 1)) {
                int currentNum = num;
                int currentStreak = 1;
                while (set.contains(currentNum + 1)) {
                    currentNum++;
                    currentStreak++;
                }
                longest = Math.max(longest, currentStreak);
            }
        }
        return longest;
    }
}