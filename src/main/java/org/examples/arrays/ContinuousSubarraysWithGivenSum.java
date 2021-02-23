package org.examples.arrays;

import java.util.HashMap;
import java.util.Map;

/**
 * 560. Subarray Sum Equals K
 * 
 * Given an array of integers nums and an integer k, return the total number of
 * continuous subarrays whose sum equals to k.
 * 
 * Example 1: Input: nums = [1,1,1], k = 2 Output: 2
 * 
 * Example 2: Input: nums = [1,2,3], k = 3 Output: 2
 * 
 * 
 * Constraints: 1 <= nums.length <= 2 * 104 -1000 <= nums[i] <= 1000 -107 <= k
 * <= 107
 * 
 * @author rkata
 *
 */
public class ContinuousSubarraysWithGivenSum {

	public static void main(String[] args) {
		ContinuousSubarraysWithGivenSum solver = new ContinuousSubarraysWithGivenSum();
//		System.out.println(solver.subarraySum1(new int[] { 1, 1, 1 }, 2));// 2
		System.out.println(solver.subarraySum1(new int[] { 1, 1, 1, 1, -1 }, 2));// 2
//		System.out.println(solver.subarraySum(new int[] { 1, 2, 3 }, 3));//2
//		System.out.println(solver.subarraySum(new int[] { 1, -1, 0 }, 0)); // 3
//
//		System.out.println(solver.subarraySum(new int[] { -1, -1, 1 }, 0));//1
//		System.out.println(solver.subarraySum(new int[] { -1, -1, 1 }, 1));//1
	}

//	sum =0, {1, -1, 0}
//	work:
//		count =0
//		
//		0->1 map of sums to numoftimes
//		
//		i=0, elem=1, workingsum=1, 1->0, count =0 
//		i=1, elem=-1, workingsum=0, ((wsum)0-0(k))==0(k), -1->0, count=1, 
//		i=2, elem=0, workingsum=0, ((wsum)0-0(k))==0(k), 0->0, count =2,
//	
	public int subarraySum1(int[] arr, int k) {

		int count = 0;
		int workingSum = 0;
		Map<Integer, Integer> mapOfInts = new HashMap<Integer, Integer>();
		mapOfInts.put(0, 1);

		for (int num : arr) {
			workingSum += num;
			if (mapOfInts.containsKey(workingSum - k)) {
				count += mapOfInts.get(workingSum - k);
			}

			mapOfInts.put(workingSum, mapOfInts.getOrDefault(workingSum, 0) + 1);
		}

		return count;
	}

	/**
	 * 
	 * If the cumulative sum(represented by sum[i] for sum upto i^th index) upto two
	 * indices is the same, the sum of the elements lying in between those indices
	 * is zero. Extending the same thought further, if the cumulative sum upto two
	 * indices, say i and j is at a difference of k i.e. if sum[i]-sum[j]=k, the sum
	 * of elements lying between indices ii and j is k.
	 * 
	 * @param nums
	 * @param sum
	 * @return
	 */
	public int subarraySum(int[] nums, int sum) {

		Map<Integer, Integer> mapOfSums = new HashMap<Integer, Integer>();
		mapOfSums.put(0, 1);

		int curRunningSum = 0;
		int numOfSubarrays = 0;
		for (int i = 0; i < nums.length; i++) {
			curRunningSum += nums[i];

			if (mapOfSums.containsKey(curRunningSum - sum)) {
				numOfSubarrays += mapOfSums.get(curRunningSum - sum);
			}

			mapOfSums.put(curRunningSum, mapOfSums.getOrDefault(curRunningSum, 0) + 1);
		}

		return numOfSubarrays;
	}

}
