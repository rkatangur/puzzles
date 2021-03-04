package org.examples.arrays;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 
 * We can represent a sentence as an array of words, for example, the sentence
 * "I am happy with leetcode" can be represented as arr =
 * ["I","am",happy","with","leetcode"].
 * 
 * Given two sentences sentence1 and sentence2 each represented as a string
 * array and given an array of string pairs similarPairs where similarPairs[i] =
 * [xi, yi] indicates that the two words xi and yi are similar.
 * 
 * Return true if sentence1 and sentence2 are similar, or false if they are not
 * similar.
 * 
 * Two sentences are similar if:
 * 
 * They have the same length (i.e. the same number of words) sentence1[i] and
 * sentence2[i] are similar. Notice that a word is always similar to itself,
 * also notice that the similarity relation is not transitive. For example, if
 * the words a and b are similar and the words b and c are similar, a and c are
 * not necessarily similar.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: sentence1 = ["great","acting","skills"], sentence2 =
 * ["fine","drama","talent"], similarPairs =
 * [["great","fine"],["drama","acting"],["skills","talent"]] Output: true
 * Explanation: The two sentences have the same length and each word i of
 * sentence1 is also similar to the corresponding word in sentence2. Example 2:
 * 
 * Input: sentence1 = ["great"], sentence2 = ["great"], similarPairs = []
 * Output: true Explanation: A word is similar to itself. Example 3:
 * 
 * Input: sentence1 = ["great"], sentence2 = ["doubleplus","good"], similarPairs
 * = [["great","doubleplus"]] Output: false Explanation: As they don't have the
 * same length, we return false.
 * 
 * 
 * Constraints:
 * 
 * 1 <= sentence1.length, sentence2.length <= 1000 1 <= sentence1[i].length,
 * sentence2[i].length <= 20 sentence1[i] and sentence2[i] consist of lower-case
 * and upper-case English letters. 0 <= similarPairs.length <= 1000
 * similarPairs[i].length == 2 1 <= xi.length, yi.length <= 20 xi and yi consist
 * of lower-case and upper-case English letters. All the pairs (xi, yi) are
 * distinct.
 * 
 * 
 * 
 */
public class SentenceSimilarity {

	public boolean areSentencesSimilar(String[] words1, String[] words2, List<List<String>> pairs) {
		if (words1.length != words2.length) {
			return false;
		}
		// O(n) == pairs.length - timecomplexity
		// O(n ) == space complexity
		Set<String> similarWords = new HashSet<String>();
		for (List<String> pair : pairs) {
			similarWords.add(pair.get(0) + "#" + pair.get(1));
			similarWords.add(pair.get(1) + "#" + pair.get(0));
		}
		boolean areSimilar = true;
		for (int i = 0; i < words1.length; i++) {
			String wordStr1 = words1[i] + "#" + words2[i];
			String wordStr2 = words2[i] + "#" + words1[i];
			if (!words1[i].equals(words2[i]) || !similarWords.contains(wordStr1) || !similarWords.contains(wordStr2)) {
				System.out.println(words1[i] + " is not same as " + words2[i]);
				areSimilar = false;
				break;
			}
		}
		return areSimilar;
	}

}
