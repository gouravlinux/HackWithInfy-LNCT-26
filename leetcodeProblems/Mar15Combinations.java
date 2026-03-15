class Solution {
    List<List<Integer>> res;
    private void solve(int n,int k,int num,List<Integer> temp){
	
	//traditional backtracking template
        if(temp.size() == k){
            res.add(new ArrayList<>(temp));
            return;
        }
	if(num > n){
	    return;
	}
        // include it
        temp.add(num);
        solve(n, k, num+1, temp);
        //backtrack
        temp.remove(temp.size()-1);

        // not include it
        solve(n, k, num+1, temp);
        
    }
    public List<List<Integer>> combine(int n, int k) {
        res = new ArrayList<>();
        solve(n,k,1,new ArrayList<>());
        return res;
    }
}

class Solution {
    List<List<Integer>> res;

    private void solve(int n, int k, List<Integer> temp, int start) {
        if (k == temp.size()) {
            res.add(new ArrayList<>(temp));
            return;//backtrack
        }
        for (int i = start; i <= n; i++) {
            temp.add(i);//include
            solve(n, k, temp, i + 1);//explore
            temp.remove(temp.size() - 1);//remove: due to backtracking
        }
    }

    public List<List<Integer>> combine(int n, int k) {
        res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        solve(n, k, temp, 1);
        return res;
    }
}
