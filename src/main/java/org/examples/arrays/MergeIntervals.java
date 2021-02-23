package org.examples.arrays;

/**
 * Input: intervals = [[1,3],[2,6],[8,10],[15,18]] Output:
 * [[1,6],[8,10],[15,18]] Explanation: Since intervals [1,3] and [2,6] overlaps,
 * merge them into [1,6].
 * 
 * Input: intervals = [[1,4],[4,5]] Output: [[1,5]] Explanation: Intervals [1,4]
 * and [4,5] are considered overlapping.
 * 
 * 
 * @author rkata
 *
 */
public class MergeIntervals {

	public static void main(String[] args) {
//		int[][] intervals = new int[][] { { 1, 3 }, { 2, 6 }, { 8, 10 }, { 15, 18 } };
//		int[][] intervals = new int[][] { { 1, 4 }, { 0, 0 } };
//		int[][] intervals = new int[][] { { 1, 6 }, { 0, 2 } };

//		int[][] intervals =  new int[][] {{1,10},{4,5},{6,7},{8,9}};
//		
		int[][] intervals = new int[][] { { 2, 3 }, { 4, 5 }, { 6, 7 }, { 8, 9 }, { 1, 10 } };
//		
//		int[][] intervals = new int[][] { { 3, 5 }, { 0, 0 }, { 4, 4 }, { 0, 2 }, { 5, 6 }, { 4, 5 }, { 3, 5 },
//				{ 1, 3 }, { 4, 6 }, { 4, 6 }, { 3, 4 } };

		ArraysUtil.printMatrix(intervals);
		intervals = merge(intervals);
		ArraysUtil.printMatrix(intervals);
	}

	public static int[][] merge(int[][] intervals) {

		int numOfMergedIntervals = 0;
		do {
			numOfMergedIntervals = 0;
			for (int i = 0; i < intervals.length; i++) {
				if (intervals[i].length == 0) {
					continue;
				}

				for (int j = i + 1; j < intervals.length; j++) {

					if (intervals[j].length == 0) {
						continue;
					}

					int[] ithInterval = intervals[i];
					int[] jthInterval = intervals[j];
					if ((ithInterval[0] <= jthInterval[0] && jthInterval[0] <= ithInterval[1])
							|| (ithInterval[0] >= jthInterval[0] && jthInterval[1] >= ithInterval[0])) {
						// this can be merged
						ithInterval[0] = Math.min(ithInterval[0], jthInterval[0]);
						ithInterval[1] = Math.max(ithInterval[1], jthInterval[1]);
						intervals[j] = new int[] {};
						System.out.println("Merging set at index " + i + " with other set at index " + j + ".");
						numOfMergedIntervals++;
					}
				}
			}

			int[][] mergedIntervals = new int[intervals.length - numOfMergedIntervals][];
			for (int i = 0, j = 0; i < intervals.length; i++) {
				if (intervals[i].length == 0) {
					continue;
				}
				mergedIntervals[j++] = intervals[i];
			}

			intervals = mergedIntervals;
		} while (numOfMergedIntervals >= 1);

		return intervals;
	}
}
