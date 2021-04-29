package org.examples.arrays;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 1779. Find Nearest Point That Has the Same X or Y Coordinate
 * 
 * You are given two integers, x and y, which represent your current location on
 * a Cartesian grid: (x, y). You are also given an array points where each
 * points[i] = [ai, bi] represents that a point exists at (ai, bi). A point is
 * valid if it shares the same x-coordinate or the same y-coordinate as your
 * location.
 * 
 * Return the index (0-indexed) of the valid point with the smallest Manhattan
 * distance from your current location. If there are multiple, return the valid
 * point with the smallest index. If there are no valid points, return -1.
 * 
 * 
 * The Manhattan distance between two points (x1, y1) and (x2, y2) is abs(x1 -
 * x2) + abs(y1 - y2).
 * 
 * Example 1:
 * 
 * Input: x = 3, y = 4, points = [[1,2],[3,1],[2,4],[2,3],[4,4]] Output: 2
 * Explanation: Of all the points, only [3,1], [2,4] and [4,4] are valid. Of the
 * valid points, [2,4] and [4,4] have the smallest Manhattan distance from your
 * current location, with a distance of 1. [2,4] has the smallest index, so
 * return 2.
 * 
 * Example 2:
 * 
 * Input: x = 3, y = 4, points = [[3,4]] Output: 0 Explanation: The answer is
 * allowed to be on the same location as your current location.
 * 
 * Example 3: Input: x = 3, y = 4, points = [[2,3]] Output: -1 Explanation:
 * There are no valid points.
 * 
 * 
 * @author rkata
 *
 */
public class FindNearestPointThatHasSameXOrY {

	public int nearestValidPointV2(int x, int y, int[][] points) {
		
		int smallestDist = Integer.MAX_VALUE;
		int posOfPt = -1;
		for(int i =0; i<points.length; i++) {
			int distX = Math.abs(points[i][0] - x);
			int distY = Math.abs(points[i][1] - y);
			
			if(distX*distY == 0 && distX +distY<smallestDist) {
				smallestDist = distX + distY;
				posOfPt = i;
			}			
		}
		
		return posOfPt;
	}
	
	public int nearestValidPoint(int x, int y, int[][] points) {
		PriorityQueue<int[]> nearestPoints = new PriorityQueue<int[]>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				int dist = o1[0] - o2[0];
				if (dist == 0) {					
					return o1[1] - o2[1];
				}
				return dist;
			}
		});

		for (int i =0; i<points.length; i++) {
			int[] pt = points[i];
			int distOnX = Math.abs(pt[0] - x);
			int distOnY = Math.abs(pt[1] - y);
			int dist = distOnX + distOnY;

			if (distOnX == 0 || distOnY == 0) {
				if (nearestPoints.isEmpty()) {
					nearestPoints.offer(new int[] {dist, i});
				} else {
					int[] availMinPt = nearestPoints.peek();
					if (dist <= availMinPt[0]) {
						if (dist < availMinPt[0]) {
							nearestPoints.clear();
						}
						nearestPoints.offer(new int[] {dist, i});
					}
				}
			}
		}

		if (nearestPoints.isEmpty()) {
			return -1;
		} else {
			int[] nPoint = nearestPoints.poll();
			return nPoint[1];
		}
	}

	public static void main(String[] args) {
		FindNearestPointThatHasSameXOrY solver = new FindNearestPointThatHasSameXOrY();
		System.out.println(
				solver.nearestValidPoint(3, 4, new int[][] { { 1, 2 }, { 3, 1 }, { 2, 4 }, { 2, 3 }, { 4, 4 } }));
	}

}
