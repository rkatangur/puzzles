package org.examples.collections;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.examples.util.FileUtil;

public class MedianMaintanence {
	private MyHeap hLowMaxHeap;
	private MyHeap hHighMinHeap;

	public static void main(String[] args) {
		MedianMaintanence solver = new MedianMaintanence();
		solver.hLowMaxHeap = new MyHeap(5001, false);
		solver.hHighMinHeap = new MyHeap(5001, true);
		List<Integer> nums = loadNumsFromFile();
		long medianTotal = 0;
		for (Integer num : nums) {
			solver.insert(num);
			int median = solver.median();
			medianTotal += median;
		}

		System.out.println(medianTotal);

		System.out.println(medianTotal % 10000);
	}

	private int median() {
		int totalSize = hLowMaxHeap.size();
		totalSize += hHighMinHeap.size();
		int medianIndex = totalSize / 2;
		medianIndex += totalSize % 2;

		if (medianIndex > hLowMaxHeap.size()) {
			return hHighMinHeap.peek();
		} else {
			return hLowMaxHeap.peek();
		}
	}

	private void insert(int elem) {
		if (hLowMaxHeap.size() == 0) {
			hLowMaxHeap.insert(elem);
		} else {
			if (elem < hLowMaxHeap.peek()) {
				hLowMaxHeap.insert(elem);
			} else {
				hHighMinHeap.insert(elem);
			}
		}

		int diff = Math.abs(hLowMaxHeap.size() - hHighMinHeap.size()) / 2;

		MyHeap heapWithMoreElems = null;
		MyHeap heapWithLessElems = null;

		if (hLowMaxHeap.size() > hHighMinHeap.size()) {
			heapWithMoreElems = hLowMaxHeap;
			heapWithLessElems = hHighMinHeap;
		} else {
			heapWithMoreElems = hHighMinHeap;
			heapWithLessElems = hLowMaxHeap;
		}

		while (diff > 0) {
			int elemFromHeapWithMoreElems = heapWithMoreElems.peek();
			heapWithMoreElems.remove();
			heapWithLessElems.insert(elemFromHeapWithMoreElems);
			diff--;
		}
	}

	private static List<Integer> loadNumsFromFile() {
		List<Integer> numList = new ArrayList<Integer>();

		String quickSortFile = "Median.txt";
		InputStream quickSortIS = null;
		BufferedReader br = null;
		try {
			quickSortIS = FileUtil.findFile(quickSortFile);
			br = new BufferedReader(new InputStreamReader(quickSortIS));
			String line;
			try {
				line = br.readLine();
				while (line != null) {
					numList.add(Integer.parseInt(line));
					line = br.readLine();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (quickSortIS != null) {
					quickSortIS.close();
				}
				if (br != null) {
					br.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return numList;
	}

}
