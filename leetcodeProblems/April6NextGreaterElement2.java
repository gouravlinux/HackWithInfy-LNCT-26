class Solution {
    public int[] nextGreaterElements(int[] nums) {
        // TC : O(n^2)
        // SC : O(n)
        int n = nums.length;
        int[] arr = new int[n];
        for(int i = 0;i < n;i++){
            int j = (i+1)%n;
            while(j != i && nums[i] >= nums[j]){
                j = (j+1)%n;
            }
            if(j != i)
                arr[i] = nums[j];
            else
                arr[i] = -1;
        }
        return arr;
    }
}
class Solution {
    public int[] nextGreaterElements(int[] nums) {
        // TC : O(2*n)
        // SC : O(3*n)(to store the answer array)
        int n = nums.length;
        int[] nge = new int[n];
        Stack<Integer> stack = new Stack<>();
        for (int i = 2 * n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= nums[i % n]) {
                stack.pop();
            }
            if (i < n) {
                nge[i] = stack.isEmpty() ? -1 : stack.peek();
            }
            stack.push(nums[i % n]);
        }
        return nge;
    }
}
