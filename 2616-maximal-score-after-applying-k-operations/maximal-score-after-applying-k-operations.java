class Solution {
    public long maxKelements(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int x:nums){
            pq.offer(x);
        }
        long sum = 0;
        for(int i = 0;i<k;i++){
            long num = pq.poll();
            sum+=num;
            pq.offer((int)Math.ceil(num/3.0));
        }
        return sum;
    }
}