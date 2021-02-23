package org.examples;

public class FloorSqrt {

  public static void main(String[] args) {
    System.out.println(floorSqrt(9));
  }

  public static int floorSqrt(int x) {
    int start = 0, end = x;
    int mid = (start + end) / 2;
    int ans = 0;
    while (start < end) {
      mid = (start + end) / 2;
      if (mid * mid == x) {
        return mid;
      }

      if (x < mid * mid) {
        end = mid - 1;
      } else {
        start = mid + 1;
        ans = mid;
      }
    }
    return ans;
  }
}
