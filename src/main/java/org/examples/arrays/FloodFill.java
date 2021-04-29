package org.examples.arrays;

public class FloodFill {

	public static void main(String[] args) {
		FloodFill solver = new FloodFill();
//		int[][] image = new int[][] { { 1, 1, 1 }, { 1, 1, 0 }, { 1, 0, 1 } };
//		solver.floodFillRec(image, 1, 1, 2);

//		solver.floodFillRec(new int[][] { { 0, 0, 0 }, { 0, 1, 1 } }, 1, 1, 1);
//		
		ArraysUtil.printMatrix(solver.floodFill(new int[][] { { 0, 0, 0 }, { 0, 1, 1 } }, 1, 1, 1));
	}

//	public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
//
//		int startingPixel = image[sr][sc];
//		Queue<int[]> positionsQ = new LinkedList<int[]>();
//		positionsQ.add(new int[] { sr, sc });
//
//		while (!positionsQ.isEmpty()) {
//			int[] pos = positionsQ.poll();
//
//			if (sr + 1 < image.length) {
//				if (image[sr + 1][sc] == startingPixel)
//					positionsQ.add(new int[] { sr + 1, sc });
//			}
//
//			if (sr - 1 >= 0) {
//				if (image[sr - 1][sc] == startingPixel)
//					positionsQ.add(new int[] { sr - 1, sc });
//			}
//
//			if (sc + 1 < image[0].length) {
//				if (image[sr][sc + 1] == startingPixel)
//					positionsQ.add(new int[] { sr, sc + 1 });
//			}
//
//			if (sc - 1 >= 0) {
//				if (image[sr][sc - 1] == startingPixel)
//					positionsQ.add(new int[] { sr, sc - 1 });
//			}
//
//			if (image[pos[0]][pos[1]] == startingPixel) {
//				image[pos[0]][pos[1]] = newColor;
//			}
//		}
//
//		return image;
//	}

	public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
		int startingPixel = image[sr][sc];
		if (startingPixel != newColor)
			floodFillRecHelper(image, sr, sc, newColor, startingPixel);
		// for (int i = 0; i < image.length; i++) {
		// for (int j = 0; j < image[0].length; j++) {
		// if (image[i][j] == (newColor * -1)) {
		// image[i][j] = newColor;
		// }
		// }
		// }
		return image;
	}

	public void floodFillRecHelper(int[][] image, int sr, int sc, int newColor, int startingPixel) {

		if (sr >= image.length || sr < 0 || sc >= image[0].length || sc < 0 || image[sr][sc] != startingPixel) {
			return;
		}

		if (image[sr][sc] == startingPixel) {
			// image[sr][sc] = newColor * -1;
			image[sr][sc] = newColor;
			floodFillRecHelper(image, sr + 1, sc, newColor, startingPixel);
			floodFillRecHelper(image, sr - 1, sc, newColor, startingPixel);
			floodFillRecHelper(image, sr, sc + 1, newColor, startingPixel);
			floodFillRecHelper(image, sr, sc - 1, newColor, startingPixel);
		}
	}

}
