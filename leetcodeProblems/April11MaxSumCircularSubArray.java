class Solution {
    int n;
    private int kadanesMax(int[] nums){
        int sum = nums[0];
        int maxSum = nums[0];
        for(int i = 1;i < n;i++){
            sum = Math.max(sum + nums[i], nums[i]);
            maxSum = Math.max(sum, maxSum);
        }
        return maxSum;
    }
    private int kadanesMin(int[] nums){
        int sum = nums[0];
        int minSum = nums[0];
        for(int i = 1;i < n;i++){
            sum = Math.min(sum + nums[i], nums[i]);
            minSum = Math.min(sum, minSum);
        }
        return minSum;
    }
    public int maxSubarraySumCircular(int[] nums) {
        // maxSubarraySum = totalSum - minSubArraySum
        n = nums.length;
        int sum = 0;
        for(int x: nums){
            sum += x;
        }
        int minSum = kadanesMin(nums);
        int maxSum = kadanesMax(nums);
        int circularSum = sum - minSum;
        if(maxSum > 0){
            return Math.max(maxSum, circularSum);
        }
        return maxSum;
    }
}
