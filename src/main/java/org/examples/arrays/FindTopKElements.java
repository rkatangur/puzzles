package org.examples.arrays;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class FindTopKElements {

	// This is just a simple shared plaintext pad, with no execution
	// capabilities.

	// When you know what language you'd like to use for your interview,
	// simply choose it from the dropdown in the top bar.

	// You can also change the default language your pads are created with
	// in your account settings: https://coderpad.io/settings

	// Enjoy your interview!

	// weblog:

	// mike
	// alex
	// justin
	// alex
	// luke
	// alex
	// bryan
	// bryan
	// bryan
	// luke
	// ==================
	// ...

	// top 3

	// 3, alex
	// 3, bryan
	// 2, luke

	// give me top k most frequent customers

	// mike, 1
	// alex, 1
	// justin 1

	// lookup map
	// alex 2

	// HashMap, put is just a lookuip and increment the count of the user

	// HshMap has 1000 find 10
	// heap to stoe the 10 elements with the lowest being the root

	// loop throguh the hashmap entries and check the element from heap
	// put the entry from hashmap ino the heap.

	String[] findTopKElements(String[] allUsers, int k) {

		Map<String, Integer> usersWithCount = new HashMap<>();

		for (String user : allUsers) {
			Integer existingUserCount = usersWithCount.get(user);
			if (existingUserCount == null) {
				existingUserCount = 1;
			} else {
				existingUserCount += 1;
			}
			usersWithCount.put(user, existingUserCount);
		}

		PriorityQueue<UserEntry> topKelemts = new PriorityQueue<UserEntry>(new Comparator<UserEntry>() {

			@Override
			public int compare(UserEntry o1, UserEntry o2) {
				if (o1.count < o2.count) {
					return -1;
				} else if (o1.count > o2.count) {
					return 1;
				} else {
					return 0;
				}
			}
		});

		for (Map.Entry<String, Integer> usersEntry : usersWithCount.entrySet()) {

			String username = usersEntry.getKey();
			int count = usersEntry.getValue();

			UserEntry userEntryToAdd = new UserEntry(username, count);

			UserEntry lowestElement = topKelemts.peek();
			if (lowestElement == null || topKelemts.size() < k) {
				topKelemts.add(userEntryToAdd);
			} else {
				if (lowestElement.count < userEntryToAdd.count) {
					topKelemts.poll();
					topKelemts.add(userEntryToAdd);
				}
			}
		}

		String[] topUsers = new String[k];
		for (int i = k - 1; i >= 0; i--) {
			topUsers[i - 1] = topKelemts.poll().name;
		}
		return topUsers;
	}

	private static class UserEntry {
		public String name;
		public int count;

		public UserEntry(String username, int count2) {
			this.name = username;
			this.count = count2;
		}
	}
}
