package org.examples.collections;

/**
 * 
 * Input: s = "3[a]2[bc]" Output: "aaabcbc" 3[a2[c]] "abc3[cd]xyz"
 * 
 * @author rkata
 *
 */

public class DecodeString {

	public static void main(String[] args) {
		DecodeString solver = new DecodeString();
		System.out.println(solver.decodeString("3[a]2[bc]"));
		System.out.println(solver.decodeString("3[a2[c]]"));
		System.out.println(solver.decodeString("3[z]2[2[y]pq4[2[jk]e1[f]]]ef"));

		System.out.println(solver.decodeString("100[leetcode]"));
	}

//	"3[z]2[2[y]pq4[2[jk]e1[f]]]ef"
	public String decodeString(String s) {
		Stack<Object> stack = new Stack<Object>();
		Stack<Object> revSstack1 = new Stack<Object>();

		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == ']') {
				// pop elements from stack;
				StringBuilder decodedStr = new StringBuilder();
				while (!stack.isEmpty()) {
					Object obj = stack.peek();
					if (obj != null && obj instanceof Character && ((Character) obj == '[')) {
						stack.pop();
						break;
					} else {
						revSstack1.push(obj);
						stack.pop();
					}
				}

				while (!revSstack1.isEmpty()) {
					decodedStr.append(revSstack1.pop());
				}

				StringBuilder numStr = new StringBuilder();
				while (!stack.isEmpty()) {
					Object obj = stack.peek();
					if (obj != null && obj instanceof Character && Character.isDigit((char) obj)) {
						stack.pop();
						numStr.append(obj);
					} else {
						break;
					}
				}
				numStr = numStr.reverse();

				StringBuilder newDecodedSb = new StringBuilder();
				for (int j = 0; j < Integer.parseInt(numStr.toString()); j++) {
					newDecodedSb.append(decodedStr.toString());
				}

				stack.push(newDecodedSb.toString());
			} else {
				stack.push(s.charAt(i));
			}
		}

		Stack<String> revStack = new Stack<String>();
		while (!stack.isEmpty()) {
			revStack.push(stack.pop().toString());
		}

		StringBuilder decodedStr = new StringBuilder();
		while (!revStack.isEmpty()) {
			decodedStr.append(revStack.pop());
		}

		return decodedStr.toString();
	}

}
