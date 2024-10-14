class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->{
            return Integer.compare(a[1],b[1]);
        });
        int n = intervals.length;
        // for(int i = 0;i<n;i++){
        //     System.out.println(intervals[i][0]+" "+intervals[i][1]);
        // }
        int prev[] = intervals[0];
        int count = 1;
        for(int i = 1;i<n;i++){
            if(intervals[i][0] >= prev[1]){
                count++;
                prev = intervals[i];
            }
            
            
        }
        return n-count;
        
    }
}