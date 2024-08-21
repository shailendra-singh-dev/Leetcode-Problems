package problems.binary_search;

/**
 * https://takeuforward.org/data-structure/k-th-element-of-two-sorted-arrays/
 */
public class KthElementOfTwoSortedArrays {

	/**
	 * Time Complexity: O(log(min(m, n))), where m and n are the sizes of two given arrays. 
	 * Reason: We are applying binary search on the range [max(0, k-n2), min(k, n1)]. The range length <= min(m, n).
	 * Space Complexity: O(1), as we are not using any extra space to solve this problem.
	 */
	public long getKthElement( int arr1[], int arr2[], int n, int m, int k) {
        if(n > m) {
            return getKthElement(arr2, arr1, m, n, k); 
        }
        
        int low = Math.max(0,k-m), high = Math.min(k,n);
        
        while(low <= high) {
            int cut1 = (low + high) >> 1; 
            int cut2 = k - cut1; 
            int l1 = cut1 == 0 ? Integer.MIN_VALUE : arr1[cut1 - 1]; 
            int l2 = cut2 == 0 ? Integer.MIN_VALUE : arr2[cut2 - 1];
            int r1 = cut1 == n ? Integer.MAX_VALUE : arr1[cut1]; 
            int r2 = cut2 == m ? Integer.MAX_VALUE : arr2[cut2]; 
            
            if(l1 <= r2 && l2 <= r1) {
                return Math.max(l1, l2);
            }
            else if (l1 > r2) {
                high = cut1 - 1;
            }
            else {
                low = cut1 + 1; 
            }
        }
        return 1; 
    }

}
