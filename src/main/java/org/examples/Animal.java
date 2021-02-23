package org.examples;

import java.io.IOException;

public class Animal {

	public void eat() throws Exception {
		System.out.println("I am Animal ");
		throw new IOException("Not able to open file");
	}

}
