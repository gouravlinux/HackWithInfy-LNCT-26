class Solution {
    public int trailingZeroes(int n) {
        if(n == 0) return 0;
        int cntFives = 0;
        // i = 5^k at kth iteration
        // therefore k = logn to the base 5
        // TC = O(log n) and SC = O(1)
        for(int i = 5;i <= n;i = i*5){
            cntFives += n/i;
        }
        return cntFives;             
    }
}
