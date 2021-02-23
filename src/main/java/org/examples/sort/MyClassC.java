package org.examples.sort;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.TreeSet;

public class MyClassC {

	int data;

	MyClassC() {
		this(10);
	}

	MyClassC(int data) {
		this.data = data;
	}

	void display() {
		System.out.println("data= " + data);
	}

	class Decrementer {
		public void decrement(double data) {
			data = data - 1.0;
		}
	}

	public static void main(String[] args) {
		String a[] = new String[] { "A", "D", "B" };
		List<String> l = Arrays.asList(a);
		Collection<String> c = (Collection<String>) getCollection(l);

		for (String s : c) {
			System.out.println(s);
		}

		int data = 0;
		MyClassC myclassC = new MyClassC(data);
		MyClassC.Decrementer d = myclassC.new Decrementer();
		d.decrement(data);
		myclassC.display();
	}

	static public <E extends CharSequence> Collection<? extends CharSequence> getCollection(Collection<E> c) {
		Collection<E> t = new TreeSet<E>();
		for (E e : c)
			t.add(e);
		return t;
	}
}
