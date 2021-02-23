package org.examples.recursion;

import java.util.HashMap;
import java.util.Map;

public class RomanToString {

	public static void main(String[] args) {
		RomanToString romanToStr = new RomanToString();
//		System.out.println(romanToStr.romanToInt("III"));
//		System.out.println(romanToStr.romanToInt("XXVII"));
//		System.out.println(romanToStr.romanToInt("IV"));
//		System.out.println(romanToStr.romanToInt("IX"));
//		System.out.println(romanToStr.romanToInt("LVIII"));

		System.out.println(romanToStr.romanToInt("MCMXCIV"));

	}

	public int romanToInt(String s) {
		Map<Character, Integer> romanInts = buildMap();
		char prevRomanChar = s.charAt(0);
		int prevIntVal = romanInts.get(prevRomanChar);
		int curIntVal = prevIntVal;
		for (int i = 1; i < s.length(); i++) {
			char curRomanChar = s.charAt(i);
			int curRomanIntVal = romanInts.get(curRomanChar);

			if ((curRomanChar == 'V' || curRomanChar == 'X') && prevRomanChar == 'I') {
				curIntVal += (curRomanIntVal - 2 * romanInts.get('I'));
			} else if ((curRomanChar == 'L' || curRomanChar == 'C') && prevRomanChar == 'X') {
				curIntVal += (curRomanIntVal - 2 * romanInts.get('X'));
			} else if ((curRomanChar == 'D' || curRomanChar == 'M') && prevRomanChar == 'C') {
				curIntVal += (curRomanIntVal - 2 * romanInts.get('C'));
			} else {
				curIntVal += curRomanIntVal;
			}
			prevRomanChar = curRomanChar;
		}

		return curIntVal;
	}

	public Map<Character, Integer> buildMap() {
		Map<Character, Integer> mapOfRomans = new HashMap<>();
		mapOfRomans.put('I', 1);
		mapOfRomans.put('V', 5);
		mapOfRomans.put('X', 10);
		mapOfRomans.put('L', 50);
		mapOfRomans.put('C', 100);
		mapOfRomans.put('D', 500);
		mapOfRomans.put('M', 1000);
		return mapOfRomans;
	}

}
