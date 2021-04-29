package org.examples.recursion;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 
 * 139. Word Break
 * 
 * Given a string s and a dictionary of strings wordDict, return true if s can
 * be segmented into a space-separated sequence of one or more dictionary words.
 * 
 * Note that the same word in the dictionary may be reused multiple times in the
 * segmentation.
 * 
 * Example 1:
 * 
 * Input: s = "leetcode", wordDict = ["leet","code"] Output: true Explanation:
 * Return true because "leetcode" can be segmented as "leet code". Example 2:
 * 
 * Input: s = "applepenapple", wordDict = ["apple","pen"] Output: true
 * Explanation: Return true because "applepenapple" can be segmented as "apple
 * pen apple". Note that you are allowed to reuse a dictionary word. Example 3:
 * 
 * Input: s = "catsandog", wordDict = ["cats","dog","sand","and","cat"] Output:
 * false
 * 
 * Constraints:
 * 
 * 1 <= s.length <= 300 1 <= wordDict.length <= 1000 1 <= wordDict[i].length <=
 * 20 s and wordDict[i] consist of only lowercase English letters. All the
 * strings of wordDict are unique.
 * 
 * @author rkata
 *
 */
public class WordBreak {

	public static void main(String[] args) {
//		"leetcode"
//		["leet","code"]
		WordBreak solver = new WordBreak();
		System.out.println(solver.wordBreakV2("leetcode", Arrays.asList("leet", "code")));

//		System.out.println(solver.wordBreak("aaaaaaa", Arrays.asList("aaaa", "aaa")));

//		System.out.println(solver.wordBreakV2("aaaaaaa", Arrays.asList("aaaa", "aaa"), 0));
	}

	public boolean wordBreakV2(String s, List<String> wordDict) {
		boolean[] dp = new boolean[s.length() + 1];
		dp[0] = true;
		Set<String> dict = new HashSet<String>(wordDict);

		for (int i = 1; i <= s.length(); i++) {
			for (int j = 0; j < i; j++) {
				if (!dp[j]) {
					continue;
				}
				if (dict.contains(s.substring(j, i))) {
					dp[i] = true;
					break;
				}
			}
		}

		return dp[s.length()];
	}

	public boolean wordBreak(String s, List<String> wordDict) {
		Set<String> words = new HashSet<>(wordDict);
		int startIndex = 0;
		for (int i = 0; i < s.length(); i++) {
			if (words.contains(s.substring(startIndex, i + 1))) {
				startIndex = (i + 1);
			}
		}

		return (startIndex == (s.length())) ? true : false;
	}

	public boolean wordBreakRecursion(String s, List<String> wordDict, int pos) {
		if (pos == s.length()) {
			return true;
		}

		Set<String> words = new HashSet<>(wordDict);
		int startIndex = pos;
		for (int i = pos + 1; i <= s.length(); i++) {
			if (words.contains(s.substring(startIndex, i)) && wordBreakRecursion(s, wordDict, i)) {
				return true;
			}
		}

		return false;
	}

}
