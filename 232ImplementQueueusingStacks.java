/**
 * 232. Implement Queue using Stacks
 * Pop and push to copy if and only if copy is empty
 * Otherwise just do pop() and peek() in copy
 * O(n)
 */
public class MyQueue {
    
    Stack<Integer> stack;
    Stack<Integer> copy;

    /** Initialize your data structure here. */
    public MyQueue() {
        stack = new Stack<Integer>();
        copy = new Stack<Integer>();
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        stack.push(x);
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if (copy.isEmpty()) {
            while (!stack.isEmpty()) {
                copy.push(stack.pop());
            }
        }
        return copy.pop();
    }
    
    /** Get the front element. */
    public int peek() {
        if (copy.isEmpty()) {
            while (!stack.isEmpty()) {
                copy.push(stack.pop());
            }
        }
        return copy.peek();
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stack.isEmpty() && copy.isEmpty();
    }
}