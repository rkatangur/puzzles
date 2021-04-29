package org.examples.collections;

public class UnionFindDisjointSet {

	private int[] parent;
	private int[] rank;
	private int numOfSets;

	public UnionFindDisjointSet(int[] arr) {
		parent = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			parent[i] = i;
		}

		rank = new int[arr.length];
		numOfSets = arr.length;
	}

	public int find(int elem) {
		if (parent[elem] == elem) {
			return elem;
		} else {
			int res = find(parent[elem]);
			if (parent[elem] != res) {
				parent[elem] = res;
			}
			return res;
		}
	}

	public boolean union(int x, int y) {
		int px = find(x);
		int py = find(y);
		if (px == py) {
			return false;
		} else {
			int rx = rank[px];
			int ry = rank[py];
			if (rx >= ry) {
				parent[py] = px;
				if (rx == ry) {
					rank[px]++;
				}
			} else {
				parent[px] = py;
			}

			numOfSets--;
			return true;
		}
	}

	public int getNumOfSets() {
		return numOfSets;
	}

}
