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
		int n = 4, arr1[] = {1, 3, 5, 7}; 
		int m = 3, arr2[] = {1,2,3,0,0,0};

		mergeV3(arr1,n,arr2,m);
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
		System.out.println(Arrays.toString(result));
	}
	
	private void mergeV3(int[] nums1, int m, int[] nums2, int n) {
		int[] result = new int[m+n];
		int index=0;
		for(int i=0;i<m;i++) {
			result[index++]=nums1[i]; 
		}
		for(int i=0;i<n;i++) {
			result[index++]=nums2[i]; 
		}
		System.out.println("before merge" +Arrays.toString(result));
		mergeSort(result, 0, result.length-1);
	}
	
	private void mergeSort(int[] a, int left, int right) {
		if(left < right) {
			int mid = (left+right)/2;
			mergeSort(a,left,mid);
			mergeSort(a,mid+1,right);
			merge(a,left,mid+1,right);
		}
	}

	private void merge(int[] a,int leftArrayStart, int rightArrayStart, int rightArrayEnd) {
		int leftArrayEnd = rightArrayStart - 1;
		int numElements = rightArrayEnd - leftArrayStart + 1;
		int[] result = new int[numElements];
		int resultingArrayStart = 0;
		while (leftArrayStart <= leftArrayEnd && rightArrayStart <= rightArrayEnd) {
			if (a[leftArrayStart] <= a[rightArrayStart]) {
				result[resultingArrayStart++] = a[leftArrayStart++];
			} else {
				result[resultingArrayStart++] = a[rightArrayStart++];
			}
		}
		while (leftArrayStart <= leftArrayEnd) {
			result[resultingArrayStart++] = a[leftArrayStart++];
		}
		while (rightArrayStart <= rightArrayEnd) {
			result[resultingArrayStart++] = a[rightArrayStart++];
		}
		System.out.println("While merging,numElements: " + numElements + ",rightArrayEnd:" +rightArrayEnd+ "result:"+ Arrays.toString(result));
		for (int i = numElements-1; i>=0; i--,rightArrayEnd--) {
			a[rightArrayEnd] = result[i];
		}
	}

}
