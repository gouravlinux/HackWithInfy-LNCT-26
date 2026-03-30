class Solution {
    private boolean isPalindrome(String str){
        int i = 0;
        int j = str.length()-1;
        while(i < j){
            if(str.charAt(i) != str.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
    public boolean isPalindrome(int x) {
        if(x < 0) return false;
        if(isPalindrome(Integer.toString(x))){
            return true;
        }
        return false;
    }
}
class Solution {
    private long reverse(int x){
        long ans = 0;
        while(x > 0){
            int digit = x%10;
            ans = ans*10 + digit;
            x = x/10;   
        }
        return ans;
    }
    public boolean isPalindrome(int x) {
        // follow up: do it without changing int to string
        if(x < 0){
            return false;
        }
        long reversed_x = reverse(x);
        if(reversed_x == (int)x){
            return true;
        }
        return false;
    }
}
