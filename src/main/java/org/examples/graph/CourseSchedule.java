package org.examples.graph;

import java.util.LinkedList;

public class CourseSchedule {

	public static void main(String[] args) {
		CourseSchedule solver = new CourseSchedule();
		System.out.println(solver.canFinish(2, new int[][] { { 1, 0 } }));
		System.out.println(solver.canFinish(3, new int[][] { { 1, 0 }, { 2, 0 } }));

		System.out.println(solver.canFinish(3, new int[][] { { 0, 1 }, { 0, 2 }, { 1, 2 } }));

		System.out.println(solver.canFinish(2, new int[][] { { 1, 0 }, { 0, 1 } }));

		System.out.println(solver.canFinish(7,
				new int[][] { { 1, 0 }, { 0, 3 }, { 0, 2 }, { 3, 2 }, { 2, 5 }, { 4, 5 }, { 5, 6 }, { 2, 4 } }));

	}

	/**
	 * 
	 * Input: numCourses = 2, prerequisites = [[1,0]] Output: true Explanation:
	 * There are a total of 2 courses to take. To take course 1 you should have
	 * finished course 0. So it is possible.
	 * 
	 * @param numCourses
	 * @param prerequisites
	 * @return
	 */
	public boolean canFinish(int numCourses, int[][] preReqs) {
		Graph1 coursesGraph = new Graph1(numCourses);

		for (int i = 0; i < preReqs.length; i++) {
			int courseId = preReqs[i][0];
			int preReqCourseId = preReqs[i][1];
			coursesGraph.addEdge(courseId, preReqCourseId);
		}

		for (int i = 0; i < preReqs.length; i++) {
			int[] coursePath = new int[numCourses];
			int courseId = preReqs[i][0];

			boolean result = canFinish(courseId, coursesGraph, coursePath);
			if (!result) {
				System.out.println("Cannot finish course " + i + ", result " + result);
				return false;
			}
		}

		return true;
	}

	public boolean canFinish(int course, Graph1 coursesGraph, int[] coursePath) {
		if (coursePath[course] == 1) {
			return false;
		}

		coursePath[course] = 1;
		boolean ret = true;
		LinkedList<Integer> prereqsOfCourse = coursesGraph.getEdges(course);
		for (int preReq : prereqsOfCourse) {
			if (coursePath[preReq] == 0) {
				boolean result = canFinish(preReq, coursesGraph, coursePath);
				if (!result) {
					ret = false;
					break;
				}
			} else {
				ret = false;
				break;
			}
		}

		coursePath[course] = 0;
		return ret;
	}

}
