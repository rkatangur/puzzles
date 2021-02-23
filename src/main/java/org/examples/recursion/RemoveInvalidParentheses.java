package org.examples.recursion;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

public class RemoveInvalidParentheses {

	public static void main(String[] args) {
		RemoveInvalidParentheses solver = new RemoveInvalidParentheses();
//		String s = "()())()";
//		String s = "n";
		String s = ")(";
		List<String> results = solver.removeInvalidParentheses(s);
		for (String str : results) {
			System.out.println(str);
		}
	}

	public List<String> removeInvalidParentheses(String s) {
		LinkedHashSet<String> results = new LinkedHashSet<String>();
		StringBuilder sb = new StringBuilder();
		removeInvalidParenthesesHelper(s, sb, 0, results, 0);

		if (results.size() <= 0) {
			List<String> resList = new ArrayList<String>();
			resList.add("");
			return resList;
		}
		return new ArrayList<String>(results);
	}

	public void removeInvalidParenthesesHelper(String s, StringBuilder sb, int index, LinkedHashSet<String> results,
			int numOfOpenBrackets) {

		if (index >= s.length()) {
			if (numOfOpenBrackets == 0) {
				if (results.isEmpty()) {
					results.add(sb.toString());
				} else {
					String lastStr = results.iterator().next();
					String newStr = sb.toString();
					if (newStr.length() >= lastStr.length())
						results.add(newStr);
				}
			}
			return;
		}

		char charAtI = s.charAt(index);
		boolean includeChar = true;
		if (includeChar) {
			boolean isValid = true;
			sb.append(charAtI);
			int curNumOfOpenBrackets = numOfOpenBrackets;
			if (charAtI == '(') {
				if (curNumOfOpenBrackets >= 0) {
					curNumOfOpenBrackets++;
				} else {
					isValid = false;
				}
			} else if (charAtI == ')') {
				if (curNumOfOpenBrackets > 0) {
					curNumOfOpenBrackets--;
				} else {
					isValid = false;
				}
			}

			if (isValid) {
				removeInvalidParenthesesHelper(s, sb, index + 1, results, curNumOfOpenBrackets);
			}
			sb.deleteCharAt(sb.length() - 1);
		}

		removeInvalidParenthesesHelper(s, sb, index + 1, results, numOfOpenBrackets);
	}
	
}
