class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {
        Arrays.sort(happiness);
        // int max = Integer.MIN_VALUE;
        long sum=0;
        int len = happiness.length;
        int dec=0;
        for(int i = len-1;i>=len-k;i--){
            happiness[i] = happiness[i]-dec;
            if(happiness[i]>0){
                sum+=happiness[i];
                dec++;
            }
            else if(happiness[i]==0){
                break;
            }
        }
        return sum;
        
    }
}