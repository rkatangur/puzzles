package org.examples;

import java.io.IOException;

public class Tiger extends Animal {

	@Override
	public void eat() throws IOException {
		System.out.println("I am Tiger ");
		throw new IOException("Not able to start");
	}
	
	public static void main(String[] args) {
//		try {
//			Animal tiger = new Tiger();
////			tiger.eat();
//		}catch (IOException e) {
//			e.printStackTrace();
//		}
	}

}