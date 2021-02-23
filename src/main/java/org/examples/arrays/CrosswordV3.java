package org.examples.arrays;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
/**
 *
 * 	A  Crossword grid is provided to you, along with a set of words (or names of places) which need to be filled into the grid. Cells are marked either + or -.
 *  Cells marked with a - are to be filled with the word list.	
 *  The following shows an example crossword from the input  grid and the list of words to fit, :
 *  	
 *  	Input 	   		Output
 *  	
 *  	++++++++++ 		++++++++++
 *  	+------+++ 		+POLAND+++
 *  	+++-++++++ 		+++H++++++
 *  	+++-++++++ 		+++A++++++
 *  	+++-----++ 		+++SPAIN++
 *  	+++-++-+++ 		+++A++N+++
 *  	++++++-+++ 		++++++D+++
 *  	++++++-+++ 		++++++I+++
 *  	++++++-+++ 		++++++A+++
 *  	++++++++++ 		++++++++++
 *  	POLAND;LHASA;SPAIN;INDIA
 *  	Function Description
 *  	
 *  	Complete the crosswordPuzzle function in the editor below. It should return an array of strings, each representing a row of the finished puzzle.
 *  	
 *  	crosswordPuzzle has the following parameter(s):
 *  	
 *  	crossword: an array of  strings of length  representing the empty grid words: a string consisting of semicolon delimited strings to fit into 
 * 
 * 		@author rkata
 *
 */

public class CrosswordV3 {
	
	    // Complete the crosswordPuzzle function below.
	    static String[] crosswordPuzzle(String[] crosswords, String words) {
	    	
	    	String[] allWords = words.split(";");
	    	char[][] crosswordGrid = new char[crosswords.length][];
//    		char[] wordArr = crossword.toCharArray();

	    	for(int i=0; i<crosswordGrid.length ; i++) {
	    		char[] crossword = crosswordGrid[i];	    		
		    	for(int j=0; j<crossword.length; j++) {
		    		if(crossword[i] == '-') {
		    			fillCrossword
		    		}
		    	}
	    	}
	    	
	    	return null;
	    }
	    
	    
	 // Complete the crosswordPuzzle function below.
	    static String[] fillCrossword(char[][] crosswordGrid, int rowPos, int colPos) {
	    	
	    	return null;
	    }
	    
	    
//	    // Complete the crosswordPuzzle function below.
//	    static String[] crosswordPuzzle(String[] crosswords, String words) {
//	    	
//	    	for(String crossword : crosswords) {
//	    		crossword.toCharArray();
//	    		
//	    	}
//	    		    	
//	    	return null;
//	    }


	    private static final Scanner scanner = new Scanner(System.in);

	    public static void main(String[] args) throws IOException {
	        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

	        String[] crossword = new String[10];

	        for (int i = 0; i < 10; i++) {
	            String crosswordItem = scanner.nextLine();
	            crossword[i] = crosswordItem;
	        }

	        String words = scanner.nextLine();

	        String[] result = crosswordPuzzle(crossword, words);

	        for (int i = 0; i < result.length; i++) {
	            bufferedWriter.write(result[i]);

	            if (i != result.length - 1) {
	                bufferedWriter.write("\n");
	            }
	        }

	        bufferedWriter.newLine();

	        bufferedWriter.close();

	        scanner.close();
	    }

}
