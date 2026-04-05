class Solution {
    int m;
    int n;

    private int[] getCoord(int mid) {
        int[] coord = new int[2];
        coord[0] = mid / n;
        coord[1] = mid % n;
        return coord;
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        // TC : O(log (m*n)) , SC : O(1)
        m = matrix.length;
        n = matrix[0].length;
        int s = 0;
        int e = m * n - 1;
        while (s <= e) {
            int mid = s + (e - s) / 2;
            int[] coord = getCoord(mid);
            int i = coord[0];
            int j = coord[1];
            if (matrix[i][j] == target) {
                return true;
            } else if (matrix[i][j] > target) {
                e = mid - 1;
            } else {
                // matrix[i][j] < target
                s = mid + 1;
            }
        }
        return false;
    }
}
