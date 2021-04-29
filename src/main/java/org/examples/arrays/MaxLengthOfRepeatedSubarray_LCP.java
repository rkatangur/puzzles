package org.examples.arrays;

/**
 *
 * 718. Maximum Length of Repeated Subarray
 * 
 * Given two integer arrays A and B, return the maximum length of an subarray
 * that appears in both arrays.
 * 
 * Example 1:
 * 
 * Input: A: [1,2,3,2,1] B: [3,2,1,4,7] Output: 3 Explanation: The repeated
 * subarray with maximum length is [3, 2, 1].
 * 
 * 
 * Note:
 * 
 * 1 <= len(A), len(B) <= 1000 0 <= A[i], B[i] < 100
 *
 * 
 * @author rkata
 *
 */
public class MaxLengthOfRepeatedSubarray_LCP {

	public int findLength(int[] A, int[] B) {

//		return findLengthBottomUp(A, B);
		return findLengthTopDown(A, B);
	}

	public int findLengthBottomUp(int[] A, int[] B) {
		int[][] lcpMat = new int[A.length + 1][B.length + 1];

		int maxLen = 0;
		for (int i = A.length - 1; i >= 0; i--) {
			for (int j = B.length - 1; j >= 0; j--) {
				if (A[i] == B[j]) {
					lcpMat[i][j] = lcpMat[i + 1][j + 1] + 1;
					maxLen = Math.max(maxLen, lcpMat[i][j]);
				}
			}
		}

		return maxLen;
	}

	public int findLengthTopDown(int[] A, int[] B) {
		int[][] lcpMat = new int[A.length + 1][B.length + 1];

		int maxLen = 0;
		for (int i = 1; i <= A.length; i++) {
			for (int j = 1; j <= B.length; j++) {
				
				if (A[i-1] == B[j-1]) {
					lcpMat[i][j] = lcpMat[i - 1][j - 1] + 1;
					maxLen = Math.max(maxLen, lcpMat[i][j]);
				}
			}
		}

		return maxLen;
	}

}
