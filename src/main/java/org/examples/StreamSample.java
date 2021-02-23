package org.examples;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamSample {

	public static void main(String[] args) {
//		getMaxValue();
//		List<Integer> intList = Arrays.asList(-1, -4, -6, -8);
//		Integer maxOfInt = intList.stream().reduce(0, (i, j) -> Integer.max(i, j));
//		System.out.println(maxOfInt);
//		filterAndPrint();

		convertStringArrToUpperCase();
//		streamBuilder();

//		try {
//			verify();
//		}catch (Exception e) {
//		}
//		catch (RuntimeException re) {
//		}
	}

	private static void getMaxValue() {
		List<Integer> integers = Arrays.asList(-2, 2, 4, 6);
		Integer integer = integers.stream().max(Math::max).orElse(0);
		System.out.println(integer);
	}

	public static void filterAndPrint() {
		List<Integer> integers = Arrays.asList(1, 5, 6, 7, 8);
		Stream pplStream = integers.stream().filter(i -> i > 6);
		pplStream.peek(System.out::println);
	}

	public static void streamBuilder() {
		Stream.Builder<String> builder = Stream.builder();
		builder.add("One").add("two").add("two");
		Stream<String> builderStream = builder.build();
		builder.add("One");
		Stream<String> builderStreamOne = builder.build();
		builderStreamOne.forEach(System.out::println);
	}

	public static void verify() throws IOException, RuntimeException {
		System.out.println("In verify()");
		throw new RuntimeException("Not able to Start");
	}

	public static void convertStringArrToUpperCase() {
		String[] myArray = new String[] {"john"};
		Stream<String> myStream = Arrays.stream(myArray);
		Stream<String> myNewStream = myStream.map(s->s.toUpperCase());
		String[] newList = myNewStream.toArray(String[]::new);
	}
	
	public static void testWhile() {
		int x = 1;
		int y = 6;
//		while(y--) {
//			x++;
//		}
		System.out.println();
	}

}
