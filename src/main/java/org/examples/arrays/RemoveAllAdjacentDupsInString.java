package org.examples.arrays;

/**
 * 
 * 1047. Remove All Adjacent Duplicates In String
 * 
 * Given a string S of lowercase letters, a duplicate removal consists of
 * choosing two adjacent and equal letters, and removing them.
 * 
 * We repeatedly make duplicate removals on S until we no longer can.
 * 
 * Return the final string after all such duplicate removals have been made. It
 * is guaranteed the answer is unique.
 * 
 * Example 1:
 * 
 * Input: "abbaca" Output: "ca" Explanation:
 * 
 * For example, in "abbaca" we could remove "bb" since the letters are adjacent
 * and equal, and this is the only possible move. The result of this move is
 * that the string is "aaca", of which only "aa" is possible, so the final
 * string is "ca". Note: 1 <= S.length <= 20000 S consists only of English
 * lowercase letters.
 * 
 * 
 */
public class RemoveAllAdjacentDupsInString {

	public static void main(String[] args) {
		RemoveAllAdjacentDupsInString solver = new RemoveAllAdjacentDupsInString();
		System.out.println(solver.removeDuplicates("abbaca"));
	}

	public String removeDuplicates(String str) {
		StringBuilder sb = new StringBuilder(str);

		for (int i = 0; i < sb.length(); i++) {
			if (i == 0 || sb.charAt(i) != sb.charAt(i - 1)) {
				continue;
			} else {
				sb.delete(i + 1 - 2, i + 1);
				i = i - 2;
			}
		}

		return sb.toString();

	}

}
