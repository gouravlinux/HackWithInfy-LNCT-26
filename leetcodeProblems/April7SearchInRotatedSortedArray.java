class Solution {
    int n;
    private int findPivot(int[] nums){
        int l = 0;
        int r = n-1;
        int mid = 0;
        while(l < r){
            mid = l+(r-l)/2;
            if(nums[mid] > nums[r]){
                l = mid+1;//pivot on the right half
            }
            else{
                r = mid;// pivot is mid or the left half
            }
        }
        return l;// index of pivot : can be r also as both point to same pivot
    }
    private int binarySearch(int[] nums, int target, int s, int e){
        while(s <= e){
            int mid = s+(e-s)/2;
            if(nums[mid] == target){
                return mid;
            }
            else if (nums[mid] > target){
                // go to left half
                e = mid-1;
            }
            else{
                // nums[mid] < target
                // go to right half
                s = mid+1;
            }
        }
        return -1;
    }
    public int search(int[] nums, int target) {
        // TC : O(log n)
        // SC : O(1)
        n = nums.length;
        int pivotIdx = findPivot(nums);
        int idx = binarySearch(nums, target, 0, pivotIdx-1);
        if(idx != -1) return idx;//found
        idx = binarySearch(nums, target, pivotIdx, n-1);
        return idx;
    }
}
