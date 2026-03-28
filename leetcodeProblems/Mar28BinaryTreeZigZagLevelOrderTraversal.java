class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ansList = new ArrayList<>();
        if (root == null)
            return ansList;
        Queue<TreeNode> que = new LinkedList<>();
        que.add(root);
        int level = 1;
        // even levels should have reverse order
        while (!que.isEmpty()) {
            int n = que.size();
            List<Integer> list = new ArrayList<>();
            while (n-- > 0) {
                TreeNode item = que.poll();
                if (item.left != null)
                    que.add(item.left);
                if (item.right != null)
                    que.add(item.right);
                list.add(item.val);
            }
            if(level%2 == 0){
                Collections.reverse(list);
            }
            ansList.add(list);
            level++;
        }
        return ansList;
    }
}

class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        // TC and SC : O(N)
        List<List<Integer>> ansList = new ArrayList<>();
        if (root == null)
            return ansList;
        Queue<TreeNode> que = new LinkedList<>();
        que.add(root);
        boolean flag = false;//means left to right
        // even levels should have reverse order
        while (!que.isEmpty()) {
            int n = que.size();
            List<Integer> list = new ArrayList<>();
            while (n-- > 0) {
                TreeNode item = que.poll();
                if (item.left != null)
                    que.add(item.left);
                if (item.right != null)
                    que.add(item.right);
                if (!flag)
                    list.add(item.val);//insert left to right
                else
                    list.add(0, item.val);// insert right to left
            }
            ansList.add(list);
            if (flag)
                flag = false;
            else
                flag = true;
        }
        return ansList;
    }
}
