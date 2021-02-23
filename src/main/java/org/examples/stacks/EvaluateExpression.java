package org.examples.stacks;

import java.util.Stack;

/**
 * 
 * Evaluate Reverse Polish Notation Solution
 * 
 * Evaluate the value of an arithmetic expression in Reverse Polish Notation.
 * 
 * Valid operators are +, -, *, /. Each operand may be an integer or another
 * expression.
 * 
 * Note:
 * 
 * Division between two integers should truncate toward zero. The given RPN
 * expression is always valid. That means the expression would always evaluate
 * to a result and there won't be any divide by zero operation. Example 1:
 * 
 * Input: ["2", "1", "+", "3", "*"] Output: 9 Explanation: ((2 + 1) * 3) = 9
 * Example 2:
 * 
 * Input: ["4", "13", "5", "/", "+"] Output: 6 Explanation: (4 + (13 / 5)) = 6
 * Example 3:
 * 
 * Input: ["10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"]
 * Output: 22 Explanation: ((10 * (6 / ((9 + 3) * -11))) + 17) + 5 = ((10 * (6 /
 * (12 * -11))) + 17) + 5 = ((10 * (6 / -132)) + 17) + 5 = ((10 * 0) + 17) + 5 =
 * (0 + 17) + 5 = 17 + 5 = 22
 * 
 * 
 * 
 * @param args
 */
public class EvaluateExpression {

	public static void main(String[] args) {
		String[] tokens = new String[] { "2", "1", "+", "3", "*" };
		EvaluateExpression solver = new EvaluateExpression();
		System.out.println(solver.evalRPN(tokens));

		tokens = new String[] { "4", "13", "5", "/", "+" };
		System.out.println(solver.evalRPN(tokens));
	}

	public int evalRPN(String[] tokens) {
		Stack<Integer> operands = new Stack<Integer>();
		for (int i = 0; i < tokens.length; i++) {
			String token = tokens[i];
			if (token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")) {
				Integer operand1 = operands.pop();
				Integer operand2 = operands.pop();
				if (token.equals("+")) {
					operands.push(operand2 + operand1);
				} else if (token.equals("-")) {
					operands.push(operand2 - operand1);
				} else if (token.equals("*")) {
					operands.push(operand2 * operand1);
				} else if (token.equals("/")) {
					int result = (operand2/operand1);
					System.out.println("operand "+operand2+", operand "+operand1+", result "+result);
					operands.push(result);
				}
			} else {
				operands.add(Integer.parseInt(tokens[i]));
			}
		}

		return operands.pop();
	}
}
