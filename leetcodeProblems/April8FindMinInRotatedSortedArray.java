class Solution {
    int n;
    private int findPivot(int[] nums){
        int s = 0;
        int e = n-1;
        while(s < e){
            int mid = s+(e-s)/2;
            if(nums[mid] > nums[e]){
                s = mid+1;
            }
            else{
                e = mid;
            }
        }
        return e;
    }
    public int findMin(int[] nums) {
        // TC : O(log n)
        // SC : O(1)
        n = nums.length;
        int pivot = findPivot(nums);
        return nums[pivot];
    }
}
