package org.examples.stacks;

import java.util.Stack;

import org.examples.arrays.ArraysUtil;

/**
 * Given a list of daily temperatures T, return a list such that, for each day
 * in the input, tells you how many days you would have to wait until a warmer
 * temperature. If there is no future day for which this is possible, put 0
 * instead.
 * 
 * For example, given the list of temperatures T = [73, 74, 75, 71, 69, 72, 76,
 * 73], your output should be [1, 1, 4, 2, 1, 1, 0, 0].
 * 
 * Note: The length of temperatures will be in the range [1, 30000]. Each
 * temperature will be an integer in the range [30, 100].
 * 
 * @author rkata
 *
 */
public class DailyTemperatures {

	public static void main(String[] args) {
		int[] dailyTemps = new int[] { 73, 74, 75, 71, 69, 72, 76, 73 };
		DailyTemperatures solver = new DailyTemperatures();
		ArraysUtil.printIntArr(solver.dailyTemperatures(dailyTemps));
	}

	public int[] dailyTemperatures(int[] T) {
		int[] warmerTemps = new int[T.length];
		Stack<Integer> tempsStack = new Stack<Integer>();
		tempsStack.push(T.length - 1);
		for (int i = T.length - 1; i >= 0; i--) {
			int curTemp = T[i];
			int maxTempIndex = tempsStack.peek();
			if (curTemp >= T[maxTempIndex]) {
				while (maxTempIndex >= 0 && curTemp >= T[maxTempIndex]) {
					System.out.println("curTemp " + curTemp);
					tempsStack.pop();
					if (tempsStack.isEmpty()) {
						maxTempIndex = i;
						break;
					}

					maxTempIndex = tempsStack.peek();
				}

				warmerTemps[i] = maxTempIndex - i;
				tempsStack.push(i);
			} else if (curTemp < T[tempsStack.peek()]) {
				warmerTemps[i] = tempsStack.peek() - i;
				tempsStack.push(i);
			}
		}
		return warmerTemps;
	}

	public int[] dailyTemperaturesBruteForce(int[] T) {
		int[] warmerTemps = new int[T.length];
		for (int i = 0; i < T.length; i++) {
			int j = i + 1;
			while (j < T.length) {
				if (T[j] > T[i]) {
					warmerTemps[i] = j - i;
					break;
				}
				j++;
			}
		}
		return warmerTemps;
	}

}
