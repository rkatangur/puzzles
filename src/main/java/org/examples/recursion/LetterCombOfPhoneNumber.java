package org.examples.recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * Given a string containing digits from 2-9 inclusive, return all possible
 * letter combinations that the number could represent. Return the answer in any
 * order. A mapping of digit to letters (just like on the telephone buttons) is
 * given below. Note that 1 does not map to any letters.
 * 
 * Input: digits = "23" Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
 * 
 * Input: digits = "2" Output: ["a","b","c"]
 * 
 * @param args
 */
public class LetterCombOfPhoneNumber {

	private char[][] digitToCharMappings = new char[][] { { 'a', 'b', 'c' }, { 'd', 'e', 'f' }, { 'g', 'h', 'i' },
			{ 'j', 'k', 'l' }, { 'm', 'n', 'o' }, { 'p', 'q', 'r', 's' }, { 't', 'u', 'v' }, { 'w', 'x', 'y', 'z' } };

	public static void main(String[] args) {
		LetterCombOfPhoneNumber solver = new LetterCombOfPhoneNumber();
		String digits = "23";
		List<String> resStr = solver.letterCombinations(digits);
		for (String str : resStr) {
			System.out.println(str);
		}
	}

	public List<String> letterCombinations(String digits) {
		List<char[]> digitChars = new ArrayList<char[]>();
		for (int i = 0; i < digits.length(); i++) {
			int digit = digits.charAt(i) - 48;
			digitChars.add(digitToCharMappings[digit - 2]);
		}

		List<String> result = new ArrayList<String>();
		char[] comb = new char[digitChars.size()];

		letterCombinationsHelper(digitChars, 0, comb, 0, result);
		return result;
	}

	public void letterCombinationsHelper(List<char[]> listOfDigitChars, int arrayIndex, char[] comb, int combIndex,
			List<String> result) {

		if (combIndex == comb.length) {
			result.add(String.valueOf(comb));
			return;
		}

		char[] digitChars = listOfDigitChars.get(arrayIndex);
		for (int i = 0; i < digitChars.length; i++) {
			comb[combIndex] = digitChars[i];
			letterCombinationsHelper(listOfDigitChars, arrayIndex + 1, comb, combIndex + 1, result);
		}
	}

}
