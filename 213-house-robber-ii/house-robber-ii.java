class Solution {
    public int helper(int nums[],int index,int dp[]){
        if(index==nums.length-1)
        return nums[index];
        if(index>nums.length-1)
        return 0;
        
        if(dp[index]!=-1)
        return dp[index];
        int jump = nums[index] + helper(nums,index+2,dp);
        int notJump = 0+ helper(nums,index+1,dp);

        return dp[index] = Math.max(jump,notJump);

    }
    public int rob(int[] nums) {
        if(nums.length==1)
        return nums[0];
        int dp[]= new int[nums.length+1];
        Arrays.fill(dp,-1);
        int ans1 = helper(Arrays.copyOfRange(nums,0,nums.length-1),0,dp);
        Arrays.fill(dp,-1);
        int ans2 = helper(nums,1,dp);
        return Math.max(ans1,ans2);

    }
}