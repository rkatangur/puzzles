package org.examples;

import java.math.BigInteger;
import java.util.Scanner;

// You are given an integer . Print the factorial of this number.
//
// Input
// Input consists of a single integer , where .
//
// Output
// Print the factorial of .
//
// Example
// For an input of 25, you would print .
//
// We recommend solving this challenge using BigIntegers.

public class ExtraLongFactorials {

  //factorial of N is = N*(N-1).......3*2*1;
  
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    System.out.println(factorialUsingRecursion(n).toString());
  }
  
  static BigInteger factorialUsingRecursion(int factorialNum) {
    if(factorialNum == 1){
      return BigInteger.ONE;
    } else {
      return BigInteger.valueOf(factorialNum).multiply(factorialUsingRecursion(factorialNum -1)); 
    }
  }
}
