class Solution {
    List<List<Integer>> res;
    int n;

    private void solve(int[] candidates, int target, int start, int sum, List<Integer> temp) {
        if (sum > target) {
            return;// backtrack
        }
        if (sum == target) {
            // found 1 ans
            res.add(new ArrayList<>(temp));
            return; // backtrack as one answer is found
        }
        for (int i = start; i < n; i++) {
            // include
            temp.add(candidates[i]);
            // explore
            solve(candidates, target, i, sum + candidates[i], temp);
            // backtrack
            // exclude
            temp.remove(temp.size() - 1);
            // exploration done by for loop after exclusion
        }
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        n = candidates.length;
        res = new ArrayList<>();
        solve(candidates, target, 0, 0, new ArrayList<>());
        return res;
    }
}
