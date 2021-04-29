package org.examples.arrays;

import java.util.Arrays;

/**
 * 1465. Maximum Area of a Piece of Cake After Horizontal and Vertical Cuts
 * 
 * Given a rectangular cake with height h and width w, and two arrays of
 * integers horizontalCuts and verticalCuts where horizontalCuts[i] is the
 * distance from the top of the rectangular cake to the ith horizontal cut and
 * similarly, verticalCuts[j] is the distance from the left of the rectangular
 * cake to the jth vertical cut.
 * 
 * Return the maximum area of a piece of cake after you cut at each horizontal
 * and vertical position provided in the arrays horizontalCuts and verticalCuts.
 * Since the answer can be a huge number, return this modulo 10^9 + 7.
 * 
 * 
 * @author rkata
 *
 */
public class MaxAreaOfAPieceOfCake {


	   public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
	        Arrays.sort(horizontalCuts);
	        Arrays.sort(verticalCuts);
	       
			int max_h = horizontalCuts[0];
			for (int i = 1; i < horizontalCuts.length; i++) {
				int cur_h = horizontalCuts[i] - horizontalCuts[i - 1];
				max_h = Math.max(cur_h, max_h);
			}
			max_h = Math.max(max_h, h - horizontalCuts[horizontalCuts.length - 1]);

			int max_v = verticalCuts[0];
			for (int i = 1; i < verticalCuts.length; i++) {
				int cur_v = verticalCuts[i] - verticalCuts[i - 1];
				max_v = Math.max(cur_v, max_v);
			}
			max_v = Math.max(max_v, w - verticalCuts[verticalCuts.length - 1]);
			
	        System.out.println("max_h "+max_h+", max_v "+max_v);
			
	        return (int)((long)max_h * max_v % 1000000007);
			// long maxArea = ((max_h * max_v) % 1000000007);
			// return (int) maxArea;
		}
	    
}
