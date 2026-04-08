class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        int[] res = new int[n];
        for(int i = 0;i < n;i++){
            res[i] = nums[(n+(i-k))%n];
        }
        for(int i = 0;i < n;i++){
            nums[i] = res[i];
        }
    }
}
class Solution {
    int n;

    private void swap(int[] nums, int s, int e) {
        int temp = nums[s];
        nums[s] = nums[e];
        nums[e] = temp;
    }

    private void reverse(int[] nums, int s, int e) {
        if (s < 0 || e < 0 || s >= n || e >= n)
            return;
        while (s <= e) {
            swap(nums, s, e);
            s++;
            e--;
        }
    }

    public void rotate(int[] nums, int k) {
	// TC : O(n-k) + O(k) + O(n) = O(2n)
	// SC : O(1)
        n = nums.length;
        k = k % n;
        reverse(nums, 0, n - k - 1);
        reverse(nums, n - k, n - 1);
        reverse(nums, 0, n - 1);
    }
}
