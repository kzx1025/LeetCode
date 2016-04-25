package zero_twenty.median_of_two_sorted_arrays;

/**
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
 * Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
 * Created by iceke on 15/10/17.
 */
public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int totalLength = nums1.length+nums2.length;
        int[] c = new int[totalLength];
        int i = 0;
        int j = 0;
        int m = 0;
        while(i<nums1.length&&j<nums2.length){
            if(nums1[i]<nums2[j]){
                c[m] = nums1[i];
                m++;
                i++;
            }else{
                c[m] = nums2[j];
                m++;
                j++;
            }
        }
        while(i<nums1.length){
            c[m++] = nums1[i++];
        }
        while(j<nums2.length){
            c[m++] = nums2[j++];
        }
        if(totalLength%2 != 0){
            return c[totalLength/2+1-1];
        }else{
            return (c[totalLength/2-1]+c[totalLength/2+1-1])/2.0;
        }


    }


    /**
     * from the internet,采用了递归的方法，着重复习
     * @param A
     * @param B
     * @return
     */
    public double findMedianSortedArrays2(int A[], int B[]) {
        int len = A.length + B.length;
        if (len % 2 == 1) {
            return findKth(A, 0, B, 0, len / 2 + 1);
        }
        return (
                findKth(A, 0, B, 0, len / 2) + findKth(A, 0, B, 0, len / 2 + 1)
        ) / 2.0;
    }

    // find kth number of two sorted array
    public static int findKth(int[] A, int A_start,
                              int[] B, int B_start,
                              int k){
        if (A_start >= A.length) {
            return B[B_start + k - 1];
        }
        if (B_start >= B.length) {
            return A[A_start + k - 1];
        }

        if (k == 1) {
            return Math.min(A[A_start], B[B_start]);
        }

        int A_key = A_start + k / 2 - 1 < A.length
                ? A[A_start + k / 2 - 1]
                : Integer.MAX_VALUE;
        int B_key = B_start + k / 2 - 1 < B.length
                ? B[B_start + k / 2 - 1]
                : Integer.MAX_VALUE;

        if (A_key < B_key) {
            return findKth(A, A_start + k / 2, B, B_start, k - k / 2);
        } else {
            return findKth(A, A_start, B, B_start + k / 2, k - k / 2);
        }
    }
    public static void main(String args[]){
        int[] a = {1,2,4,6};
        int[] b = {3,5,7,8};
        Solution solution = new Solution();
        double result = solution.findMedianSortedArrays(a,b);
        System.out.println(result);

    }
}
