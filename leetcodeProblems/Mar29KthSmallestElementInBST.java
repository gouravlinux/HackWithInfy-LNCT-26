class Solution {
    // TC: O(n) and even same SC
    List<Integer> inOrderList;
    private void inOrder(TreeNode root){
        if(root == null) return;
        inOrder(root.left);
        inOrderList.add(root.val);
        inOrder(root.right);
    }
    public int kthSmallest(TreeNode root, int k) {
        inOrderList = new ArrayList<>();
        inOrder(root);
        return inOrderList.get(k-1);
    }
}
class Solution {
    int cnt;
    int ans;
    private void inOrder(TreeNode root, int k){
        // TC : O(n) and SC: O(n):recursion stack space 
        if(root == null) return;
        inOrder(root.left, k);
        cnt++;
        if(cnt == k){
            ans = root.val;
            return;
        }
        inOrder(root.right, k);
    }
    public int kthSmallest(TreeNode root, int k) {
        ans = -1;
        cnt = 0;
        inOrder(root, k);
        return ans;
    }
}

class Solution {
    public int kthSmallest(TreeNode root, int k) {
        int ans = -1;
        int cnt = 0;
        // using Morris Traversal: 
        // O(n):TC and O(1):SC
        TreeNode curr = root;
        while (curr != null) {
            if (curr.left == null) {
                cnt++;//for curr
                if (cnt == k) {
                    ans = curr.val;
                    return ans;
                }
                curr = curr.right;
            } else {
                TreeNode prev = curr.left;
                while (prev.right != null && prev.right != curr) {
                    prev = prev.right;// go to extreme right but not equal to curr
                }
                if (prev.right == null) {
                    prev.right = curr;//linking thread
                    curr = curr.left;// traverse left subtree
                } else {
                    // prev.right = curr
                    prev.right = null;// cut-off thread
                    cnt++;
                    if(cnt == k){
                        ans = curr.val;
                        return ans;
                    }
                    curr = curr.right;//traverse on right subtree
                }
            }
        }
        return ans;
    }
}
