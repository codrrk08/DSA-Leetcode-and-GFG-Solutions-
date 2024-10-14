class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> list = new ArrayList<>();
        int n = intervals.length;
        Arrays.sort(intervals,(a,b)->{
            return Integer.compare(a[0],b[0]);
        });
        int prev[] = intervals[0];
        for(int i = 1;i<=n;i++){
            if(i==n){
                list.add(prev);
                break;
            }
            if(intervals[i][0]<=prev[1]){
                prev[0] = Math.min(intervals[i][0],prev[0]);
                prev[1] = Math.max(intervals[i][1],prev[1]);
            }
            else{
                list.add(prev);
                prev = intervals[i];
            }
        }
        int ans[][] = new int[list.size()][2];
        for(int i =0 ;i<list.size();i++){
            ans[i] = list.get(i);
        }
        return ans;
    }
}