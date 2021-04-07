package org.examples.arrays;

import java.util.HashMap;

/**
 * 1160. Find Words That Can Be Formed by Characters
 * 
 * 
 * You are given an array of strings words and a string chars.
 * 
 * A string is good if it can be formed by characters from chars (each character
 * can only be used once).
 * 
 * Return the sum of lengths of all good strings in words.
 * 
 * 
 * Example 1:
 * 
 * Input: words = ["cat","bt","hat","tree"], chars = "atach" Output: 6
 * 
 * Explanation: The strings that can be formed are "cat" and "hat" so the answer
 * is 3 + 3 = 6.
 * 
 * Example 2:
 * 
 * Input: words = ["hello","world","leetcode"], chars = "welldonehoneyr" Output:
 * 10
 * 
 * Explanation: The strings that can be formed are "hello" and "world" so the
 * answer is 5 + 5 = 10.
 * 
 * @author rkata
 */
public class WordsFromCharacters {

	@SuppressWarnings("unchecked")
	public int countCharacters(String[] words, String chars) {

		HashMap<Character, Integer> charMap = new HashMap<>();
		for (int i = 0; i < chars.length(); i++) {
			Character c = chars.charAt(i);
			charMap.put(c, charMap.getOrDefault(c, 0) + 1);
		}

		int wordsLength = 0;
		HashMap<Character, Integer> copyMap = null;
		for (String word : words) {
			copyMap = (HashMap<Character, Integer>) charMap.clone();
			boolean wordMatched = true;
			for (int j = 0; j < word.length(); j++) {
				Integer charCount = copyMap.get(word.charAt(j));
				if (charCount == null) {
					wordMatched = false;
					break;
				} else {
					charCount--;
					if (charCount == 0) {
						copyMap.remove(word.charAt(j));
					} else {
						copyMap.put(word.charAt(j), charCount);
					}
				}
			}

			if (wordMatched) {
				wordsLength = wordsLength + word.length();
			}
		}

		return wordsLength;
	}

}
