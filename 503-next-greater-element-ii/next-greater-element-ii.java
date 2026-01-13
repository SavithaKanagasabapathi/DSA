class Solution {
    public int[] nextGreaterElements(int[] nums) {
        //TC-O(n) and SC-O(n) Eventhough 2n times loop, push and pop only n times
        //Circular - so 2 times n
        int length = nums.length;
        Deque<Integer> stack = new ArrayDeque<>();
        int[] result = new int[length];
        Arrays.fill(result, -1);//Fill result with -1 
        for (int i = 0; i < 2 * length; i++) {
            int currentVal = nums[i % length];
            while (!stack.isEmpty() && nums[stack.peek()] < currentVal) {
                result[stack.pop()] = currentVal;
            }
            if (i < length) {
                stack.push(i);//Push index and for first n loop only
            }
        }
        return result;
    }
}