class Solution {
    public int helper(int nums[],int start,int dp[]){
        if(start==nums.length-1)
        return nums[start];
        if(start>nums.length-1){
            return 0;
        }

        if(dp[start]!=-1)
        return dp[start];
        // int max = -1;
        // for(int i = start;i<nums.length;i++){
            int jump = nums[start] + helper(nums,start+2,dp);
            int notJump = 0 + helper(nums,start+1,dp);
            return dp[start] = Math.max(notJump,jump);
        // }
        // return dp[start]=max;
    }
    public int rob(int[] nums) {
        int dp[] = new int[nums.length+1];
        Arrays.fill(dp,-1);
        return helper(nums,0,dp);
    }
}