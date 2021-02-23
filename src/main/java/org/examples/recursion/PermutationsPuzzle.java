package org.examples.recursion;

public class PermutationsPuzzle {

//	Input: str = “abbb”
//	Output: [abbb, babb, bbab, bbba]
//
//	Input: str = “abc”
//	Output: [abc, bac, bca, acb, cab, cba]

	public static void main(String[] args) {
//		char[] carr = { 'c', 'a', 't', 's' };
		char[] carr = { 'a', 'b', 'c' };
//		buildAllPermutations(carr, carr.length);
		buildAllPermutations1(new char[] { 'a', 'b' }, 3);
	}

	private static void buildAllPermutations(char[] carr, int size) {

		if (size == 1) {
			System.out.println(new String(carr));
			return;
		}

		for (int i = 0; i < size; i++) {
			buildAllPermutations(carr, size - 1);
			rotate(carr, size);
		}

	}

	private static void rotate(char[] carr, int size) {
		int position = carr.length - size + 1;
		char temp = carr[position - 1];
		for (; position < carr.length; position++) {
			carr[position - 1] = carr[position];
		}
		carr[position - 1] = temp;
	}

	// The method that prints all
	// possible strings of length k.
	// It is mainly a wrapper over
	// recursive function printAllKLengthRec()
	// strings of length k
	private static void buildAllPermutations1(char[] carr, int k) {
		buildAllPermutations1(carr, "", carr.length, k);
	}

	/*
	 * Input: set[] = {'a', 'b'}, k = 3
	 * 
	 * Output: aaa aab aba abb baa bab bba bbb
	 * 
	 * Input: set[] = {'a', 'b', 'c', 'd'}, k = 1 Output: a b c d
	 */
	private static void buildAllPermutations1(char[] carr, String prefix, int n, int k) {

		if (k == 0) {
			System.out.println(prefix);
			return;
		}

		for (int i = 0; i < n; i++) {
			String newPrefix = prefix + carr[i];
			buildAllPermutations1(carr, newPrefix, n, k - 1);
		}
	}

}
