package org.examples.arrays;

public class OneEditDistance {

	public static void main(String[] args) {
		OneEditDistance solver = new OneEditDistance();
		System.out.println(solver.isOneEditDistance("ab", "acb"));
		System.out.println(solver.isOneEditDistance("a", ""));
		System.out.println(solver.isOneEditDistance("", ""));
		System.out.println(solver.isOneEditDistance("", "A"));
		System.out.println(solver.isOneEditDistance("acbbcda", "abbdad"));
	}

	public boolean isOneEditDistance(String s, String t) {
//		if (s.equals("") && t.equals("")) {
//			return false;
//		}

		int p1 = 0;
		int p2 = 0;
		int numOfMisMatches = 0;
		while (p1 < s.length() || p2 < t.length()) {
			if (p1 < s.length() && p2 < t.length() && s.charAt(p1) == t.charAt(p2)) {
				p1++;
				p2++;
			} else {
				if (s.length() < t.length()) {
					// need to insert new char
					p2++;
				} else if (s.length() == t.length()) {
					p1++;
					p2++;
				} else {
					p1++;
				}
				numOfMisMatches++;
			}

			if (numOfMisMatches > 1) {
				break;
			}
		}

		if (numOfMisMatches == 0 || numOfMisMatches > 1) {
			return false;
		}

		return true;
	}

}
