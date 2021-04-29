package org.examples.arrays;

public class OptimizingBoxWeights {
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
	     * Complete the 'minimalHeaviestSetA' function below.
	     *
	     * The function is expected to return an INTEGER_ARRAY.
	     * The function accepts INTEGER_ARRAY arr as parameter.
	     */

	    public static List<Integer> minimalHeaviestSetA(List<Integer> arr) {
	        List<Integer> result = new ArrayList<>();
	        Collections.sort(arr, Collections.reverseOrder());
	        long totalSum = 0;
	        for(int i=0; i<arr.size(); i++){
	            totalSum += arr.get(i);
	        }
	        long bVal = totalSum;
	        long aVal =0;
	        for(int i=0; i<arr.size(); i++){            
	            aVal +=  arr.get(i);
	            result.add(0, arr.get(i));
	            bVal -= arr.get(i);
	            if(aVal > bVal) break;
	        }
	        return result;
	    }

	}
	public class Solution {
}
