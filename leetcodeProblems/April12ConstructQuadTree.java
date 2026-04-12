class Solution {
    int n;
    private boolean isAllSame(int[][] grid, int x,int y,int n){
        int val = grid[x][y];
        for(int i = x;i < x + n;i++){
            for(int j = y;j < y + n;j++){
                if(grid[i][j] != val)
                    return false;
            }
        }
        return true;
    }
    private Node solve(int[][] grid, int x,int y,int n){
        if(isAllSame(grid, x, y, n)){
            return new Node(grid[x][y] == 1?true: false, true);
        } else{
            Node root = new Node(grid[x][y] == 1?true:false, false);
            root.topLeft     = solve(grid, x, y, n/2);
            root.topRight    = solve(grid, x, y+n/2, n/2);
            root.bottomLeft  = solve(grid, x+n/2, y, n/2);
            root.bottomRight = solve(grid, x+n/2, y+n/2, n/2);
            return root;
        }
    }
    public Node construct(int[][] grid) {
        // Stack space : O(log(n))
        // TC : O(n^2 * log(n))-> 
        // n^2 is isAllSame()
        // log(n) is height of the tree 
        n = grid.length;
        return solve(grid, 0, 0, n);
    }
}
