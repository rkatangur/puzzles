package org.examples.arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/* Given two sentences, each represented as array of words (words1 and words2) and list of similar word pairs (pairs),
determine if two sentences are similar.
Example:
  Input:
   words1 = ["great", "acting", "skills"]
   words2 = ["fine", "drama", "talent"]
   pairs = [["great", "good"], ["fine", "good"], ["acting","drama"], ["skills","talent"]]
  Output
    True
*/

public class ValidateSentences {

	public static void main(String[] args) {

		ValidateSentences solver = new ValidateSentences();

		String[] words1 = new String[] { "an", "extraordinary", "meal" };
		String[] words2 = new String[] { "a", "good", "dinner" };

	}

	public boolean areSentencesSimilar(String[] words1, String[] words2, List<List<String>> pairs) {
		if (words1.length != words2.length) {
			return false;
		}
		// O(n) == pairs.length - timecomplexity
		// O(n ) == space complexity
		Map<String, Set<String>> wordsMap = new HashMap<>();
		for (int i = 0; i < pairs.size(); i++) {
			List<String> pair = pairs.get(i);
			addRelation(pair.get(0), pair.get(1), wordsMap);
		}

		System.out.println("Number of entries recorded in hashmap: " + wordsMap.size());
		List<Set<String>> distinctSets = buildDistinctSets(wordsMap);
		
		System.out.println("Number of distinctSets " + distinctSets.size());
		
		for(Set<String> set : distinctSets) {
			System.out.println("--------Start--------------");
			for(String str : set) {
				System.out.print(str+", ");
			}
			System.out.println("-----END---------");
		}


		/// if both words of length of m
		// n*m
		// O(m *(n*m))
		boolean areSimilar = true;
		for (int i = 0; i < words1.length; i++) {

			// Old Implementation using BFS
			// if(!checkIfWordsAreSynconyms(words1[i], words2[i], wordsMap)){
			// areSimilar = false;
			// break;
			// }

			// New Implementation using the distinct sets of words that are same.
			boolean areWordsSimilar = words1[i].equals(words2[i]);
			if (!areWordsSimilar) {
				for (Set<String> wordSet : distinctSets) {
					if (wordSet.contains(words1[i]) && wordSet.contains(words2[i])) {
						areWordsSimilar = true;
						break;
					}
				}
			}

			if (!areWordsSimilar) {
				System.out.println(words1[i] + " is not same as " + words2[i]);
				areSimilar = areWordsSimilar;
				break;
			}
		}

		return areSimilar;
	}

	// great, fine
	// X distinct words
	// Y edges
	// X + Y is the timecomplexity
	// BFS approach
	public boolean checkIfWordsAreSynconyms(String word1, String word2, Map<String, List<String>> wordsMap) {
		boolean areSimilar = false;
		Queue<String> bfsQ = new LinkedList<>();
		bfsQ.add(word1);

		// TODO: handle any cycles
		while (!bfsQ.isEmpty()) {
			String wordToCheck = bfsQ.poll();

			// change it to set...
			List<String> wordRelations = wordsMap.get(word1);
			if (wordRelations.contains(word2)) {
				areSimilar = true;
				break;
			}
			bfsQ.addAll(wordRelations);
		}
		return areSimilar;
	}

	// great, fine
	// X distinct words
	// Y edges
	// X + Y is the timecomplexity
	public List<Set<String>> buildDistinctSets(Map<String, Set<String>> wordsMap) {
		List<Set<String>> uniqSetsOfStrs = new ArrayList<>();

		// handling any cycles
		Set<String> visitedStrs = new HashSet<>();
		Queue<String> bfsQ = new LinkedList<>();

		for (String word : wordsMap.keySet()) {
			if (!visitedStrs.contains(word)) {
				Set<String> setOfStrs = new HashSet<>();
				bfsQ.add(word);
				while (!bfsQ.isEmpty()) {
					String wordToCheck = bfsQ.poll();
					setOfStrs.add(wordToCheck);
					visitedStrs.add(wordToCheck);
					// change it to set...
					Set<String> wordRelations = wordsMap.get(wordToCheck);
					for (String wordEdge : wordRelations) {
						if (!visitedStrs.contains(wordEdge)) {
							bfsQ.add(wordEdge);
						}
					}
				}
				uniqSetsOfStrs.add(setOfStrs);
			}
		}

		return uniqSetsOfStrs;
	}

	public void addRelation(String word1, String word2, Map<String, Set<String>> wordsMap) {
		// Word1 to word 2 relationship
		Set<String> word1Edges = wordsMap.get(word1);
		if (word1Edges == null) {
			word1Edges = new HashSet<>();
		}
		word1Edges.add(word2);
		word1Edges.add(word1);
		wordsMap.put(word1, word1Edges);

		// Word2 to word1 relationship
		Set<String> word2Edges = wordsMap.get(word2);
		if (word2Edges == null) {
			word2Edges = new HashSet<>();
		}
		word2Edges.add(word1);
		word2Edges.add(word2);
		wordsMap.put(word2, word2Edges);
	}
	
}
