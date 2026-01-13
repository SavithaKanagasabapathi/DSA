class MinStack {
    //TC-O(1) and SC-O(n) 2 times n as normal and extra stack
    private Deque<Integer> mainStack;
    private Deque<Integer> minStack;

    public MinStack() {
        mainStack = new ArrayDeque<>();
        minStack = new ArrayDeque<>();//Extra stack for storing min num
    }

    public void push(int val) {
        mainStack.push(val);
        if (minStack.isEmpty() || val <= minStack.peek()) {
            minStack.push(val);//If empty or min, push num
        }
    }

    public void pop() {
        if (mainStack.pop().equals(minStack.peek())) {//First pop from main 
            minStack.pop();//then if the num popped and min stack peek are same, pop from min
        }
    }

    public int top() {
        return mainStack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */