class Solution {
    public int minLength(String s) {
        //TC-O(N) and SC-O(N)
        Deque<Character> stack = new ArrayDeque<>();
        for (char current : s.toCharArray()) {
            if (!stack.isEmpty()) {
                char top = stack.peek();
                if ((top == 'A' && current == 'B') || (top == 'C' && current == 'D')) {
                    stack.pop();
                    continue;
                }
            }
            stack.push(current);
        }
        return stack.size();
    }
}