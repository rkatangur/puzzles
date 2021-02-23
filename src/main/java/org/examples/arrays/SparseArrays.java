package org.examples.arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class SparseArrays {

  private static Map<String, Integer> cacheOfStrs = new HashMap<String, Integer>();

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    for (int i = 0; i < n; i++) {
      String str = in.next();
      Integer numOfOccurences = cacheOfStrs.get(str);
      if (numOfOccurences == null) {
        numOfOccurences = 1;
      } else {
        numOfOccurences += 1;
      }
      cacheOfStrs.put(str, numOfOccurences);
    }

    List<String> queries = new ArrayList<>();
    int q = in.nextInt();
    for (int i = 0; i < q; i++) {
      String str = in.next();
      queries.add(str);
    }

    for (String query : queries) {
      Integer numOfOccurences = cacheOfStrs.get(query);
      if (numOfOccurences == null) {
        System.out.println(0);
      } else {
        System.out.println(numOfOccurences);
      }
    }

    in.close();
  }
}
