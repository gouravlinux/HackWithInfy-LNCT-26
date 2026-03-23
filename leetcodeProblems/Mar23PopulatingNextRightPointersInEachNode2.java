class Solution {
    public Node connect(Node root) {
        if(root == null) return null;
        // using BFS
        Queue<Node> que = new LinkedList<>();
        que.add(root);
        while(!que.isEmpty()){
            int levelSize = que.size();
            Node dummy = new Node();
            while(levelSize-- > 0){
                Node node = que.poll();
                dummy.next = node;
                dummy = dummy.next;
                if(node.left != null) que.add(node.left);
                if(node.right != null) que.add(node.right);
            }
            dummy.next = null;        
        }
        return root;     
    }
}

class Solution {
    private Node getNextRight(Node p){
        Node temp = p.next;
        while(temp != null){
            if(temp.left != null){
                return temp.left;
            }
            if(temp.right != null){
                return temp.right;
            }
            temp = temp.next;
        }
        return null;
    }
    public Node connect(Node p) {
        // using DFS(Recursion)
        if(p == null) return null;
        if(p.left != null){
            if(p.right != null){
                p.left.next = p.right;
            }
            else{
                p.left.next = getNextRight(p);
            }
        }
        if(p.right != null){
            p.right.next = getNextRight(p);
        }
        connect(p.right);// build right subtree first: useful for left 
        connect(p.left);
        return p;
    }
}

class Solution {
    private Node getNextRight(Node p){
        Node temp = p.next;
        while(temp != null){
            if(temp.left != null){
                return temp.left;
            }
            if(temp.right != null){
                return temp.right;
            }
            temp = temp.next;
        }
        return null;
    }
    public Node connect(Node root) {
        // using O(1) extra space 
        if(root == null) return null;
        root.next = null;
        Node newRoot = root;
        while(root != null){
            Node q = root;
            // traverse all nodes at current level
            while(q != null){
                if(q.left != null){
                    if(q.right != null){
                        q.left.next = q.right;
                    }
                    else{
                        q.left.next = getNextRight(q);
                    }
                }
                if(q.right != null){
                    q.right.next = getNextRight(q);
                }
                q = q.next;//next node of same level
            }
            if(root.left != null){
                root = root.left;
            }
            else if(root.right != null){
                root = root.right;
            }
            else{
                root = getNextRight(root);
            }
        }
        return newRoot;
    }
}
