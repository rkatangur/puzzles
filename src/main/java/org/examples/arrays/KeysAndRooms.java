package org.examples.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 
 * There are N rooms and you start in room 0. Each room has a distinct number in
 * 0, 1, 2, ..., N-1, and each room may have some keys to access the next room.
 * 
 * Formally, each room i has a list of keys rooms[i], and each key rooms[i][j]
 * is an integer in [0, 1, ..., N-1] where N = rooms.length. A key rooms[i][j] =
 * v opens the room with number v.
 * 
 * Initially, all the rooms start locked (except for room 0).
 * 
 * You can walk back and forth between rooms freely.
 * 
 * Return true if and only if you can enter every room.
 * 
 * Example 1:
 * 
 * Input: [[1],[2],[3],[]] Output: true Explanation: We start in room 0, and
 * pick up key 1. We then go to room 1, and pick up key 2. We then go to room 2,
 * and pick up key 3. We then go to room 3. Since we were able to go to every
 * room, we return true. Example 2:
 * 
 * Input: [[1,3],[3,0,1],[2],[0]] Output: false Explanation: We can't enter the
 * room with number 2.
 * 
 * 
 * 
 * @author rkata
 *
 */
public class KeysAndRooms {

	public static void main(String[] args) {
		KeysAndRooms solver = new KeysAndRooms();
		List<List<Integer>> rooms = new ArrayList<List<Integer>>();
		rooms.add(Arrays.asList(1));
		rooms.add(Arrays.asList(2));
		rooms.add(Arrays.asList(3));
		rooms.add(Arrays.asList());
		solver.canVisitAllRooms(rooms);
	}

   	public boolean canVisitAllRooms(List<List<Integer>> rooms) {
		int[] roomStatuses = new int[rooms.size()];
		canVisitAllRoomsHelper(rooms, 0, roomStatuses);

		for (int roomStatus : roomStatuses) {
			if (roomStatus == 0) {
				return false;
			}
		}
		return true;
	}

	public void canVisitAllRoomsHelper(List<List<Integer>> rooms, int roomToVisit, int[] roomStatuses) {
		if (roomStatuses[roomToVisit] == 1) {
			return;
		}

		roomStatuses[roomToVisit] = 1;
		List<Integer> roomKeys = rooms.get(roomToVisit);
		if (roomKeys != null) {
			for (Integer roomKey : roomKeys) {
				if (roomStatuses[roomKey] == 0) {
					canVisitAllRoomsHelper(rooms, roomKey, roomStatuses);
				}
			}
		}
	}
}
