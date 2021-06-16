package problems.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

import main.utilities.SortingAlgos;

public class KthLargestElementInArray {

	public static void test() {
		int[] a = new int[] { 3, 2, 1, 5, 6, 4 };
		int k = 2;
		int largest = getKthLargestV3(a, k);
		System.out.println(largest);
	}

	// n*log(k)
	public static int getKthLargestV3(int[] a, int k) {
		ArrayList<Integer> list = new ArrayList<>();
		for (int i = 0; i < a.length; i++) {
			list.add(a[i]);
		}
		PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(list.subList(0, k));
		System.out.println(priorityQueue.toString());
		for (int i = k; i < a.length; i++) {
			if (a[i] > priorityQueue.peek()) {
				priorityQueue.poll();
				priorityQueue.add(a[i]);
				System.out.println(priorityQueue.toString());
			}
		}

		return priorityQueue.peek();
	}

	// n*log(n)
	public static int getKthLargestV1(int[] a, int k) {
		Integer[] array = new Integer[a.length];
		for (int i = 0; i < a.length; i++) {
			array[i] = a[i];
		}
		Arrays.sort(array, new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				int a = o1.intValue();
				int b = o2.intValue();
				if (b < a)
					return -1;
				if (b == a)
					return 0;
				if (b > a)
					return 1;

				return -1;
			}
		});

		// Arrays.sort(array, Collections.reverseOrder());
		System.out.println(Arrays.toString(array));
		return array[k - 1];
	}

	// n*log(n)
	public static int getKthLargestV2(int[] a, int k) {
		a = SortingAlgos.quickSort(0, a.length - 1, a);
		return a[a.length - k];
	}
}
