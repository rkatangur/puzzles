package org.examples.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EnclosedRectangles {

	public static void main(String[] args) {

		List<Rectangle> rectangles = new ArrayList<EnclosedRectangles.Rectangle>();
		rectangles.add(new Rectangle("A", new int[] { 0, 0 }, new int[] { 10, 2 }));
		rectangles.add(new Rectangle("B", new int[] { 2, 1 }, new int[] { 7, 8 }));
		rectangles.add(new Rectangle("C", new int[] { 4, 3 }, new int[] { 5, 6 }));
		rectangles.add(new Rectangle("D", new int[] { 3, 5 }, new int[] { 6, 7 }));

		findEnclosedRectangles(rectangles);
	}

	public static Rectangle findEnclosedRectangles(List<Rectangle> rectangles) {
		List<Rectangle> rectCombination = new ArrayList<EnclosedRectangles.Rectangle>();
		for (int i = 0; i < rectangles.size(); i++) {
			for (int j = i + 1; j < rectangles.size(); j++) {
				// check for the instersected rectangle.
				Rectangle intesection = findIntersectedRectangle(rectangles.get(i), rectangles.get(j));
				if (intesection != null) {
					System.out.println(intesection);
				}
			}
		}
		return null;
	}

	private static Rectangle findIntersectedRectangle(Rectangle rectangle1, Rectangle rectangle2) {

		if (rectangle1.topLeft[0] > rectangle2.bottomRight[0] || rectangle1.bottomRight[0] < rectangle2.topLeft[0]
				|| rectangle1.bottomRight[1] < rectangle2.topLeft[1]
				|| rectangle1.topLeft[1] > rectangle2.bottomRight[1]) {
			return null;
		}

		int topLeftRow = Math.max(rectangle1.topLeft[0], rectangle2.topLeft[0]);
		int topLeftCol = Math.max(rectangle1.topLeft[1], rectangle2.topLeft[1]);

		int bottomRightRow = Math.min(rectangle1.bottomRight[0], rectangle2.bottomRight[0]);
		int bottomRightCol = Math.min(rectangle1.bottomRight[1], rectangle2.bottomRight[1]);

		return new Rectangle(rectangle1.name + "-" + rectangle2.name, new int[] { topLeftRow, topLeftCol },
				new int[] { bottomRightRow, bottomRightCol });
	}

	public static class Rectangle {

		public Rectangle(String name) {
			this.name = name;
		}

		public Rectangle(String name, int[] topLeft, int[] bottomRight) {
			super();
			this.name = name;
			this.topLeft = topLeft;
			this.bottomRight = bottomRight;
		}

		String name;
		int[] topLeft;
		int[] bottomRight;

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public int[] getTopLeft() {
			return topLeft;
		}

		public void setTopLeft(int[] topLeft) {
			this.topLeft = topLeft;
		}

		public int[] getBottomRight() {
			return bottomRight;
		}

		public void setBottomRight(int[] bottomRight) {
			this.bottomRight = bottomRight;
		}

		@Override
		public String toString() {
			return "Rectangle [name=" + name + ", topLeft=" + Arrays.toString(topLeft) + ", bottomRight="
					+ Arrays.toString(bottomRight) + "]";
		}
	}
}
