package org.examples.arrays;

public class MergeSort {
	
	public static void main(String[] args) {
//		int[] arr = new int[] { 1, 3, 5, 2, 4, 6 };
//		int[] mergedArr = new int[arr.length];
//		
//		sort(arr, mergedArr, 0, arr.length - 1);
//		ArraysUtil.printIntArr(mergedArr);
//		
		
		int[] arr2 = new int[] { 1, 7, 5, 2, 4, 6, 3 };
		int[] mergedArr2 = new int[arr2.length];
		
		sort(arr2, mergedArr2, 0, arr2.length - 1);
		ArraysUtil.printIntArr(mergedArr2);
		
	}

	public static void sort(int[] arr, int[] mergedArr, int startIndex, int endIndex) {
		
		if (startIndex == endIndex) {
			return;
		}

		int mid = (startIndex + endIndex) / 2;
		sort(arr, mergedArr, startIndex, mid);
		sort(arr, mergedArr, mid + 1, endIndex);

		// merge two sub arrays
		mergeTwoSubArrays(arr, mergedArr, startIndex, endIndex, mid);
	}

	private static void mergeTwoSubArrays(int[] arr, int[] mergedArr, int startIndex, int endIndex, int mid) {
		int j= startIndex;
		int k= mid+1;
		int i =j;
		while(j<=mid &&k<=endIndex) {
			if(arr[j]<arr[k]) {
				mergedArr[i]=arr[j];
				j++;
			}
			else {
				mergedArr[i]=arr[k];
				k++;
			}
			i++;
		}
		
		while(j<=mid) {
			mergedArr[i]=arr[j];
			j++;
			i++;
		}
		
		while(k<=endIndex) {
			mergedArr[i]=arr[k];
			k++;
			i++;
		}
		
		//put the data back onto the original array.
		for(int x = startIndex; x<=endIndex ; x++) {
			arr[x] = mergedArr[x];
		}
 	}

}
