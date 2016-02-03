package EvaluateReversePolishNotation;

import java.util.Stack;

public class NativeSolution {
	public int evalRPN(String[] tokens) {
		if(tokens.length == 0) {
			return 0;
		}
		Stack<Integer> eval = new Stack<>();
		for(int i = 0; i < tokens.length; i++) {
			String token = tokens[i];
			if(token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")) {
				int second = eval.pop();
				int first = eval.pop();
				int result = 0;
				if(token.equals("+")) {
					result = first + second;
				}
				if(token.equals("-")) {
					result = first - second;
				}
				if(token.equals("*")) {
					result = first * second;
				}
				if(token.equals("/")) {
					result = first / second;
					System.out.println("result / " + result);
				}
				eval.push(result);
				System.out.println("first " + first + " ; second" + second + " ; result " + result);
			} else {
				eval.push(Integer.parseInt(token));
			}
		}
		if(eval.size() == 1) {
			return eval.pop();
		} else{
			return 0;
		}
	}
	
	public static void main(String[] args) {
		String[] tokens = {"4", "13", "5", "/", "+"};
		NativeSolution rpn = new NativeSolution();
		System.out.println(rpn.evalRPN(tokens));
	}

}
