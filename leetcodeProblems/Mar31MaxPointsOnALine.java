class Solution {
    public int maxPoints(int[][] points) {
        // brute solution
        // for any 2 distinct points x and y, compute all possible z points 
        // where z != x and z != y and 
        // z would be determined that it has same slope as the line 
        // made by x and y
        // O(n^3) TC, O(1) SC
        int n = points.length;
        if(n == 1) return 1;
        int maxPointsCnt = 0;
        for(int i = 0;i < n;i++){//point1
            
            for(int j = i+1;j < n;j++){//point2
                int cnt = 2;// as 2 points exist in that line
                int dx = (points[j][0]-points[i][0]);//(x2-x1)
                int dy = (points[j][1]-points[i][1]);//(y2-y1)
                // slope = dy/dx 
                // dy/dx = dy_/dx_ -> dy*dx_ = dy_*dx
                for(int k = j+1;k < n;k++){
                    if(k != i && k != j){
                        // if k is not the same point as i and j
                        int dx_ = (points[k][0] - points[i][0]);//(x3-x1)
                        int dy_ = (points[k][1]-points[i][1]);//(y3-y1)
                        if(dy*dx_ == dx*dy_){
                            // k lies on same line of xy
                            cnt++;
                        }
                    }
                }
                maxPointsCnt = Math.max(maxPointsCnt, cnt);
            }
        } 
        return maxPointsCnt;
    }
}
class Solution {
    private int getGCD(int a, int b) {
        if(b == 0) return a;
        return getGCD(b, a%b);
    }

    public int maxPoints(int[][] points) {
        // any 2 points are if making slopes same, then they lie on the same line
        // therefore create hash map and for every 2 points, see and store their 
        // slopes in a hash table in the format of "dy/dx" or "dy_dx"
        // hash table {dy_dx : cnt}
        // find max count from hash table
        // TC:O(n^2),SC:O(k) where k slopes are formed by points
        int n = points.length;
        if(n <= 2) return n;
        int res = 0;
        for (int i = 0; i < n; i++) {
            Map<String, Integer> map = new HashMap<>();
            int duplicates = 0;
            int maxSlope = 0;
            for (int j = i + 1; j < n; j++) {
                int dy = (points[j][1] - points[i][1]);
                int dx = (points[j][0] - points[i][0]);

                // Case 1: if it is a duplicate point
                if(dx == 0 && dy == 0){
                    duplicates++;
                    continue;
                }
                // since 4:1 and 8:2 are same slopes 
                // therefore we need to divide dy and dx with their gcd
                int gcd = getGCD(Math.abs(dx), Math.abs(dy));
                dy = dy/gcd;
                dx = dx/gcd;
                // NORMALIZE SIGNS:
                // Ensure that -1/2 and 1/-2 both become -1/2
                // normalize sign
                if (dx < 0) {
                    dx = -dx;
                    dy = -dy;
                }

                // vertical line normalization
                if (dx == 0) {
                    dy = 1;
                }

                // horizontal line normalization
                if (dy == 0) {
                    dx = 1;
                }
                String key = dy + "/" + dx;
                int count = map.getOrDefault(key, 0) + 1;
                // double angle = Math.atan2(dy,dx);//find tan-1(dy/dx)
                map.put(key, count);
                maxSlope = Math.max(maxSlope, count);
            }
            res = Math.max(res, maxSlope+duplicates+1);//1 is added for i point
        }
        return res;
    }
}
class Solution {
    private int getGCD(int a, int b) {
        if(b == 0) return a;
        return getGCD(b, a%b);
    }

    public int maxPoints(int[][] points) {
        // any 2 points are if making slopes same, then they lie on the same line
        // therefore create hash map and for every 2 points, see and store their 
        // slopes in a hash table in the format of "dy/dx" or "dy_dx"
        // hash table {dy_dx : cnt}
        // find max count from hash table
        // TC:O(n^2),SC:O(k) where k slopes are formed by points
        int n = points.length;
        if(n <= 2) return n;
        int res = 0;
        for (int i = 0; i < n; i++) {
            Map<Double, Integer> map = new HashMap<>();
            int duplicates = 0;
            int maxSlope = 0;
            for (int j = i + 1; j < n; j++) {
                int dy = (points[j][1] - points[i][1]);
                int dx = (points[j][0] - points[i][0]);

                // Case 1: if it is a duplicate point
                if(dx == 0 && dy == 0){
                    duplicates++;
                    continue;
                }
                // since 4:1 and 8:2 are same slopes 
                // therefore we need to divide dy and dx with their gcd
                int gcd = getGCD(Math.abs(dx), Math.abs(dy));
                dy = dy/gcd;
                dx = dx/gcd;
                // NORMALIZE SIGNS:
                // Ensure that -1/2 and 1/-2 both become -1/2
                // normalize sign
                if (dx < 0) {
                    dx = -dx;
                    dy = -dy;
                }

                // vertical line normalization
                if (dx == 0) {
                    dy = 1;
                }

                // horizontal line normalization
                if (dy == 0) {
                    dx = 1;
                }
                // String key = dy + "/" + dx;
                
                double angle = Math.atan2(dy,dx);//find tan-1(dy/dx)
                int count = map.getOrDefault(angle, 0) + 1;
                map.put(angle, count);
                maxSlope = Math.max(maxSlope, count);
            }
            res = Math.max(res, maxSlope+duplicates+1);//1 is added for i point
        }
        return res;
    }
}
