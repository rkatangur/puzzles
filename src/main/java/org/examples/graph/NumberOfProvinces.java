package org.examples.graph;

import java.util.Stack;

/**
 * 547. Number of Provinces
 * 
 * 
 * There are n cities. Some of them are connected, while some are not. If city a
 * is connected directly with city b, and city b is connected directly with city
 * c, then city a is connected indirectly with city c. A province is a group of
 * directly or indirectly connected cities and no other cities outside of the
 * group.
 * 
 * You are given an n x n matrix isConnected where isConnected[i][j] = 1 if the
 * ith city and the jth city are directly connected, and isConnected[i][j] = 0
 * otherwise.
 * 
 * Return the total number of provinces.
 * 
 * 
 * @author rkata
 *
 */
public class NumberOfProvinces {

	public static void main(String[] args) {
		NumberOfProvinces solver = new NumberOfProvinces();
		int[][] conns = new int[][] { { 1, 1, 0 }, { 1, 1, 0 }, { 0, 0, 1 } };
//		int[][] conns = new int[][] { { 1, 0, 0, 1 }, { 0, 1, 1, 0 }, { 0, 1, 1, 1 }, { 1, 0, 1, 1 } };

		System.out.println(solver.findCircleNum(conns));
	}

//	[[1,0,0,1],[0,1,1,0],[0,1,1,1],[1,0,1,1]]

	public int findCircleNum(int[][] isConnected) {
		int numOfProv = 0;
//		Stack<Integer> conns = new Stack<Integer>();
		for (int i = 0; i < isConnected.length; i++) {
			for (int j = 0; j < isConnected[i].length; j++) {
				if (isConnected[i][j] == 1) {
					// i and j are connected
					numOfProv += findProvinces(isConnected, i, j);
				}
			}
		}

		return numOfProv;
	}

	public int findProvinces(int[][] isConnected, int i, int j) {
		int numOfProv = 1;
		Stack<Integer> dfsStack = new Stack<Integer>();
		dfsStack.add(i);

		while (!dfsStack.isEmpty()) {
			int row = dfsStack.pop();
			int[] connsOfI = isConnected[row];
			for (int k = 0; k < connsOfI.length; k++) {
				if (connsOfI[k] == 1) {
					connsOfI[k] = -1;
					if (k != row) {
						dfsStack.push(k);
					}
				}
			}
		}
		return numOfProv;
	}

}
