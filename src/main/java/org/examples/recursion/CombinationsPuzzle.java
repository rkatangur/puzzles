package org.examples.recursion;

public class CombinationsPuzzle {

//	Input: 
//		set[] = {'a', 'b'}, k = 3
//
//		Output:
//		aaa
//		aab
//		aba
//		abb
//		baa
//		bab
//		bba
//		bbb

//	aaa
//	aab
//		aab
//	aba
//	abb
//		abb
//		abb
//	baa
//	bab
//		bab
//	bba
//	bbb
//		bbb
//		bbb

	public static void main(String[] args) {
		char[] carr = { 'a', 'b' };
		buildAllCombinations(carr, 3, 3, new char[3]);
	}

	public static void buildAllCombinations(char[] cArr, int k, int curK, char[] dupCArr) {
		if (curK <= 0) {
			System.out.println(new String(dupCArr));
			return;
		}

		int position = k - curK;
		for (char c : cArr) {
			dupCArr[position] = c;
			buildAllCombinations(cArr, k, curK - 1, dupCArr);
		}
	}

}
