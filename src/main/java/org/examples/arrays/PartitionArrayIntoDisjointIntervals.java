package org.examples.arrays;
/**
 * 915. Partition Array into Disjoint Intervals
 * 
 * Given an array A, partition it into two (contiguous) subarrays left and right so that:
 * 
 * 	Every element in left is less than or equal to every element in right.
 * 	left and right are non-empty.
 * 	left has the smallest possible size.
 * 	Return the length of left after such a partitioning.  It is guaranteed that such a partitioning exists.	
 * 
 * 	 
 * 	
 * 	Example 1:
 * 	
 * 	Input: [5,0,3,8,6]
 * 	Output: 3
 * 	Explanation: left = [5,0,3], right = [8,6]
 * 
 * 	Example 2:
 * 	
 * 	Input: [1,1,1,0,6,12]
 * 	Output: 4
 * 	Explanation: left = [1,1,1,0], right = [6,12]
 * 
 * @author rkata
 *
 */

public class PartitionArrayIntoDisjointIntervals {

	public int partitionDisjoint(int[] A) {

		int pivot = 0;
		int maxElemOnLeftSide = A[0];
		int maxElemOnSofar = -1;
		// int maxElemOnLeftSide =A[pivot];
		for (int i = 0; i < A.length; i++) {
			maxElemOnSofar = Math.max(A[i], maxElemOnSofar);

			if (A[i] < maxElemOnLeftSide) {
				pivot = i;
				maxElemOnLeftSide = maxElemOnSofar;
			}
		}

		return pivot + 1;
	}

}
