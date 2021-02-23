package org.examples.recursion;

/*
 *
 * 
 * Permutation is an arrangement of things in a definite order. Suppose you want to list all the
 * anagrams of a specified word—that is, all possible permutations (whether they make a real English
 * word or not) that can be made from the letters of the original word. We’ll call this anagramming
 * a word. Anagramming cat, for example, would produce • cat • cta • atc • act • tca • tac
 */
public class Anagram {


  private static void doAnagram(char[] charArray, int newSize) {
    if (newSize == 1) {
      return;
    }
    for (int i = 0; i < newSize; i++) {
      doAnagram(charArray, newSize - 1);
      if (newSize == 2) {
        displayWord(charArray);
      }
      rotate(charArray, newSize);
    }
  }

  private static void displayWord(char[] charArray) {
    for (char c : charArray) {
      System.out.print(c);
    }
    System.out.println();
  }

  private static void rotate(char[] charArray, int newSize) {
    int position = charArray.length - newSize;
    int j = position + 1;
    char temp = charArray[position];
    for (; j < charArray.length; j++) {
      charArray[j - 1] = charArray[j];
    }
    charArray[j - 1] = temp;
  }

  public static void main(String[] args) {
    doAnagram(new char[] {'c', 'a', 't', 's'});
  }

  private static void doAnagram(char[] cs) {
    doAnagram(cs, cs.length);
  }
}
