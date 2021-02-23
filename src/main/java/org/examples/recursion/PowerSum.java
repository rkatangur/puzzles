package org.examples.recursion;

public class PowerSum {

  public static void main(String[] args) {
    int totalSum = 100;
    int currentSum = 0;
    int solutions = 0;
    System.out.println(calculateNumOfSums(currentSum, totalSum, 1, 2));
  }


  public static int calculateNumOfSums(int currentSum, int totalSum, int currentNum, int power) {

    if (currentSum == totalSum) {
      return 1;
    }
    
    int solutions = 0;
    for (int i = currentNum; currentSum + (int)Math.pow(i, power) <= totalSum; i++) {
      solutions += calculateNumOfSums(currentSum + (int)Math.pow(i, power), totalSum, i + 1, power);
    }
    
    return solutions;
  }

}
