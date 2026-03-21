class Solution {
    public TreeNode invertTree(TreeNode root) {
        if(root == null || (root.left == null && root.right == null)){
            // if tree is empty or contains only root node
            return root;
        }
        // using DFS (and swapping strategy)
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }
}

class Solution {
    private TreeNode swap(TreeNode root) {
        if(root == null || (root.left == null && root.right == null)){
            // if tree is empty or contains only root node
            return root;
        }
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        return root;
    }
    public TreeNode invertTree(TreeNode root){
        // using BFS
        Queue<TreeNode> que = new LinkedList<>();
        que.add(root);
        while(!que.isEmpty()){
            TreeNode node = que.poll();
            swap(node);
            if(node != null){
                que.add(node.left);
                que.add(node.right);
            }
        }
        return root;
    }
}
