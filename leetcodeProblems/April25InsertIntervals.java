class Solution {
    private int[][] mergeIntervals(List<int[]> list){
        int n = list.size();
        List<int[]> newList = new ArrayList<>();
        int prev_start = list.get(0)[0];
        int prev_end = list.get(0)[1];
        for(int i = 1;i < n;i++){
            int new_start = list.get(i)[0];
            int new_end = list.get(i)[1];
            if(prev_end >= new_start){
                // overlapping
                prev_start = Math.min(prev_start, new_start);
                prev_end = Math.max(prev_end, new_end);
            }
            else{
                // non-overlapping
                newList.add(new int[]{prev_start, prev_end});
                prev_start = new_start;
                prev_end = new_end;
            }
        }
        newList.add(new int[]{prev_start, prev_end});
        n = newList.size();
        int[][] resArr = new int[n][];
        for(int i = 0;i < n;i++){
            int[] arr = newList.get(i);
            resArr[i] = arr;
        }
        return resArr;
    }
    public int[][] insert(int[][] intervals, int[] newInterval) {
        // TC : O((n+1)log(n+1))+O(n)+O(n)
        // SC : O(2n)
        List<int[]> list = new ArrayList<>();
        for(int[] interval: intervals){
            list.add(interval);
        }
        list.add(newInterval);
        Collections.sort(list, (a,b)->{
            if(a[0] != b[0]){
                return a[0]-b[0];
            }else{
                return a[1]-b[1];
            }
        });
        return mergeIntervals(list);
    }
}

class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        // TC : O(n)
        // SC : O(n)
        List<int[]> list = new ArrayList<>();
        int i = 0;
        int n = intervals.length;
        // add all intervals coming before new interval
        while(i < n && intervals[i][1] < newInterval[0]){
            list.add(intervals[i]);
            i++;
        } 
        // merge overlapping intervals
        while(i < n && intervals[i][0] <= newInterval[1]){
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        // add the merged interval
        list.add(newInterval);
        // add remaining intervals
        while(i < n){
            list.add(intervals[i++]);
        }
        return list.toArray(new int[list.size()][]);
    }
}
