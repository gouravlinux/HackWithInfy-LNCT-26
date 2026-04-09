class Solution {
    private double findMedian(int[] arr){
        int n = arr.length;
        double median = 0.0;
        if(n % 2 == 0){
            median = (arr[n/2-1]+arr[n/2])/2.0;
        }
        else{
            median = arr[n/2];
        }
        return median;
    }
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
	// TC : O(m+n) SC : O(m+n)
        int m = nums1.length;
        int n = nums2.length;
        int[] merged = new int[m+n];
        int i = 0;
        int j = 0;
        int k = 0;
        while(i < m && j < n){
            if(nums1[i] <= nums2[j]){
                merged[k++] = nums1[i++];
            }
            else{
                merged[k++] = nums2[j++];
            }
        }
        while(i < m){
            merged[k++] = nums1[i++];
        }
        while(j < n){
            merged[k++] = nums2[j++];
        }
        double median = findMedian(merged);
        return median;
    }
}
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
	// O(m+n) TC and O(1) SC
        int m = nums1.length;
        int n = nums2.length;
        int i = 0;
        int j = 0;
        int k = 0;
        int idx1 = (m + n) / 2 - 1;
        int idx2 = idx1 + 1;
        int[] elements = new int[2];
        while (i < m && j < n) {
            if (nums1[i] <= nums2[j]) {
                if (k == idx1) {
                    elements[0] = nums1[i];
                }
                if (k == idx2) {
                    elements[1] = nums1[i];
                }
                i++;
            } else {
                if (k == idx1) {
                    elements[0] = nums2[j];
                }
                if (k == idx2) {
                    elements[1] = nums2[j];
                }
                j++;
            }
            k++;
        }
        while (i < m) {
            if (k == idx1) {
                elements[0] = nums1[i];
            }
            if (k == idx2) {
                elements[1] = nums1[i];
            }
            i++;
            k++;
        }
        while (j < n) {
            if (k == idx1) {
                elements[0] = nums2[j];
            }
            if (k == idx2) {
                elements[1] = nums2[j];
            }
            j++;
            k++;
        }
        if((m+n)%2 == 0){
            return (elements[0] + elements[1])/2.0;
        }
        else{
            return elements[1];
        }
    }
}
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // TC : O(log(min(m,n))), SC : O(1)
        if(nums1.length > nums2.length){
            return findMedianSortedArrays(nums2, nums1);
        }
        int m = nums1.length;
        int n = nums2.length;

        int l = 0;
        int r = m;

        while(l <= r){
            int Px = l + (r-l)/2;// from nums1
            int Py = (m+n+1)/2-Px;// from nums2

            // left half
            int x1 = (Px == 0) ? Integer.MIN_VALUE : nums1[Px-1];
            int x2 = (Py == 0) ? Integer.MIN_VALUE : nums2[Py-1];
            // right half
            int x3 = (Px == m) ? Integer.MAX_VALUE : nums1[Px];
            int x4 = (Py == n) ? Integer.MAX_VALUE : nums2[Py];

            if(x1 <= x4 && x2 <= x3){
                if((m+n)%2 == 1){
                    return Math.max(x1, x2);
                }
                else{
                    return (Math.max(x1, x2)+Math.min(x3, x4))/2.0;
                }
            }
            if(x1 > x4){
                r = Px-1;
            }
            else{
                l = Px+1;
            }
        }
        return -1;
    }
}
