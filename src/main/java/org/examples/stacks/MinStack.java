package org.examples.stacks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinStack {

	/** initialize your data structure here. */
	List<Integer> elems = new ArrayList<>();
	int tailPos = -1;

	public MinStack() {

	}
	
	public static void main(String[] args) {
		MinStack obj = new MinStack();
//		["MinStack","push","push","push","getMin","top","pop","getMin"]
//				[[],[-2],[0],[-1],[],[],[],[]]
		obj.push(-2);
		obj.push(0);
		obj.push(-1);
		System.out.println(obj.getMin());
		System.out.println(obj.top());
		obj.pop();
		System.out.println(obj.getMin());
	}

	public void push(int x) {
		elems.add(x);
		tailPos++;
	}

	public void pop() {
		if (tailPos >= 0) {
			elems.remove(tailPos--);
		}
	}

	public int top() {
		if (tailPos >= 0) {
			return elems.get(tailPos);
		}
		return -1;
	}

	public int getMin() {
		if (tailPos >= 0) {
			Integer minVal = elems.get(0);
			for(int i=1; i<elems.size(); i++) {
				minVal = Math.min(minVal, elems.get(i));
			}
			return minVal;
		}
		return -1;
	}

}
