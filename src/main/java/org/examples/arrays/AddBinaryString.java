package org.examples.arrays;

public class AddBinaryString {

	public static void main(String[] args) {
		AddBinaryString solver = new AddBinaryString();
		System.out.println(solver.addBinary("11", "1"));
	}

	public String addBinary(String a, String b) {
	
		int index =0;
		
		int iFactor =1;
		boolean keepRunning = true;
		while(keepRunning) {
			int aIndex = a.length() - iFactor;
			if(aIndex >=0) {
				a.charAt(aIndex);
			} else {
				keepRunning = false;
			}
			
			int bIndex = b.length() - iFactor;
			if(bIndex  >=0) {
				b.charAt(bIndex );
			}
			
			iFactor++;
		}
	}

}
