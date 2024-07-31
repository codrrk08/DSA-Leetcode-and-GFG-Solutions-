class Solution {
    // public int helper(int nums[],int index,int n,int dp[]){
    // if(index==n)
    // return 0;
    // int maxLen=1;
    // // int len = 0;
    // if(dp[index]!=-1)
    // return dp[index];
    // for(int i = index+1;i<n;i++){
    // if(nums[i]>nums[index]){
    // maxLen=Math.max(maxLen,1 + helper(nums,i,n,dp));
    // }
    // }

    // return dp[index] = maxLen;
    // }
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        // int max = 0;
        // int dp[] = new int[n+1];
        // Arrays.fill(dp,-1);
        // for(int i = 0;i<n;i++){
        // max = Math.max(max,helper(nums,i,n,dp));
        // }
        int[] dp = new int[n];
        Arrays.fill(dp, 1); // Each element is an increasing subsequence of length 1

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        int max = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}