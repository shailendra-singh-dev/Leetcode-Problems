package main.utilities;

public class SortingAlgos {

	
	public int[] bubbleSort(int[] array) {
		for (int i = 0; i < array.length - 1; i++) {
			for (int j = 0; j < array.length - i - 1; j++) {
				if (array[j] > array[j + 1]) {
					int temp = array[j];
					array[j] = array[j + 1];
					array[j + 1] = temp;
				}
			}
		}
		return array;
	}
		
	public static int[] quickSort(int low, int high, int[] a) {
		if (low >= high) {
			return null;
		}
		int index = (high + low) / 2;
		int piot = a[index];
		int i = low, j = high;
		while (i <= j) {
			while (a[i] < piot)
				i++;

			while (a[j] > piot)
				j--;

			if (i <= j) {
				int temp = a[i];
				a[i] = a[j];
				a[j] = temp;
				i++;
				j--;
			}
		}

		if (low < j)
			quickSort(low, j, a);

		if (i < high)
			quickSort(i, high, a);

		return a;
	}
	
	
}


