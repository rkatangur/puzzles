package org.examples.arrays;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 
 * 1209. Remove All Adjacent Duplicates in String II
 * 
 * Given a string s, a k duplicate removal consists of choosing k adjacent and
 * equal letters from s and removing them causing the left and the right side of
 * the deleted substring to concatenate together.
 * 
 * We repeatedly make k duplicate removals on s until we no longer can.
 * 
 * Return the final string after all such duplicate removals have been made.
 * 
 * It is guaranteed that the answer is unique.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: s = "abcd", k = 2 Output: "abcd" Explanation: There's nothing to
 * delete. Example 2:
 * 
 * Input: s = "deeedbbcccbdaa", k = 3 Output: "aa" Explanation: First delete
 * "eee" and "ccc", get "ddbbbdaa" Then delete "bbb", get "dddaa" Finally delete
 * "ddd", get "aa" Example 3:
 * 
 * Input: s = "pbbcggttciiippooaais", k = 2 Output: "ps"
 * 
 * 
 * Constraints:
 * 
 * 1 <= s.length <= 10^5 2 <= k <= 10^4 s only contains lower case English
 * letters.
 * 
 * 
 * @author rkata
 *
 */
public class RemoveAllAdjacentDupsInStringII {
	
//	Input: s = "deeedbbcccbdaa", k = 3
//			Output: "aa"
//			Explanation: 
//			First delete "eee" and "ccc", get "ddbbbdaa"
//			Then delete "bbb", get "dddaa"
//			Finally delete "ddd", get "aa"

	public static void main(String[] args) {
		RemoveAllAdjacentDupsInStringII solver = new RemoveAllAdjacentDupsInStringII();
		System.out.println(solver.removeDuplicates("deeedbbcccbdaa", 3));
	}

	public String removeDuplicates(String s, int k) {
		StringBuilder sb = new StringBuilder(s);

		Stack<Integer> stackOfCharCounts = new Stack<Integer>();

		for (int i = 0; i < sb.length(); i++) {
			if (i == 0 || sb.charAt(i) != sb.charAt(i - 1)) {
				stackOfCharCounts.push(1);
			} else {
				int curCharCount = stackOfCharCounts.pop() + 1;
				if (curCharCount == k) {
					// remove it
					sb.delete(i - curCharCount + 1, i +1);
					i = i - curCharCount;
				} else {
					stackOfCharCounts.push(curCharCount);
				}
			}
		}

		return sb.toString();
	}

}
