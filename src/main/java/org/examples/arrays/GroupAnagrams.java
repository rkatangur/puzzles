package org.examples.arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * Given an array of strings strs, group the anagrams together. You can return
 * the answer in any order.
 * 
 * An Anagram is a word or phrase formed by rearranging the letters of a
 * different word or phrase, typically using all the original letters exactly
 * once.
 * 
 * Example 1:
 * 
 * Input: strs = ["eat","tea","tan","ate","nat","bat"] Output:
 * [["bat"],["nat","tan"],["ate","eat","tea"]]
 * 
 * @author rkata
 *
 */

public class GroupAnagrams {

	public static void main(String[] args) {
//		ArraysUtil.printIntArr(mapCharsInStr(str));

		GroupAnagrams solver = new GroupAnagrams();
//		solver.groupAnagrams(new String[] { "eat", "tea", "tan", "ate", "nat", "bat" });
		solver.canPermutePalindrome("aab");
	}

	private static String mapCharsInStrAndReturnUniqKey(String str) {
		int[] charsInStr = new int[26];
		int asciiValOfA = 'a';
		for (char c : str.toCharArray()) {
			int cIntVal = ((int) c) - asciiValOfA;
			charsInStr[cIntVal] += 1;
		}

		return buildStrKey(charsInStr);
	}

	private static String buildStrKey(int[] charsInStr) {
		int asciiValOfA = 'a';
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < charsInStr.length; i++) {
			if (charsInStr[i] > 0) {
				char cVal = (char) (asciiValOfA + i);
				sb.append(cVal).append('#').append(charsInStr[i]).append('|');
			}
		}
		return sb.toString();
	}

	public List<List<String>> groupAnagrams(String[] strs) {
		Map<String, List<String>> mapOfStrs = new HashMap<>();
		for (String str : strs) {
			String strKey = mapCharsInStrAndReturnUniqKey(str);
			List<String> anagramGrp = mapOfStrs.get(strKey);
			if (anagramGrp == null) {
				anagramGrp = new ArrayList<String>();
				mapOfStrs.put(strKey, anagramGrp);
			}
			anagramGrp.add(str);
		}

		return new ArrayList<List<String>>(mapOfStrs.values());
	}
	
	
	 public boolean canPermutePalindrome(String s) {
	        int[]  countOfCharsInS = mapCharsInStrAndReturnUniqKey1(s);
	        
	        boolean isSingleOddCharAllowed = true;
	        if(s.length() % 2 == 0){
	            isSingleOddCharAllowed = false;
	        }
	        
	        int numofOdd = 0;
	        int numOfEven = 0;
	        for(int i =0; i<countOfCharsInS.length; i++){
	            if(countOfCharsInS[i] == 0){
	                continue;
	            } else if(countOfCharsInS[i] % 2 == 0){
	                numOfEven++;
	            } else {
	                numofOdd++;
	            }
	        }
	        
	        if(isSingleOddCharAllowed && numofOdd>1){
	            return false;
	        } else if(!isSingleOddCharAllowed && numofOdd>0){
	            return false;
	        }
	        
	        return true;
	    }
	    
		private static int[] mapCharsInStrAndReturnUniqKey1(String str) {
			int[] charsInStr = new int[26];
			int asciiValOfA = 'a';
			for (char c : str.toCharArray()) {
				int cIntVal = ((int) c) - asciiValOfA;
				charsInStr[cIntVal] += 1;
			}

			return charsInStr;
		}

}
