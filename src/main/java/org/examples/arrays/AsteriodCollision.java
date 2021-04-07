package org.examples.arrays;

import java.util.Stack;

/**
 * 735. Asteroid Collision
 * 
 * @author rkata
 *
 */

public class AsteriodCollision {

	public static void main(String[] args) {
		AsteriodCollision solver = new AsteriodCollision();
//		ArraysUtil.printIntArr(solver.asteroidCollision(new int[] { 5, 10, -5 }));
//		ArraysUtil.printIntArr(solver.asteroidCollision(new int[] { 8, -8 }));
//		ArraysUtil.printIntArr(solver.asteroidCollision(new int[] { 10, 2, -5 }));
//		ArraysUtil.printIntArr(solver.asteroidCollision(new int[] { -2, -1, 1, 2 }));
//		ArraysUtil.printIntArr(solver.asteroidCollision(new int[] { -2, -2, 1, -1 }));
//		ArraysUtil.printIntArr(solver.asteroidCollision(new int[] { -2, 1, -1, -2 }));
//		ArraysUtil.printIntArr(solver.asteroidCollision(new int[] { -2, 2, -1, -2 }));
		ArraysUtil.printIntArr(solver.asteroidCollision(new int[] { 10, 2, -5 }));
//		ArraysUtil.printIntArr(solver.asteroidCollision(new int[] { -2, 1, -1, -1 }));
//		ArraysUtil.printIntArr(solver.asteroidCollision(new int[] { -2, 2, -1, 1 }));
//		[-2,1,-1,-2]
	}

	public int[] asteroidCollision(int[] asteroids) {

		Stack<Integer> leftoverAsteroids = new Stack<Integer>();

		for (int i = asteroids.length - 1; i >= 0; i--) {
			boolean addAsteroid = true;
			while (asteroids[i] > 0 && !leftoverAsteroids.isEmpty() && leftoverAsteroids.peek() < 0) {
				if (asteroids[i] > leftoverAsteroids.peek() * -1) { 
					leftoverAsteroids.pop();
				} else if (asteroids[i] == leftoverAsteroids.peek() * -1) {
					addAsteroid = false;
					leftoverAsteroids.pop();
					break;
				} else {
					addAsteroid = false;
					break;
				}
			}

			if(addAsteroid) {
				leftoverAsteroids.add(asteroids[i]);
			}
		}

		int i = 0;
		int[] results = new int[leftoverAsteroids.size()];
		while (!leftoverAsteroids.isEmpty()) {
			results[i++] = leftoverAsteroids.pop();
		}

		return results;
	}

}
