class Solution {
    List<Integer> inOrderList;
    private void inOrder(TreeNode root){
        if(root == null) return;
        inOrder(root.left);
        inOrderList.add(root.val);
        inOrder(root.right);
    }
    public int getMinimumDifference(TreeNode root) {
        inOrderList = new ArrayList<>();
        inOrder(root);
        int minDiff = Integer.MAX_VALUE;
        for(int i = 1;i < inOrderList.size();i++){
            minDiff = Math.min(minDiff, inOrderList.get(i) - inOrderList.get(i-1));
        }
        return minDiff;
    }
}

class Solution {
    int minDiff;
    TreeNode prev;

    private void inOrder(TreeNode root){
        if(root == null) return;
        inOrder(root.left);
        if(prev != null){
            minDiff = Math.min(minDiff, Math.abs(prev.val-root.val));
        }
        prev = root;
        inOrder(root.right);
    }
    public int getMinimumDifference(TreeNode root) {
        minDiff = Integer.MAX_VALUE;
        prev = null;
        inOrder(root);
        return minDiff;
    }
}
