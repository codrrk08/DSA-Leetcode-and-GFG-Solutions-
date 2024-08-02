class Solution {
    public int helper(int arr[],int sum,int index){
        if(sum==0)
        return 1;
        if(index==0)
        return 1;

        int notPick = helper(arr,sum,index-1);
        int pick = 1;
        if(arr[index-1]<=sum){
            pick = arr[index-1]*helper(arr,sum-arr[index-1],index);
        }

        return Math.max(pick,notPick);
    }
    public int integerBreak(int n) {
        if(n==1)
        return 1;
        int arr[] = new int[n-1];
        for(int i = 0;i<n-1;i++){
            arr[i] = i+1;
        }
        return helper(arr,n,n-1);
    }
}