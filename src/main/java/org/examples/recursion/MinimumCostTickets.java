package org.examples.recursion;

/**
 * Input: days = [1,4,6,7,8,20], costs = [2,7,15] Output: 11 Explanation: For
 * example, here is one way to buy passes that lets you travel your travel plan:
 * On day 1, you bought a 1-day pass for costs[0] = $2, which covered day 1. On
 * day 3, you bought a 7-day pass for costs[1] = $7, which covered days 3, 4,
 * ..., 9. On day 20, you bought a 1-day pass for costs[0] = $2, which covered
 * day 20. In total you spent $11 and covered all the days of your travel.
 * 
 * @author rkata
 *
 */
public class MinimumCostTickets {

	public static void main(String[] args) {
		MinimumCostTickets solver = new MinimumCostTickets();
		System.out.println(solver.mincostTickets(
				new int[] { 1, 4, 6, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 20, 21, 22, 23, 27, 28 },
				new int[] { 3, 13, 45 }));
		System.out.println(solver.mincostTickets(new int[] { 1, 4, 6, 7, 8, 20 }, new int[] { 2, 7, 15 }));
	}

	int[] duration = new int[] { 1, 7, 30 };

	public int mincostTickets(int[] days, int[] costs) {
		int[] dayToMinCost = new int[365 + 1];
		return mincostTicketsHelper(days, 0, -1, costs, dayToMinCost);
	}

	public int mincostTicketsHelper(int[] days, int dayIndex, int coveredDayNum, int[] costs, int[] dayToMinCost) {
		if (dayIndex >= days.length) {
			return 0;
		}

		int cureentDay = days[dayIndex];
		if (dayToMinCost[cureentDay] != 0) {
			return dayToMinCost[cureentDay];
		}

		int minCost = Integer.MAX_VALUE;
//		for (int i = costs.length - 1; i >= 0; i--) {
		for (int i = 0; i < costs.length; i++) {
			int cost = costs[i];
			int coverageDay = cureentDay + duration[i] - 1;
			int dayIndexForCost = dayIndex;
			while (dayIndexForCost < days.length && days[dayIndexForCost] <= coverageDay) {
				dayIndexForCost++;
			}
			minCost = Math.min(minCost,
					(cost + mincostTicketsHelper(days, dayIndexForCost, coverageDay, costs, dayToMinCost)));
		}

		dayToMinCost[cureentDay] = minCost;
		return minCost;
	}

//	public int mincostTicketsHelper(int[] days, int dayIndex, int coveredDayNum, int[] costs, int[] dayToMinCost) {
//		if (dayIndex >= days.length) {
//			return 0;
//		}
//
//		int cureentDay = days[dayIndex];
//		int minCost = Integer.MAX_VALUE;
//
//		if (coveredDayNum >= cureentDay) {
//			minCost = Math.min(minCost, (mincostTicketsHelper(days, dayIndex + 1, coveredDayNum, costs, dayToMinCost)));
//		} else {
//			for (int i = costs.length - 1; i >= 0; i--) {
//				int cost = costs[i];
//				if (i == 0) {
//					coveredDayNum = cureentDay;
//				} else if (i == 1) {
//					coveredDayNum = cureentDay + 7 - 1;
//				} else if (i == 2) {
//					coveredDayNum = cureentDay + 30 - 1;
//				}
//
////				System.out
////						.println("Buying ticket at " + cost + " day " + cureentDay + " coveredDayNum " + coveredDayNum);
//
//				minCost = Math.min(minCost,
//						(cost + mincostTicketsHelper(days, dayIndex + 1, coveredDayNum, costs, dayToMinCost)));
//			}
//
////			System.out.println("Recording a minCost " + minCost + " for day " + cureentDay);
//		}
//
//		return minCost;
//	}

}
