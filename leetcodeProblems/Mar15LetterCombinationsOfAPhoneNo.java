class Solution {
    List<String> res;
    Map<Character,String> hashmap = new HashMap<>();
    int n;
    private void solve(String digits, int idx, String temp){
        if(idx >= n){
            res.add(temp);
            return;
        }
        char digit = digits.charAt(idx);
        for(char ch: hashmap.get(digit).toCharArray()){
            solve(digits, idx+1, temp + ch);
            // backtrack
        }
    }
    public List<String> letterCombinations(String digits) {
        n = digits.length();
        res = new ArrayList<>();
        hashmap.put('2', "abc");
        hashmap.put('3', "def");
        hashmap.put('4', "ghi");
        hashmap.put('5', "jkl");
        hashmap.put('6', "mno");
        hashmap.put('7', "pqrs");
        hashmap.put('8', "tuv");
        hashmap.put('9', "wxyz");
        solve(digits, 0, "");
        return res;
    }
}
