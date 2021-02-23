package org.examples.arrays.traversal;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class OpenLock {

	public static void main(String[] args) {
		OpenLock lock = new OpenLock();
//		System.out.println(lock.getNextChar('0'));
//		System.out.println(lock.getPrevChar('0'));
		String[] deadends = new String[] { "0201", "0101", "0102", "1212", "2002" };
		System.out.println(lock.openLock(deadends, "0202"));
	}

	/**
	 * Input: deadends = ["0201","0101","0102","1212","2002"], target = "0202"
	 * Output: 6 Explanation: A sequence of valid moves would be "0000" -> "1000" ->
	 * "1100" -> "1200" -> "1201" -> "1202" -> "0202". Note that a sequence like
	 * "0000" -> "0001" -> "0002" -> "0102" -> "0202" would be invalid, because the
	 * wheels of the lock become stuck after the display becomes the dead end
	 * "0102".
	 * 
	 * @param deadends
	 * @param target
	 * @return
	 */
	public int openLock(String[] deadends, String target) {
		char[] start = new char[] { '0', '0', '0', '0' };
		Set<String> deadendsSet = new HashSet<>(Arrays.asList(deadends));
		Set<String> visitedSet = new HashSet<>();

		LinkedList<String> queue = new LinkedList<String>();
		queue.add(new String(start));
		int curNumOfTurns = 0;
		boolean reachedTarget = false;
		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				String comboToProcess = queue.poll();

				if (comboToProcess != null) {
					if (deadendsSet.contains(comboToProcess)) {
						return -1;
					}

					if (target.equals(comboToProcess)) {
						reachedTarget = true;
						return curNumOfTurns;
					}
				}

				for (int j = 0; j < 4; j++) {
					char[] comboCharArr = comboToProcess.toCharArray();

					char[] cloneOfCombo = comboCharArr.clone();
					char nextChar = getNextChar(cloneOfCombo[j]);
					cloneOfCombo[j] = nextChar;
					String newComboStr = new String(cloneOfCombo);
					if (!deadendsSet.contains(newComboStr) && !visitedSet.contains(newComboStr)) {
						visitedSet.add(newComboStr);
						queue.offer(newComboStr);
					}

					char[] cloneOfCombo1 = comboCharArr.clone();
					char prevChar = getPrevChar(cloneOfCombo1[j]);
					cloneOfCombo1[j] = prevChar;
					String cloneCombo1Str = new String(cloneOfCombo1);
					if (!deadendsSet.contains(cloneCombo1Str) && !visitedSet.contains(cloneCombo1Str)) {
						visitedSet.add(cloneCombo1Str);
						queue.offer(cloneCombo1Str);
					}
				}
			}
			curNumOfTurns++;
		}

		return reachedTarget ? curNumOfTurns : -1;
	}

//	move from 0 ->1...........9->0
	private char getNextChar(char ch) {
		int charValAsInt = ch;
		if (charValAsInt >= 57) {
			charValAsInt = 48;
		} else {
			charValAsInt++;
		}

		char charToReturn = (char) charValAsInt;
		return charToReturn;
	}

	private char getPrevChar(char ch) {
		int charValAsInt = ch;
		if (charValAsInt <= 48) {
			charValAsInt = 57;
		} else {
			charValAsInt--;
		}

		char charToReturn = (char) charValAsInt;
		return charToReturn;
	}
}
