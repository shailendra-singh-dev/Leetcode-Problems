package problems.arrays;


/**
 * https://takeuforward.org/data-structure/count-inversions-in-an-array/
 * @author ssingh42
 */

public class CountInversionsInAnArray {
	/**
	 * Time complexity: O(nlogn) Reason: At each step, we divide the whole array,
	 * for that logn and we assume n steps are taken to get sorted array, so overall
	 * time complexity will be nlogn .
	 * Space complexity: O(n)
	 **/
	
	public void test() {
		int[] a= new int[]{1,2,3,4,5};
		int count = getCount(a);
		System.out.println("count:"+ count);
	}
	
    private int getCount(int[] a){
        return mergeSort(a, 0, a.length-1);
    }
	
	private int mergeSort(int[] a, int left, int right) {
		int count_inversions=0;
		if (left < right) {
			int mid = (left + right) / 2;
			count_inversions += mergeSort(a, left, mid);
			count_inversions += mergeSort(a, mid + 1, right);
			count_inversions += merge(a, left, mid + 1, right);
		}
		return count_inversions;
	}
	
	private int merge(int arr[], int left, int mid, int right) {
		int count_inversions=0;
		int i, j, k;
		int[] temp = new int[arr.length];

		//Left array from left to mid-1, right array from mid to right.
		i = left;
		j = mid;
		k = left;
		while ((i <= mid - 1) && (j <= right)) {
			if (arr[i] <= arr[j]) {
				temp[k++] = arr[i++];
			} else {
				temp[k++] = arr[j++];
				
				count_inversions += (mid-i);
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
		
		return count_inversions;
	}
}
