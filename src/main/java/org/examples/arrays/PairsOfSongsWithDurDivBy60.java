package org.examples.arrays;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * 1010. Pairs of Songs With Total Durations Divisible by 60
 * 
 * You are given a list of songs where the ith song has a duration of time[i]
 * seconds.
 * 
 * Return the number of pairs of songs for which their total duration in seconds
 * is divisible by 60. Formally, we want the number of indices i, j such that i
 * < j with (time[i] + time[j]) % 60 == 0.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: time = [30,20,150,100,40] Output: 3 Explanation: Three pairs have a
 * total duration divisible by 60: (time[0] = 30, time[2] = 150): total duration
 * 180 (time[1] = 20, time[3] = 100): total duration 120 (time[1] = 20, time[4]
 * = 40): total duration 60 Example 2:
 * 
 * Input: time = [60,60,60] Output: 3 Explanation: All three pairs have a total
 * duration of 120, which is divisible by 60.
 * 
 * 
 * @author rkata
 *
 */
public class PairsOfSongsWithDurDivBy60 {

	public int numPairsDivisibleBy60(int[] time) {
		Map<Integer, Integer> modsCount = new HashMap<>();
		int numOfPairs = 0;
		for (int i = 0; i < time.length; i++) {
			int curMod = time[i] % 60;
			int leftOver = (curMod == 0) ? curMod : (60 - curMod);
			if (modsCount.containsKey(leftOver)) {
				numOfPairs += modsCount.get(leftOver);
			}
			modsCount.put(curMod, modsCount.getOrDefault(curMod, 0) + 1);
		}

		return numOfPairs;
	}

}
