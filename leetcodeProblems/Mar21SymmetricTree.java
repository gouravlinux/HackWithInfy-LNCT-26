class Solution {
    private boolean isSymmDFS(TreeNode leftNode, TreeNode rightNode){
        if(leftNode == null && rightNode == null){
            return true;
        }
        if(leftNode == null || rightNode == null){
            return false;// as one is null and one is not
        }
        if(leftNode.val != rightNode.val){
            return false;
        }
        return isSymmDFS(leftNode.left, rightNode.right) && isSymmDFS(leftNode.right, rightNode.left);
    }
    public boolean isSymmetric(TreeNode root) {
	// using DFS
        return isSymmDFS(root, root);
    }
}
