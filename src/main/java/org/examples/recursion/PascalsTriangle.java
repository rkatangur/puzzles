package org.examples.recursion;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {
	
/**
 * 
 * Follow up:

Could you optimize your algorithm to use only O(k) extra space?

 

Example 1:

Input: rowIndex = 3
Output: [1,3,3,1]
Example 2:

Input: rowIndex = 0
Output: [1]
Example 3:

Input: rowIndex = 1
Output: [1,1]
 * 
 * 
 * @param rowIndex
 * @return
 */
	  public List<Integer> getRow(int rowIndex) {
	        List<Integer> rowInts = new ArrayList<Integer>();
	        if(rowIndex <= 0){
	            rowInts.add(1);
	            return rowInts;
	        } 
	        // else if(rowIndex == 1){
	        //     rowInts.add(rowIndex);
	        //     rowInts.add(rowIndex);
	        //     return rowInts;
	        // }       
	        
	        rowInts.add(1);
	        List<Integer> rowInts1 = getRow(rowIndex -1);
	        for(int i=0;i<rowInts1.size()-1; i++){
	            rowInts.add(rowInts1.get(i) + rowInts1.get(i + 1));
	        }
	        
	        rowInts.add(1);
	        return rowInts; 
	    }

}
