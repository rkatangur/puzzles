package org.examples.arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import org.examples.collections.Stack;

/**
 * 
 * Given a list accounts, each element accounts[i] is a list of strings, where
 * the first element accounts[i][0] is a name, and the rest of the elements are
 * emails representing emails of the account.
 * 
 * Now, we would like to merge these accounts. Two accounts definitely belong to
 * the same person if there is some email that is common to both accounts. Note
 * that even if two accounts have the same name, they may belong to different
 * people as people could have the same name. A person can have any number of
 * accounts initially, but all of their accounts definitely have the same name.
 * 
 * After merging the accounts, return the accounts in the following format: the
 * first element of each account is the name, and the rest of the elements are
 * emails in sorted order. The accounts themselves can be returned in any order.
 * 
 * Example 1:
 * 
 * Input: accounts = [["John", "johnsmith@mail.com", "john00@mail.com"],
 * ["John", "johnnybravo@mail.com"], ["John", "johnsmith@mail.com",
 * "john_newyork@mail.com"], ["Mary", "mary@mail.com"]] Output: [["John",
 * 'john00@mail.com', 'john_newyork@mail.com', 'johnsmith@mail.com'], ["John",
 * "johnnybravo@mail.com"], ["Mary", "mary@mail.com"]]
 * 
 * Explanation: The first and third John's are the same person as they have the
 * common email "johnsmith@mail.com". The second John and Mary are different
 * people as none of their email addresses are used by other accounts. We could
 * return these lists in any order, for example the answer [['Mary',
 * 'mary@mail.com'], ['John', 'johnnybravo@mail.com'], ['John',
 * 'john00@mail.com', 'john_newyork@mail.com', 'johnsmith@mail.com']] would
 * still be accepted.
 * 
 * 
 * @author rkata
 *
 */
public class AccountsMerge {

//	[["John","johnsmith@mail.com","john_newyork@mail.com","john00@mail.com"],["Mary","mary@mail.com"],["John","johnnybravo@mail.com"]]	
//    [["John","john00@mail.com","john_newyork@mail.com","johnsmith@mail.com"],["Mary","mary@mail.com"],["John","johnnybravo@mail.com"]]
//			

	public List<List<String>> accountsMerge(List<List<String>> accounts) {
		Map<String, String> emailToName = new HashMap<>();
		Map<String, TreeSet<String>> graph = new HashMap<>();

		for (List<String> account : accounts) {
			String name = account.get(0);
			for (int i = 1; i < account.size(); i++) {
				String firstEmail = account.get(1);
				String curEmail = account.get(i);
				graph.computeIfAbsent(firstEmail, s -> new TreeSet<String>()).add(curEmail);
				graph.computeIfAbsent(curEmail, s -> new TreeSet<String>()).add(firstEmail);
				emailToName.putIfAbsent(curEmail, name);
			}
		}

		Set<String> visitedNodes = new HashSet<String>();
		Stack<String> dfsStack = new Stack<>();
		List<TreeSet<String>> uniqSets = new ArrayList<TreeSet<String>>();

		for (Map.Entry<String, TreeSet<String>> graphEntry : graph.entrySet()) {
			if (!visitedNodes.contains(graphEntry.getKey())) {
				visitedNodes.add(graphEntry.getKey());
				dfsStack.push(graphEntry.getKey());
				Set<String> uniqEmailSet = new TreeSet<String>();

				while (!dfsStack.isEmpty()) {
					String email = dfsStack.pop();
					uniqEmailSet.add(email);
					TreeSet<String> neighbors = graph.get(email);
					for (String neightborEmail : neighbors) {
						if (!visitedNodes.contains(neightborEmail)) {
							dfsStack.push(neightborEmail);
						}
					}
				}
			}
		}
		
		List<List<String>> results = new ArrayList<List<String>>();

		for (TreeSet<String> emailSet : uniqSets) {
			List<String> acctList = new ArrayList<String>();
			String email = emailSet.iterator().next();
			String name = emailToName.get(email);
			acctList.add(name);
			acctList.addAll(emailSet);
			results.add(acctList);
		}
		
		return results;
	}

}
