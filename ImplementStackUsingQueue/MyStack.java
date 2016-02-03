package ImplementStackUsingQueue;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

public class MyStack {
	Deque<Integer> stack = new LinkedList<Integer>();
	 // Push element x onto stack.
    public void push(int x) {
        stack.addFirst(x);
    }

    // Removes the element on top of the stack.
    public void pop() {
        stack.removeFirst();
    }

    // Get the top element.
    public int top() {
        return stack.peek();
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return stack.isEmpty();
    }
}
