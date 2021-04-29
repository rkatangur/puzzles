package org.examples.arrays;

public class ItemsInContainers {
	
	
	import java.io.*;
	import java.math.*;
	import java.security.*;
	import java.text.*;
	import java.util.*;
	import java.util.concurrent.*;
	import java.util.function.*;
	import java.util.regex.*;
	import java.util.stream.*;
	import static java.util.stream.Collectors.joining;
	import static java.util.stream.Collectors.toList;



	class Result {

	    /*
	     * Complete the 'numberOfItems' function below.
	     *
	     * The function is expected to return an INTEGER_ARRAY.
	     * The function accepts following parameters:
	     *  1. STRING s
	     *  2. INTEGER_ARRAY startIndices
	     *  3. INTEGER_ARRAY endIndices
	     */

	    public static List<Integer> numberOfItems(String s, List<Integer> startIndices, List<Integer> endIndices) {
	        int sum =0;
	        int startOfContainer = -1;       
	        TreeMap<Integer, Integer> containerMap = new TreeMap<>();
	        //build a hashmap with the key as the starting index of | and maintain the sum of total number of containers seen thus far.
	        for(int i =0; i<s.length(); i++){
	            if(s.charAt(i) == '|'){
	                //container start
	                startOfContainer = i;
	                containerMap.put(startOfContainer, sum);
	            } else if(s.charAt(i) == '*' && startOfContainer >= 0){
	                sum++;
	            }
	        }
	        
	        List<Integer> results = new ArrayList<>();
	        for(int i=0; i<startIndices.size(); i++){            
	            Integer leftKey = containerMap.ceilingKey(startIndices.get(i) -1);
	            Integer rightKey = containerMap.floorKey(endIndices.get(i) - 1);
	            
	            if(leftKey == null || rightKey == null || leftKey.intValue()>=rightKey.intValue()){
	               results.add(0);
	            } else {
	               results.add(containerMap.get(rightKey) - containerMap.get(leftKey)); 
	            }
	        }
	        return results;
	    }

	}

	public class Solution {

}
