class Solution {
    List<Integer> inOrderList;
    private boolean isSorted(){
        for(int i = 1;i < inOrderList.size();i++){
            if(inOrderList.get(i) > inOrderList.get(i-1)){
                continue;
            }
            else{
                return false;
            }
        }
        return true;
    }
    private void inOrder(TreeNode curr){
        if(curr == null) return;
        inOrder(curr.left);
        inOrderList.add(curr.val);
        inOrder(curr.right);
    }
    public boolean isValidBST(TreeNode root) {
        // taking advantage of Property of BST to be always sorted if written its inorder
        inOrderList = new ArrayList<>();
        inOrder(root);
        if(isSorted()){
            return true;
        }
        else{
            return false;
        }
    }
}

class Solution {
    private boolean isValidBST(TreeNode root, long minVal, long maxVal){
        // the root value should be in the range [minVal, maxVal]
        if(root == null) return true;
        if(root.val <= minVal || root.val >= maxVal){
            return false;// root's value is out of range
        }
        else{
            // root's value is in Range
            return isValidBST(root.left, minVal, root.val) && isValidBST(root.right, root.val, maxVal);
        }
    }
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
}
