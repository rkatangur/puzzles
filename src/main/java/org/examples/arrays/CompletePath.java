package org.examples.arrays;

// Given an array
// Write a func to check if the array is complate path or not
// treat the array as circular
// relative indexs

// aval of 1 means move to next index
// aval of -1 means move back 1
// aval of 2 means move 2 steps

// Complete path of array means each element need

// {1,1,1,1} complete path
// 1-->1-->1-->1-->1 values
// 0-->1-->2-->3-->0 indexs


// {4,1,7} complete path
// 0->1->2->0 index
// 4->1->7->4

// {1, 1, -1} //imcomplete because it did not come back to zero
// 0->1->2->1
// 1->1->1
// 1->1->1
// 2

// exit condition is on returning to zeroth index check if any indexs are not traveresed if all
// are travesered then true else false.

// {2,5,2,9} not complete path
// 0->2->0 not visited index 1 and 3
// 2->2->2

// COMPLETED


public class CompletePath {

  public static void main(String[] args) {
    System.out.println(isCompletePath(new int[] {1, 1, 1, 1}));
    System.out.println(isCompletePath(new int[] {4, 1, 7}));
    System.out.println(isCompletePath(new int[] {1, 1, -1}));
    System.out.println(isCompletePath(new int[] {2, 5, 2, 9}));
  }

  public static boolean isCompletePath(int[] nums) {
    int[] visitedNodes = new int[nums.length];
    int indexPos = 0;

    int numOfNodesVisited = 0;

    // todo need to add looping condition
    while (true) {

      int posVal = nums[indexPos];
      if (posVal > 0) {
        // 4%3 =1
        indexPos += posVal % nums.length;
      } else if (posVal < 0) {
        // 1%3=1
        indexPos -= Math.abs(posVal) % nums.length;
      }

      indexPos = indexPos % nums.length;

      visitedNodes[indexPos] += 1;

      numOfNodesVisited++;

      if (numOfNodesVisited >= nums.length) {
        break;
      }

    }

    // Here check all visited nodes values have 1 or not.
    // if any visited node vlaue has 0 or >1 then there is a loop
    boolean isComplete = true;
    for (int i = 0; i < visitedNodes.length; i++) {
      if (visitedNodes[i] == 0 || visitedNodes[i] > 1) {
        isComplete = false;
        break;
      }
    }

    return isComplete;
  }

}
