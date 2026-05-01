class Solution {
    int result;
    private int solve(TreeNode root){
        if(root == null) return 0;
        int leftDepth = solve(root.left);
        int rightDepth = solve(root.right);
        result = Math.max(result, leftDepth+rightDepth);
        return Math.max(leftDepth, rightDepth)+1;
    }
    public int diameterOfBinaryTree(TreeNode root) {
        // TC : O(n)
        // Auxialiary space : O(1)
        // Recursion : O(max Depth of tree)->O(n)
        result = Integer.MIN_VALUE;
        solve(root);
        return result;
    }
}

class Solution {
    int result;

    private int findHeight(TreeNode root) {
        if (root == null)
            return 0;
        int leftHeight = findHeight(root.left);
        int rightHeight = findHeight(root.right);
        int height = Math.max(leftHeight, rightHeight);
        return height + 1;
    }

    private void solve(TreeNode root) {
        if (root == null)
            return;
        int leftHeight = findHeight(root.left);
        int rightHeight = findHeight(root.right);
        result = Math.max(result, leftHeight + rightHeight);
        solve(root.left);
        solve(root.right);
    }

    public int diameterOfBinaryTree(TreeNode root) {
        // TC : O(n^2)
        // recursion stack : O(n) 
        // acc. to worst case: skewed tree
        result = Integer.MIN_VALUE;
        solve(root);
        return result;
    }
}
