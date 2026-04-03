class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        // TC: O(2nlogn) -> ek sorting + ek poori heap push and pop
        // SC : vec -> O(n) and heap -> O(n)
        int n = profits.length;
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            arr[i][0] = capital[i];
            arr[i][1] = profits[i];
        }
        Arrays.sort(arr, (a, b) -> { // O(nlogn)
            if (a[0] != b[0]) {
                return a[0] - b[0];
            } else {
                 return a[1] - b[1];
            }
        });
        int i = 0;
        PriorityQueue<Integer> maxPQ = new PriorityQueue<>(Collections.reverseOrder());// max size of heap would be N(all elements are pushed)
        while (k-- > 0) {
            // find how many of the projects can be done in w
            // create a maxHeap
            
            while (i < n) {
                if (arr[i][0] <= w) {
                    maxPQ.add(arr[i][1]);//add its profit : O(logn)
                    i++;
                } else {
                    break;
                }
            }
            if(!maxPQ.isEmpty())
                w += maxPQ.poll();//O(logn)
            else{
                break;
            }
        }
        return w;
    }
}
