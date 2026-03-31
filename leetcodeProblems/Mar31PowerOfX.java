class Solution {
    public double myPow(double x, int n) {
        double ans = 1.0;
        long num = n;
        if(num < 0){
            // power is negative
            num = -1 * num;
        }
        while(num > 0){
            if(num % 2 == 1){
                // power is odd
                ans = ans * x;
                num--;
            }
            else{
                // power is even
                x = x * x;
                num = (long)(num/2);
            }
        }
        if(n < 0){
            // if n was negative return 1/ans
            ans = (double)(1.0/ans);
        }
        return ans;
    }
}
class Solution {
    private double myPow(double x,long n){
        if(n <= 0){
            return 1;
        }
        if(n%2 == 0){
            // even power
            x = x * x;
            n = (long)n/2;
            return myPow(x, n);
        }
        else{
            // n%2 == 1
            return x * myPow(x, n-1);
        }
    }
    public double myPow(double x, int n) {
        // recursive solution
        long num = n;
        if(n < 0){
            num = -num;
            return (double)(1.0/myPow(x, num));
        }
        else{
            return myPow(x, num);
        }
    }
}
