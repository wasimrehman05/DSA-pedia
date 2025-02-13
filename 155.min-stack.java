/*
 * @lc app=leetcode id=155 lang=java
 *
 * [155] Min Stack
 */

// @lc code=start

import java.util.*;

class MinStack {

    private final Stack<Integer> mainStack;
    private final Stack<Integer> minStack;

    public MinStack() {
        mainStack = new Stack<>();
        minStack = new Stack<>();
    }
    
    public void push(int val) {
        if (minStack.isEmpty() || minStack.peek() >= val) {
            minStack.add(val);
        }

        mainStack.add(val);
    }
    
    public void pop() {
        if (mainStack.isEmpty()) return;

        int removed = mainStack.pop();

        if (!minStack.isEmpty() && minStack.peek() == removed) minStack.pop();
    }
    
    public int top() {
        // if (mainStack.isEmpty()) return null;

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
// @lc code=end

