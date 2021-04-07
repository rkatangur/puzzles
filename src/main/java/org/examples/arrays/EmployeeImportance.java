package org.examples.arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * 
 * 690. Employee Importance
 * 
 * You are given a data structure of employee information, which includes the
 * employee's unique id, their importance value and their direct subordinates'
 * id.
 * 
 * For example, employee 1 is the leader of employee 2, and employee 2 is the
 * leader of employee 3. They have importance value 15, 10 and 5, respectively.
 * Then employee 1 has a data structure like [1, 15, [2]], and employee 2 has
 * [2, 10, [3]], and employee 3 has [3, 5, []]. Note that although employee 3 is
 * also a subordinate of employee 1, the relationship is not direct.
 * 
 * Now given the employee information of a company, and an employee id, you need
 * to return the total importance value of this employee and all their
 * subordinates.
 * 
 * Example 1:
 * 
 * 
 * Input: [[1, 5, [2, 3]], [2, 3, []], [3, 3, []]], 1 Output: 11
 * 
 * Explanation: Employee 1 has importance value 5, and he has two direct
 * subordinates: employee 2 and employee 3. They both have importance value 3.
 * So the total importance value of employee 1 is 5 + 3 + 3 = 11.
 * 
 * @author rkata
 *
 */
public class EmployeeImportance {

	public int getImportance(List<Employee> employees, int id) {
		Map<Integer, Employee> empMap = new HashMap<>();
		Employee matchedEmp = null;
		for (Employee emp : employees) {
			if (emp.id == id) {
				matchedEmp = emp;
			}
			empMap.put(emp.id, emp);
		}

		int totalImportance = 0;

		if (matchedEmp != null) {
			LinkedList<Employee> bfsQ = new LinkedList<Employee>();
			bfsQ.add(matchedEmp);

			while (!bfsQ.isEmpty()) {
				Employee emp = bfsQ.poll();
				totalImportance += emp.importance;

				for (int subOrd : emp.subordinates) {
					bfsQ.add(empMap.get(subOrd));
				}
			}
		}

		return totalImportance;
	}

	public static void main(String[] args) {
		EmployeeImportance solver = new EmployeeImportance();
//		[
//		 [1, 5, [2, 3]], 
//		 [2, 3, []], 
//		 [3, 3, []]
//		]
//		, 1
		Employee emp1 = solver.new Employee(1, 5, Arrays.asList(2, 3));
		Employee emp2 = solver.new Employee(2, 3, Arrays.asList());
		Employee emp3 = solver.new Employee(3, 3, Arrays.asList());

		System.out.println(solver.getImportance(Arrays.asList(emp1, emp2, emp3), 1));
	}

	// Definition for Employee.
	class Employee {

		public Employee(int id, int importance, List<Integer> subordinates) {
			super();
			this.id = id;
			this.importance = importance;
			this.subordinates = subordinates;
		}

		public int id;
		public int importance;
		public List<Integer> subordinates;
	}
}
