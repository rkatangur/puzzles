package org.examples.stacks;

import java.util.Stack;

/**
 * 
 * Valid Parentheses
 * 
 * Solution Given a string s containing just the characters '(', ')', '{', '}',
 * '[' and ']', determine if the input string is valid.
 * 
 * An input string is valid if:
 * 
 * Open brackets must be closed by the same type of brackets. Open brackets must
 * be closed in the correct order.
 * 
 * 
 * 
 * @author rkata
 *
 */
public class ValidParentheses {
	
	public boolean isValid(String s) {
		Stack<Character> stack = new Stack<Character>();
		for(int i=0; i<s.length(); i++) {
			Character ithChar = s.charAt(i);
			if(ithChar == '[' || ithChar == '(' || ithChar == '{') {
				stack.push(ithChar);
			} else {
				Character openingChar = stack.peek();				
				if((openingChar == '[' && ithChar == ']') ||  (openingChar == '(' && ithChar == ')') ||
						(openingChar == '{' && ithChar == '}')  ) {
					stack.pop();
				}
			}
		}
		
		if(stack.isEmpty()) {
			return true;
		}
		return false;
	}
	
}
