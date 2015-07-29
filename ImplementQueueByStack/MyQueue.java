package ImplementQueueByStack;

import java.util.Stack;

public class MyQueue {
	Stack<Integer> main = new Stack<Integer>();
	Stack<Integer> helper = new Stack<Integer>();
	// Push element x to the back of queue.
    public void push(int x) {
    	main.push(x);
    }

    // Removes the element from in front of queue.
    public void pop() {
       while(main.size() > 1) {
        	helper.push(main.pop());
        }
       main.pop();
        
        while(helper.size() > 0){
        	main.push(helper.pop());
        }
    }

    // Get the front element.
    public int peek() {
    	 while(main.size() > 1) {
          int temp = main.pop();
          System.out.println("temp = " + temp);
          helper.push(temp);
          }
    	 
          int bottomItem = main.peek();
          
         while(helper.size() > 0){
          	main.push(helper.pop());
          }
          
       
          return bottomItem;
    }

    // Return whether the queue is empty.
    public boolean empty() {
        return main.isEmpty();
    }
    
    public static void main(String[] args) {
    	MyQueue queue = new MyQueue();
    	
    	queue.push(1);
    	queue.push(2);
    	queue.pop();
    	System.out.println("should be 1: " + queue.peek());
    	
    	
    }
}
