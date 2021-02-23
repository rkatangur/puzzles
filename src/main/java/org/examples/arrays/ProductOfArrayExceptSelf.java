package org.examples.arrays;

public class ProductOfArrayExceptSelf {

	public static void main(String[] args) {
		ProductOfArrayExceptSelf solver = new ProductOfArrayExceptSelf();
		System.out.println(solver.productExceptSelf(new int[] { 1, 2, 3, 4 }));
	}

	public int[] productExceptSelf(int[] nums) {
		int totalProduct = nums[0];
		for (int i = 1; i < nums.length; i++) {
			totalProduct *= nums[i];
		}

		int[] nums1 = new int[nums.length];
		for (int i = 0; i < nums1.length; i++) {
			nums1[i] = (totalProduct / nums[i]);
		}

		return nums1;
	}

	public int[] productExceptSelfV2(int[] nums) {

		int[] leftProducts = new int[nums.length];
		leftProducts[0] = 1;
		for (int i = 1; i < nums.length; i++) {
			leftProducts[i] = leftProducts[i - 1] * nums[i - 1];
		}

		int[] nums1 = new int[nums.length];
		nums1[nums.length - 1] = 1 * leftProducts[nums.length - 1];
		int initRightProd = 1;
		for (int i = nums.length - 2; i >= 0; i--) {
			initRightProd = initRightProd * nums[i + 1];
			nums1[i] = initRightProd * leftProducts[i];
		}
		
		return nums1;
	}
}
