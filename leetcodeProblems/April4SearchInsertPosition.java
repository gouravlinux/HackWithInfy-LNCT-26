class Solution {
    public int searchInsert(int[] nums, int target) {
        // TC : O(log n)
        // SC : O(1)
        int n = nums.length;
        int s = 0;
        int e = n-1;
        int ans = -1;
        if(target <= nums[0]){
            return 0;
        }
        if (target > nums[n-1]){
            return n;
        }
        while(s <= e){
            int mid = s + (e-s)/2;
            if(nums[mid] == target){
                return mid;
            }
            else if (nums[mid] < target){
                s = mid+1;
            }
            else{
                // if nums[mid] > target
                ans = mid;
                e = mid-1;
            }
        }
        return ans;
    }
}
class Solution {
    public int searchInsert(int[] nums, int target) {
        // TC : O(log n)
        // SC : O(1)
        int idx = Arrays.binarySearch(nums , target);
        if(idx < 0){
            // target was not found, therefore -(insertionpoint)-1 was returned
            idx = -(idx)-1;
        }
        return idx;
    }
}
