package org.examples.arrays;

/**
 * 
 * 223. Rectangle Area Given the coordinates of two rectilinear rectangles in a
 * 2D plane, return the total area covered by the two rectangles.
 * 
 * The first rectangle is defined by its bottom-left corner (A, B) and its
 * top-right corner (C, D).
 * 
 * The second rectangle is defined by its bottom-left corner (E, F) and its
 * top-right corner (G, H).
 * 
 * 
 * 
 * Example 1:
 * 
 * Rectangle Area Input: A = -3, B = 0, C = 3, D = 4, E = 0, F = -1, G = 9, H =
 * 2 Output: 45 Example 2:
 * 
 * Input: A = -2, B = -2, C = 2, D = 2, E = -2, F = -2, G = 2, H = 2 Output: 16
 * 
 * 
 * Constraints:
 * 
 * -104 <= A, B, C, D, E, F, G, H <= 104
 * 
 * 
 * @author rkata
 *
 */
public class RectangleArea {

	public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
		int[] rec1 = new int[] { A, B, C, D };
		int rec1Area = computeArea(rec1);

		int[] rec2 = new int[] { E, F, G, H };
		int rec2Area = computeArea(rec2);

		int overlappedArea = computeAreaOfOverlappedRect(rec1, rec2);

		return rec1Area + rec2Area - overlappedArea;
	}

	public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
		if (rec1[0] == rec1[2] || rec1[1] == rec1[3] || rec2[0] == rec2[2] || rec2[1] == rec2[3]) {
			return false;
		}

		if ((rec1[2] <= rec2[0] || rec1[3] <= rec2[1] || rec1[0] >= rec2[2] || rec1[1] >= rec2[3])) {
			return false;
		}

		return true;
	}

	public int computeAreaOfOverlappedRect(int[] rec1, int[] rec2) {

		int x1 = Math.max(rec1[0], rec2[0]);
		int y1 = Math.max(rec1[1], rec2[1]);

		int x2 = Math.min(rec1[2], rec2[2]);
		int y2 = Math.min(rec1[3], rec2[3]);

		// int areaOfSqrA = (C-A) * (D-B);
		// int areaOfSqrB = (G-E) * (H-F);
		// int left = Math.max(A, E);
		// int right = Math.min(G, C);
		// int bottom = Math.max(F, B);
		// int top = Math.min(D, H);
		// return areaOfSqrA + areaOfSqrB - overlap;

		// If overlap
		if (x2 > x1 && y2 > y1) {
			return Math.abs(x2 - x1) * Math.abs(y2 - y1);
		} else {
			return 0;
		}
	}

	public int computeArea(int[] rec1) {
		return Math.abs(rec1[2] - rec1[0]) * Math.abs(rec1[3] - rec1[1]);
	}

}
