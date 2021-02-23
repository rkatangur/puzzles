package org.examples.graph;

import java.util.HashMap;
import java.util.Map;

public class FindTownJudge {

	public static void main(String[] args) {
		FindTownJudge solver = new FindTownJudge();
		System.out.println(solver.findJudge(4, new int[][] { { 1, 3 }, { 1, 4 }, { 2, 3 }, { 2, 4 }, { 4, 3 } }));
	}

	public int findJudge(int N, int[][] trust) {
		if (N == 1) {
			return 1;
		}

		Map<Integer, Integer> personVotes = new HashMap<>();
		Map<Integer, Integer> judgeVotes = new HashMap<>();

		for (int i = 0; i < trust.length; i++) {
			int person = trust[i][0];
			personVotes.put(person, personVotes.getOrDefault(person, 0) + 1);

			int personTrust = trust[i][1];
			judgeVotes.put(personTrust, judgeVotes.getOrDefault(personTrust, 0) + 1);
		}

		int judge = -1;
		for (Map.Entry<Integer, Integer> judgeEntry : judgeVotes.entrySet()) {
			if (judgeEntry.getValue() == N - 1 && !personVotes.containsKey(judgeEntry.getKey())) {
				judge = judgeEntry.getKey();
			}
		}

		return judge;
	}

}
