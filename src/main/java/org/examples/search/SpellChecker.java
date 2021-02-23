package org.examples.search;
/*
 Spell Checker:
 Given a list of strings as our dictionary, for a given input, we want to match it to a dictionary word based on two rules:
 1. Case insensitive
 2. Vowel rule: all vowels are considered to be the same
 
 For example:
 dict = {"Red", "Blue", "Green"} size of dictionary N is farily large
 input1: "red" => "Red"
 input2: "rad" => "Red"
 
 
 char[26]{a .......r}
 
 char[i] -> trie of r

  b          r 
    l      e
      u  d
    e
    
O(log e) where e  be the number of different words available with the prefix of r

prefixchar --> {lowercase word --> dictionary word}
r  --> [
          {red --> Red},
          {rod --> rod}
       ]
b  --> [ {"blue" -> "Blue"}]  
          "rad"
          
          
for rad or rud then I have to process all words of length 3

Map<char, Map<String, String>>

 The goal is to optimize the lookup
 
 */

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import org.examples.arrays.ArraysUtil;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */

class SpellChecker {

	public static void main(String[] args) {
//	    ArrayList<String> strings = new ArrayList<String>();
//	    strings.add("Hello, World!");
//	    strings.add("Welcome to CoderPad.");
//	    strings.add("This pad is running Java " + Runtime.version().feature());
		//
//	    for (String string : strings) {
//	      System.out.println(string);
//	    }

		SpellChecker solver = new SpellChecker();
//		solver.spellchecker(new String[] { "Red", "Blue", "Green" }, new String[] {"Rad"});
//		solver.spellchecker(new String[] { "Red", "Blue", "Green" }, new String[] {"Rud"});
//		solver.spellchecker(new String[] { "Red", "Blue", "Green" }, new String[] {"Red"});

		String[] results = solver.spellchecker(new String[] {"KiTe","kite","hare","Hare"},
				new String[]{"kite","Kite","KiTe","Hare","HARE","Hear","hear","keti","keet","keto"});
		

//		String[] results = solver.spellchecker(new String[] { "ae", "aa" }, new String[] { "UU" });
		System.out.println(results.length);
	}

	int[] vowels = new int[127];
	private Map<String, String> word_orig = new HashMap<>();
	private Map<String, String> word_low = new HashMap<>();
	private Map<String, String> word_vow = new HashMap<>();

	private void recordVowels() {
		vowels[(int) 'a'] = 1;
		vowels[(int) 'e'] = 1;
		vowels[(int) 'i'] = 1;
		vowels[(int) 'o'] = 1;
		vowels[(int) 'u'] = 1;
	}

	private void buildDictionary(String[] wordlist) {
		// Building the dictionary from wordlist
		for (String dicWord : wordlist) {
			word_orig.put(dicWord, dicWord);			
			String dicWordLC = dicWord.toLowerCase();
			word_low.putIfAbsent(dicWordLC, dicWord);
			word_vow.putIfAbsent(buildVowStr(dicWordLC), dicWord);
		}
	}

	public String[] spellchecker(String[] wordlist, String[] queries) {
		recordVowels();
		buildDictionary(wordlist);

		String[] results = new String[queries.length];
		int i = 0;
		// finding the word in the dictionary
		for (String targetWord : queries) {

			String targetWordLower = targetWord.toLowerCase();
			String targetWordInMap = word_orig.get(targetWord);
			if(targetWordInMap != null) {
				results[i++] = targetWordInMap;
				continue;
			}
			
			targetWordInMap = word_orig.get(targetWord);
			if(targetWordInMap != null) {
				results[i++] = targetWordInMap;
				continue;
			}
			
			String targetWordVWStr = buildVowStr(targetWordLower);
			targetWordInMap = word_vow.get(targetWordVWStr);
			if(targetWordInMap != null) {
				results[i++] = targetWordInMap;
				continue;
			}
			
			results[i++] = "";
		}
		return results;
	}

	private String buildVowStr(String dicWord) {
		StringBuilder wildCardVowWord = new StringBuilder();
		for (int i = 0; i < dicWord.length(); i++) {
			int dicWordCharAsInt = dicWord.charAt(i);
			if (dicWordCharAsInt < 97)
				dicWordCharAsInt = ((int) dicWordCharAsInt + 32);
			
			if (vowels[dicWordCharAsInt] == 1) {
				wildCardVowWord.append("-");
			} else {
				wildCardVowWord.append(dicWord.charAt(i));
			}
		}
		return wildCardVowWord.toString();
	}

}
