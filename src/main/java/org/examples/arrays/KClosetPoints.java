package org.examples.arrays;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 
 * 973. K Closest Points to Origin
 * 
 * Given an array of points where points[i] = [xi, yi] represents a point on the
 * X-Y plane and an integer k, return the k closest points to the origin (0, 0).
 * 
 * The distance between two points on the X-Y plane is the Euclidean distance
 * (i.e., (x1 - x2)2 + (y1 - y2)2).
 * 
 * You may return the answer in any order. The answer is guaranteed to be unique
 * (except for the order that it is in).
 * 
 * Input: points = [[1,3],[-2,2]], k = 1 Output: [[-2,2]]
 * 
 * Explanation: The distance between (1, 3) and the origin is sqrt(10). The
 * distance between (-2, 2) and the origin is sqrt(8). Since sqrt(8) < sqrt(10),
 * (-2, 2) is closer to the origin. We only want the closest k = 1 points from
 * the origin, so the answer is just [[-2,2]].
 * 
 * Example 2:
 * 
 * Input: points = [[3,3],[5,-1],[-2,4]], k = 2 Output: [[3,3],[-2,4]]
 * Explanation: The answer [[-2,4],[3,3]] would also be accepted.
 * 
 * @author rkata
 *
 */
public class KClosetPoints {

	public static void main(String[] args) {
		KClosetPoints solver = new KClosetPoints();
		ArraysUtil.printMatrix(solver.kClosest(new int[][] { { 1, 3 }, { -2, 2 } }, 1));

//		[[1,3],[-2,2]]
//				1
	}

	public int[][] kClosest(int[][] points, int k) {
		int[] srcPt = new int[] { 0, 0 };
		PriorityQueue<int[]> sortedPoints = new PriorityQueue<int[]>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[2] - o2[2];
			}
		});

		for (int[] p : points) {
			int dist = (int) (Math.pow((p[0] - srcPt[0]), 2) + Math.pow((p[1] - srcPt[1]), 2));
			int[] ptWithDist = new int[] { p[0], p[1], dist };
			sortedPoints.add(ptWithDist);
		}

		int[][] ptArr = new int[k][];
		int i = 0;
		while (i < k && !sortedPoints.isEmpty()) {
			int[] ptFromQ = sortedPoints.poll();
			ptArr[i++] = new int[] { ptFromQ[0], ptFromQ[1] };
		}

		return ptArr;
	}
}
