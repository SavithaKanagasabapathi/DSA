class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        //TC-O(N) and SC-O(N)
        int n = temperatures.length;
        Deque<Integer> stack = new ArrayDeque<>();//stack
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int index = stack.pop();
                result[index] = i - index;
            }
            stack.push(i);
        }
        return result;
    }
}