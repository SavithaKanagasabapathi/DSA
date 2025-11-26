class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numIndexMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int current = nums[i];
            int remaining = target - current;
            if (numIndexMap.containsKey(remaining)) {
                return new int[] { i, numIndexMap.get(remaining) };
            }
            numIndexMap.put(current, i);
        }
        return new int[] {};
    }
}