package problems.arrays;

import java.util.Arrays;

public class ReversePairs {

	public void test() {
		//int[] a= new int[] {5,4,3,2,1};
		int[] a =new int[] {1,3,2,3,1};
		System.out.println(Arrays.toString(a));
		int count =reversePairs(a);
		System.out.println(Arrays.toString(a));
		System.out.println("Count:"+ count);
	}
	
	public int reversePairs(int[] a) {
		return mergeSort(a, 0, a.length-1);
    }
	
	private int mergeSort(int[] a, int left, int right) {
		int cnt=0;
		if (left < right) {
			int mid = (left + right) / 2;
			cnt = mergeSort(a, left, mid);
			cnt = +mergeSort(a, mid + 1, right);
			cnt = +merge(a, left, mid +1, right);
		}
		return cnt;
	}
	
	
	private int merge(int arr[], int left, int mid, int right) {
		int j= mid; 
		int cnt = 0;
		//Left array from left to mid-1, right array from mid to right.
		for (int i=left;i<=mid-1;i++) {
			while (j<=right && arr[i] > 2*(arr[j])) {
				j++;
			}
			cnt += (j-(mid+1));
		}
		
		int[] temp = new int[arr.length];

		//Left array from left to mid-1, right array from mid to right.
		int i = left;
		//int j = mid;
		int k = left;
		while ((i <= mid - 1) && (j <= right)) {
			if (arr[i] <= arr[j]) {
				temp[k++] = arr[i++];
			} else {
				temp[k++] = arr[j++];
			}
		}
		// Copy the remaining elements of left subarray  (if there are any) to temp
		while (i <= mid - 1)
			temp[k++] = arr[i++];
		// Copy the remaining elements of right subarray (if there are any) to temp
		while (j <= right)
			temp[k++] = arr[j++];
		// Copy back the merged elements to original array
		for (i = left; i <= right; i++)
			arr[i] = temp[i];	
		
		return cnt;
	}

}
