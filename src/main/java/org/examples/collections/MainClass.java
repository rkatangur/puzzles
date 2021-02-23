package org.examples.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class MainClass {

	public static void main(String[] atg) {

//		demoOfList();
//
//		demoOfSet();
//		demoOfTreeSet();

//		demoOfLinkedHashSet();
		demoOfMaps();
	}

	private static void demoOfLinkedHashSet() {

	}

	/**
	 * 2
	 * 
	 * 1 3
	 *
	 * 
	 * @param coll
	 */
	private static void demoOfTreeSet() {
		System.out.println("Demo of TreeSet");

		Set<String> setOfStrs = new TreeSet<String>(new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return o1.compareTo(o2) * -1;
			}
		});

		setOfStrs.add("Raja");
		setOfStrs.add("Suchi");
		setOfStrs.add("Hello");
		setOfStrs.add("ABC");

		setOfStrs.add("Raja");
		setOfStrs.add("Hello");

		System.out.println("Raja".compareTo("ABC"));
		System.out.println("Hello".compareTo("ABC"));

		logCollection(setOfStrs);
	}

	private static void demoOfSet() {
		System.out.println("Demo of HashSet");

		Set<String> setOfStrs = new HashSet<String>();
		setOfStrs.add("Raja");
		setOfStrs.add("Suchi");
		setOfStrs.add("Hello");

		setOfStrs.add("Raja");
		setOfStrs.add("Hello");

		logCollection(setOfStrs);
	}

	private static void demoOfList() {
		System.out.println("Demo of List");

		List<String> listOfStrs = new ArrayList<String>();
		listOfStrs.add("Raja");
		listOfStrs.add("Suchi");
		listOfStrs.add("Hello");

		listOfStrs.add("Raja");
		listOfStrs.add("Hello");

		logCollection(listOfStrs);

		listOfStrs.get(0);
	}

	private static void demoOfMaps() {
		System.out.println("Demo of List");

		Map<Integer, String> mapOfStrs = new HashMap<Integer, String>();
		mapOfStrs.put(1234, "Raja");
		mapOfStrs.put(1334, "Suchi");
		mapOfStrs.put(1344, "Hello");
		mapOfStrs.put(1444, "Hello");
		
		mapOfStrs.put(1234, "Raja K");
		
		logCollection(mapOfStrs);
		
		System.out.println(mapOfStrs.get(1234));
	}

	private static void logCollection(Map<Integer, String> mapOfStrs) {
		for (Map.Entry<Integer, String> entry : mapOfStrs.entrySet()) {
			System.out.println(entry .getKey()+"-->"+entry.getValue());
		}
		
	}

	public static void logCollection(Collection<?> coll) {
		for (Object obj : coll) {
			System.out.println(obj);
		}
	}
}
