class Solution {
    Map<Integer, List<Integer>> adj;
    boolean[] visited;
    boolean[] inRecursion;//in same DFS(what all are visited)
    boolean hasCycleDFS(int v){
        visited[v] = true;
        inRecursion[v] = true;
        List<Integer> neighbours = adj.getOrDefault(v,new ArrayList<>());
        for(int n: neighbours){
            if(!visited[n] && hasCycleDFS(n)){
                return true;
            }
            // else see if it is visited and is true in current recursion
            else if (inRecursion[n]){
                return true;
            }
        }
        inRecursion[v] = false;
        return false;
    } 
    boolean isCyclic(int V, int[][] edges) {
        // code here
        adj = new HashMap<>();
        for(int[] edge: edges){
            int u = edge[0];
            int v = edge[1];
            if(!adj.containsKey(u)){
                adj.put(u, new ArrayList<>());
            }
            adj.get(u).add(v);
        }
        visited = new boolean[V];
        inRecursion = new boolean[V];
        for(int v: adj.keySet()){
            if(!visited[v] && hasCycleDFS(v)){
                return true;
            }
        }
        return false;
    }
}
class Solution {
    boolean[] visited;
    boolean[] inRecursion;//in same DFS(what all are visited)
    boolean hasCycleDFS(int v,int[][] edges) {
        visited[v] = true;
        inRecursion[v] = true;
        for(int[] edge: edges){
            if(edge[0] != v){
                continue;
            }
            // else
            int n = edge[1];//neighbour
            if(!visited[n] && hasCycleDFS(n, edges)){
                return true;
            }
            // else see if it is visited and is true in current recursion
            else if (inRecursion[n]){
                return true;
            }
        }
        inRecursion[v] = false;
        return false;
    } 
    boolean isCyclic(int V, int[][] edges) {
        visited = new boolean[V];
        inRecursion = new boolean[V];
        for(int i = 0;i < V;i++){
            if(!visited[i] && hasCycleDFS(i, edges)){
                return true;
            }
        }
        return false;
    }
}
// using bfs
class Solution {
    boolean[] visited;
    boolean[] inRecursion;//in same BFS(what all are visited)
    boolean hasCycleBFS(int v,int[][] edges) {
        visited[v] = true;
        inRecursion[v] = true;
        Queue<Integer> que = new LinkedList<>();
        que.add(v);
        while(!que.isEmpty()){
            int queV = que.poll();
            for(int[] edge: edges){
                if(edge[0] != queV){
                    continue;
                }
                // else
                int n = edge[1];//neighbour
                if(!visited[n] && hasCycleBFS(n, edges)){
                    return true;
                }
                // else see if it is visited and is true in current recursion
                else if (inRecursion[n]){
                    return true;
                }
            }
        }
        
        inRecursion[v] = false;
        return false;
    } 
    boolean isCyclic(int V, int[][] edges) {
        visited = new boolean[V];
        inRecursion = new boolean[V];
        for(int i = 0;i < V;i++){
            if(!visited[i] && hasCycleBFS(i, edges)){
                return true;
            }
        }
        return false;
    }
}
