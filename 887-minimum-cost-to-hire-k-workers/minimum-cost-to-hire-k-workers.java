class Solution {
    public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        
        // double min;
        // min = wage[0];
        // k=k--;
        // // double ans = Double.MAX_VALUE;
        // int len = quality.length;
        // ArrayList<Double> list = new ArrayList<>();
        // for(int i = 1;i<len && k>0;i++){
        //     double frac = (double)quality[i]/quality[0];
        //     if(frac*wage[0]>=wage[i]){
        //         list.add()

        //     }
        //     // ans = Math.min(min,ans);
        //     min = wage[0];
            
        // }
        // double ans = Double.MAX_VALUE;
        // for(double num:arr){
        //     ans = Math.min(ans,num);
        // }
        // return ans;
        int n = quality.length;
        double ans = Double.MAX_VALUE;
        List<double[]> workers = new ArrayList<>(); // (ratio, quality)

        for (int i = 0; i < n; i++) {
            workers.add(new double[]{(double)wage[i] / quality[i], quality[i]});
        }
        
        Collections.sort(workers, (a, b) -> Double.compare(a[0], b[0])); // Sort by wage/quality ratio
        
        PriorityQueue<Integer> minHeap = new PriorityQueue<>((a, b) -> b - a); // Max heap for qualities
        int sum = 0;

        for (double[] worker : workers) {
            sum += worker[1];
            minHeap.offer((int)worker[1]);
            
            if (minHeap.size() > k) {
                sum -= minHeap.poll();
            }
            
            if (minHeap.size() == k) {
                ans = Math.min(ans, sum * worker[0]);
            }
        }
        
        return ans;
    }
}