package org.examples.recursion;

import java.util.ArrayList;
import java.util.List;

public class GroupAnagram {

	public static void main(String[] args) {
		GroupAnagram grpAnagram = new GroupAnagram();
		List<List<String>> groupAnagrams = grpAnagram.groupAnagrams(new String[] { "eat", "tea", "tan", "ate", "nat", "bat" });

		for (List<String> anagramGrp : groupAnagrams) {
			System.out.print("[ ");
			for (String anagram : anagramGrp) {
				System.out.print(anagram + ",");
			}
			System.out.println(" ]");
		}
	}

	public List<List<String>> groupAnagrams(String[] strs) {

		List<List<String>> anagramGroups = new ArrayList<>();
		int[] anagramStrIndex = new int[strs.length];

		for (int i = 0; i < strs.length; i++) {
			if (anagramStrIndex[i] == 1) {
				continue;
			}

			String strAtI = strs[i];
			List<String> anagramsOfStrAtI = doAnagrams(strAtI);

			List<String> anagramGroup = new ArrayList<>();
			anagramGroup.add(strAtI);

			for (int j = i + 1; j < strs.length; j++) {
				if (anagramStrIndex[j] == 1) {
					continue;
				}

				if (anagramsOfStrAtI.contains(strs[j])) {
					anagramStrIndex[j] = 1;
					anagramGroup.add(strs[j]);
				}
			}

			anagramStrIndex[i] = 1;
			anagramGroups.add(anagramGroup);
		}

		return anagramGroups;
	}

	private List<String> doAnagrams(String strAtI) {
		List<String> anagrams = new ArrayList<String>();
		doAnagrams(strAtI.toCharArray(), strAtI.length(), anagrams);
		return anagrams;
	}

	private void doAnagrams(char[] carr, int newSize, List<String> anagrams) {
		if (newSize == 1) {
			return;
		}

		for (int i = 0; i < newSize; i++) {
			doAnagrams(carr, newSize - 1, anagrams);
			if (newSize == 2) {
				// record the charArray
				anagrams.add(new String(carr));
			}
			rotate(carr, newSize);
		}
	}

	private void rotate(char[] str, int size) {
		int position = str.length - size;
		char tempChar = str[position];
		for (; position < str.length - 1; position++) {
			str[position] = str[position + 1];
		}
		str[position] = tempChar;
	}

//	[ eat,tea,ate, ]
//	[ tan,nat, ]
//	[ bat, ]
//
//	  private static void rotate(char[] charArray, int newSize) {
//		    int position = charArray.length - newSize;
//		    int j = position + 1;
//		    char temp = charArray[position];
//		    for (; j < charArray.length; j++) {
//		      charArray[j - 1] = charArray[j];
//		    }
//		    charArray[j - 1] = temp;
//		  }
//
}
