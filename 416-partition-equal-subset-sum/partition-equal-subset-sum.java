class Solution {
    public boolean helper(int target,int nums[],int index,int dp[][]){
        if(target==0)
        return true;
        if(index==nums.length-1){
            if(target==nums[index])
            return true;
            else
            return false;
        }

        if(dp[index][target]!=-1)
        return (dp[index][target]==0)?false:true;
        boolean take = false;
        if(nums[index]<=target)
        take = helper(target-nums[index],nums,index+1,dp);

        boolean notTake = helper(target,nums,index+1,dp);
        
        dp[index][target] = (take||notTake)?1:0;
        return (take||notTake);

    }
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int i = 0;i<nums.length;i++){
            sum+=nums[i];
        }
        int n = nums.length;
        
        if(sum%2==0){
            int dp[][] = new int[n+1][sum/2+1];
            for(int row[]:dp){
                Arrays.fill(row,-1);
            }
            int target = sum/2;
            if(helper(target,nums,0,dp))
            return true;
            else
            return false;
        }
        else
        return false;
        
    }
}