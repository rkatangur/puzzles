package org.examples.tree;

import java.util.ArrayList;
import java.util.Map;
import java.util.Set;

/*
We want to implement a “T9” mode to type words with the digit keys of a phone. The user presses the key that has the character she wants to use only once, and our algo suggests the best matches for the set of keys pressed. How would you implement such an algorithm?

Numeric keypad (The interviewer should draw it on the whiteboard):

1 
2 abc
3 def
4 ghi
5 jkl
6 mno
7 pqrs
8 tuv
9 wxyz

As "young" candidates may not be familiar with numeric keypads and/or T9 mode, it could be necessary to do the "old-timer" presentation:

In the beginning, texting was painful. To write a word like "sage", we had to press key 7 four times, then key 2 once, key 4 once, and key 3 twice. It was exhaustive. Then T9 mode arrived. We just had to press each key only once: 7, 2, 4, 3 for the word "sage". Many letter combinations match the input digit sequence, but as the phone contains a list of words (a lexicon), it suggests only the (few) matching valid words. Those were blessed days.

Input: 7 2 4 3
Ouput: [ "sage", "rage" ]

1. Indexing the words 
2. Lookup

7    [ "sage", "rage", "sink", "tall" ]
7 -> 2   [ "sage", "rage", "tall" ]
7->2->4  [ "sage", "rage" ]
7->2->4->3 [ "sage", "rage" ]


Trie:

N words
W max length of word

time: O(N*W)
space: O(NxW)
*/

public class T9PhoneLookup {
	  
	  public static int hash(char c){
	    
	  }
	  
	  //sup
	  //sage
	  //    7 2 4 3
	  
	  public class TrieNode{
	    
	    //7
	    private int number;
	    
	    // [r, s]
	    
	    //[s --> TrieNode(2, a)
	    
	    private Map<Integer, TrieNode> childNodeMap;
	    
	    // s --> a
	    // r --> a
	    private Map<Character, Set<Character>> charToCharMap;
	    private Map<Character, Set<Integer>> charToIntMap;
	    
	    private Set<String> words;
	  }

	  //  time: O(n) -> n = max number of typed numbers
	  // space: O(1)
	  public static String[] T9(int[] typedNumbers, TrieNode rootNode) {
	    
	    TrieNode nodeToUse = rootNode;
	    for(int i =0; i<typedNumbers.length; i++){
	          int curNum = typedNumbers[i];
	          TrieNode child = nodeToUse.get(curNum);
	          if(child != null){            
	            nodeTouse = child;
	          } else {
	            return null;
	          }
	    }
	    return nodeTouse.getWords();
	  }
	  
	  //n words
	  //m as max length
	  
	  //  time: O(n * m)
	  // space: O(n * m)
	  public static TrieNode Index(String[] words, TrieNode rootNode)
	  {
	        
	    for(String word: words){
	      TreeNode nodeToUse = rootNode;
	      for(int i =0; words.length; i++){
	          char firstChar = word.charAt(i);
	          int hasOfChar = hash(firstChar);
	          TreeNode childNode = nodeToUse.get(hasOfChar);
	          if(childNode == null) {
	            nodeToUse.add(hashOfChar, new TrieNode());
	          }

	          nodeToUse.get(hashOfChar).addDataElem(firstChar, word);
	          nodeToUse = childNode;
	      }
	      
	    }
	    
	  }
	                               
	  public static void main(String[] args) {
	    ArrayList<String> strings = new ArrayList<String>();
	    strings.add("Hello, World!");
	    strings.add("Welcome to CoderPad.");
	    strings.add("This pad is running Java " + Runtime.version().feature());

	    for (String string : strings) {
	      System.out.println(string);
	    }
	  }
	  
	  
	  public class Trie
	  
	  
	}

	
}
