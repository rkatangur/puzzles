package org.examples.arrays;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 937. Reorder Data in Log Files
 * 
 * You are given an array of logs. Each log is a space-delimited string of
 * words, where the first word is the identifier.
 * 
 * There are two types of logs:
 * 
 * Letter-logs: All words (except the identifier) consist of lowercase English
 * letters. Digit-logs: All words (except the identifier) consist of digits.
 * Reorder these logs so that:
 * 
 * The letter-logs come before all digit-logs. The letter-logs are sorted
 * lexicographically by their contents. If their contents are the same, then
 * sort them lexicographically by their identifiers. The digit-logs maintain
 * their relative ordering. Return the final order of the logs.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: logs = ["dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit
 * dig","let3 art zero"] Output: ["let1 art can","let3 art zero","let2 own kit
 * dig","dig1 8 1 5 1","dig2 3 6"] Explanation: The letter-log contents are all
 * different, so their ordering is "art can", "art zero", "own kit dig". The
 * digit-logs have a relative order of "dig1 8 1 5 1", "dig2 3 6". Example 2:
 * 
 * Input: logs = ["a1 9 2 3 1","g1 act car","zo4 4 7","ab1 off key dog","a8 act
 * zoo"] Output: ["g1 act car","a8 act zoo","ab1 off key dog","a1 9 2 3 1","zo4
 * 4 7"]
 * 
 * 
 * Constraints:
 * 
 * 1 <= logs.length <= 100 3 <= logs[i].length <= 100 All the tokens of logs[i]
 * are separated by a single space. logs[i] is guaranteed to have an identifier
 * and at least one word after the identifier.
 * 
 * 
 * 
 * 
 * @author rkata
 *
 */
public class ReorderDataInLogFiles {

	public String[] reorderLogFiles(String[] logs) {

		Comparator<String> strComparator = new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				String[] o1Str = o1.split(" ", 2);
				String[] o2Str = o2.split(" ", 2);

				String o1Identifier = o1Str[0];
				String o2Identifier = o2Str[0];

				String o1Content = o1Str[1];
				String o2Content = o2Str[1];

				boolean isO1ContentDigit = Character.isDigit(o1Content.charAt(0));
				boolean isO2ContentDigit = Character.isDigit(o2Content.charAt(0));

				if (!isO1ContentDigit && !isO2ContentDigit) {
					int contentOrder = o1Content.compareTo(o2Content);
					if (contentOrder != 0) {
                        return contentOrder;
					}
                    
                    return o1Identifier.compareTo(o2Identifier);					
				} else {
					if (!isO1ContentDigit && isO2ContentDigit) {
						return -1;
					} else if (isO1ContentDigit && !isO2ContentDigit) {
						return 1;
					} else {
						return 0;
					}
				}
			}
		};

		Arrays.sort(logs, strComparator);

		return logs;
	}

}
