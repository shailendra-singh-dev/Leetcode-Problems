package problems.arrays;

import java.util.Arrays;

import main.utilities.SortingAlgos;

/**
 * Merge two Sorted Arrays Without Extra Space
 * https://takeuforward.org/data-structure/merge-two-sorted-arrays-without-extra-space/
 * https://takeuforward.org/data-structure/merge-sort-algorithm/
 * @author ssingh42
 *
 */
public class MergeTwoSortedArraysWithoutExtraSpace {
	
	public void test() {
		/**
			int n = 4, arr1[] = {1, 3, 5, 7}; 
			int m = 5, arr2[] = {0, 2, 6, 8, 9};
		**/
		int n = 3, arr1[] = {1,2,3};
		int m = 3, arr2[] = {2,5,6};

		mergeV4(arr1,n,arr2,m);
	}

	public void mergeV1(int[] nums1, int m, int[] nums2, int n) {
		int[] result = new int[m + n];
		int k = 0;
		for (int i = 0; i < m; i++) {
			result[k++] = nums1[i];
		}
		for (int i = 0; i < n; i++) {
			result[k++] = nums2[i];
		}
		SortingAlgos.quickSort( 0, result.length-1, result);
		System.out.println(Arrays.toString(result));
	}
	
	public void mergeV2(int[] nums1, int m, int[] nums2, int n) {
		for (int i = 0; i < m; i++) {
			if (nums1[i] > nums2[0]) {
				int temp = nums1[i];
				nums1[i] = nums2[0];
				nums2[0] = temp;
			}
			nums2 = SortingAlgos.quickSort(0, nums2.length - 1, nums2);
		}
		int[] result = new int[m + n];
		int k = 0;
		for (int i = 0; i < m; i++) {
			result[k++] = nums1[i];
		}
		for (int i = 0; i < n; i++) {
			result[k++] = nums2[i];
		}
		mergeSort(result, 0, result.length-1);
		System.out.println(Arrays.toString(result));
	}
	
	public void mergeV3(int[] nums1, int m, int[] nums2, int n) {
		int k=0;
		for (int i = 0; i < m; i++) {
			if (nums1[i] > nums2[0]) {
				int temp = nums1[i];
				nums1[i] = nums2[0];
				nums2[0] = temp;
			}
			int first = nums2[0];
			for(k=1; k < n && nums2[k] < first; k++) {
				nums2[k-1] = nums2[k]; 
			}
			nums2[k-1] = first;
		}
		System.out.println(Arrays.toString(nums1));
		System.out.println(Arrays.toString(nums2));
		k = 0;
		int[] result = new int[m + n];
		for (int i = 0; i < m; i++) {
			result[k++] = nums1[i];
		}
		for (int i = 0; i < n; i++) {
			result[k++] = nums2[i];
		}
		mergeSort(result, 0, result.length-1);
		System.out.println(Arrays.toString(result));
	}
	
	private void mergeV4(int[] nums1, int m, int[] nums2, int n) {
		int[] result = new int[m+n];
		int index=0;
		for(int i=0;i<m;i++) {
			result[index++]=nums1[i]; 
		}
		for(int i=0;i<n;i++) {
			result[index++]=nums2[i]; 
		}
		mergeSort(result, 0, result.length-1);
		System.out.println(Arrays.toString(result));
	}
	
	private void mergeSort(int[] a, int left, int right) {
		if (left < right) {
			int mid = (left + right) / 2;
			mergeSort(a, left, mid);
			mergeSort(a, mid + 1, right);
			merge(a, left, mid + 1, right);
		}
	}
	
	private void merge(int arr[], int left, int mid, int right) {
		int[] temp = new int[arr.length];

		//Left array from left to mid-1, right array from mid to right.
		int i = left;
		int j = mid;
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
	}
	
}
