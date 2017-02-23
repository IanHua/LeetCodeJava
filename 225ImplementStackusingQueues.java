/**
 * 225. Implement Stack using Queues
 * Use top to maintain top value
 * Rotate to pop stack top
 * Push: O(1); Pop: O(n)
 */
public class MyStack {
    
    Queue<Integer> queue;
    int top;
    /** Initialize your data structure here. */
    public MyStack() {
        queue = new LinkedList<Integer>();
        top = 0;
    }
    
    /** Push element x onto stack. */
    public void push(int x) {
        queue.add(x);
        top = x;
    }
    
    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        int len;
        len = queue.size() - 1;
        while (len > 0) {
            top = queue.peek();
            queue.add(queue.poll());
            len--;
        }
        return queue.poll();
    }
    
    /** Get the top element. */
    public int top() {
       return top;
    }
    
    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue.isEmpty();
    }
}
