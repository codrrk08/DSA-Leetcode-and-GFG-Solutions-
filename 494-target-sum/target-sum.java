class Solution {
    public static int helper(int arr[],int sum,int index,int dp[][]){
        if(index==arr.length-1){
            if(sum==0 && arr[index]==0)
            return 2;
            if(arr[index]==sum)
            return 1;
            if(sum==0)
            return 1;
            
            return 0;
        }
        // return 1;
        // if((sum-curr)<curr)
        // retint urn 0;
        if(dp[index][sum]!=-1)
        return dp[index][sum];
        
        int leftSum = 0;
        if(arr[index]<=sum)
        leftSum = helper(arr,sum-arr[index],index+1,dp)%1000000007;
        int rightSum = helper(arr,sum,index+1,dp)%1000000007;
        
        return dp[index][sum] = (leftSum+rightSum)%1000000007;
    }
    public int findTargetSumWays(int[] nums, int target) {
        int sum  =0;
        for(int x:nums){
            sum+=x;
        }
        
        if(sum-target<0 || (sum-target)%2==1)
        return 0;
        
        int s2 = (sum-target)/2;
        int dp[][] = new int[nums.length][s2+1];
        for(int row[]:dp){
            Arrays.fill(row,-1);
        }
        return helper(nums,s2,0,dp);
    }
}