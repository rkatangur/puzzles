package org.examples.arrays;

//Given s = "the sky is blue",
//return "blue is sky the".
//
//Could you do it in-place without allocating extra space?

public class ReverseStrings {

	public static void main(String[] args) {
		reverse("the sky is blue");
	}

	public static void reverse(String str) {
		char[] charArr = str.toCharArray();
		int j = 0;
		for (int i = 0; i < charArr.length; i++) {
			if (charArr[i] == ' ') {
				reverse(charArr, j, i - 1);
				j = i + 1;
			}
		}
		reverse(charArr, j, charArr.length - 1);
		printArray(charArr);
		reverse(charArr, 0, charArr.length - 1);
		printArray(charArr);
	}

	private static void printArray(char[] charArr) {
		for (char c : charArr) {
			System.out.print(c);
		}
		System.out.println();
	}

	private static void reverse(char[] charArr, int i, int j) {
		while (i < j) {
			char temp = charArr[j];
			charArr[j] = charArr[i];
			charArr[i] = temp;
			i++;
			j--;
		}
	}
}
