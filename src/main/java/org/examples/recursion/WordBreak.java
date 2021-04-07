package org.examples.recursion;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak {

	public static void main(String[] args) {
//		"leetcode"
//		["leet","code"]
		WordBreak solver = new WordBreak();
//		System.out.println(solver.wordBreak("leetcode", Arrays.asList("leet", "code")));

//		System.out.println(solver.wordBreak("aaaaaaa", Arrays.asList("aaaa", "aaa")));

		System.out.println(solver.wordBreakRecursion("aaaaaaa", Arrays.asList("aaaa", "aaa"), 0));
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
