class Solution {
    // public int helper(int nums[],int start,int dp[]){
    //     if(start==nums.length-1)
    //     return nums[start];
    //     if(start>nums.length-1){
    //         return 0;
    //     }

    //     if(dp[start]!=-1)
    //     return dp[start];
    //     // int max = -1;
    //     // for(int i = start;i<nums.length;i++){
    //         int jump = nums[start] + helper(nums,start+2,dp);
    //         int notJump = 0 + helper(nums,start+1,dp);
    //         return dp[start] = Math.max(notJump,jump);
    //     // }
    //     // return dp[start]=max;
    // }
    public int rob(int[] nums) {
        int n = nums.length;
        int dp[] = new int[n+1];
        dp[0] = 0;
        dp[1] = nums[0];
        // dp[n]
        // Arrays.fill(dp,-1);
        for(int i = 2;i<=n;i++){
            int jump = nums[i-1] + dp[i-2];
            int notJump = 0 + dp[i-1];
            dp[i] = Math.max(jump,notJump);
        }
        return dp[n];
    }
}