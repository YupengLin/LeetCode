package MinStack;

import java.util.Stack;

public class MinStack {
	Stack<Integer> Normal = new Stack<Integer>();
	Stack<Integer> Min = new Stack<Integer>();
	
	public void push(int x) {
		Normal.push(x);
		if(Min.isEmpty()){
			Min.push(x);
		}else{
			int currMin = Min.peek();
			if(currMin>=x){
				Min.push(x);
			}
		}
	}
	
	public void pop() {
		if(Normal.isEmpty()){
			return;
		}
		int topElement = Normal.pop();
		if(topElement == Min.peek()){
			Min.pop();
		}
	}
	
	public int top() {
		return Normal.peek();
	}
	
	public int getMin() {
		return Min.peek();
	}
	
	public static void main(String[] args) {
		
	}
}
