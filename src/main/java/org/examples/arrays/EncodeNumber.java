package org.examples.arrays;
/**
 * 
 * 1256. Encode Number
 * 
 * Given a non-negative integer num, Return its encoding string.

The encoding is done by converting the integer to a string using a secret function that you should deduce from the following table:



 

Example 1:

Input: num = 23
Output: "1000"
Example 2:

Input: num = 107
Output: "101100"
 

Constraints:

0 <= num <= 10^9
 * 
 * @author rkata
 *
 */
public class EncodeNumber {

	 public String encode(int num) {
	        String[] dp = new String[3];
	        dp[0] = "";
	        dp[1] = "0";
	        dp[2] = "1";
	        return encodeHelper(num, dp);            
	    }
	    
	    public String encodeHelper(int num, String[] dp) {
	        
	        if(num<3 && dp[num] != null){
	            return dp[num];
	        }
	        
	        String res = "";
	        res += encodeHelper((num-1)/2, dp);
	        if(num %2 == 1){
	            res += "0";
	        } else {
	            res += "1";
	        }
	        
	        return res;
	    }
	
}
