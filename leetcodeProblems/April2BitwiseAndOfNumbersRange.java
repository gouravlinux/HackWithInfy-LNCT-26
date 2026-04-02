class Solution {
    public int rangeBitwiseAnd(int left, int right) {
	// worst case me ek no ke saare bits check karne honge joki log n hote hai
	// TC : O(logn)
        int leftNum = left;
        int rightNum = right;
        int shiftsCnt = 0;
        while(leftNum != rightNum){
            leftNum = leftNum >> 1;
            rightNum = rightNum >> 1; // right shifts
            shiftsCnt++;
        }
        // leftNum: longest common prefix was found using bit manipulation
        return leftNum << shiftsCnt; // left shift and padd 0s
    }
}
class Solution {
    public int rangeBitwiseAnd(int left, int right) {
        // brute approach : iterate from left to right and do &
        // optimal approach 
        // start from right till right > left and do right = right & (right-1)
        // the iterations would reduce and is less than right-left
	// TC is less than O(n)
        while(right > left){
            right = (right & (right-1));
        }
        // now right is out-of-range and thus it is the answer
        return right;
    }
}
