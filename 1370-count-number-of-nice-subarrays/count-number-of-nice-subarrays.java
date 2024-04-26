class Solution {
    public int fun(int[] nums, int k) {
        if(k<0) return 0;
        int j=0,ans=0,sum=0;

        for(int i=0;i<nums.length;i++){
            if(nums[i]%2==1)
            sum+=1;
            else
            sum+=0;

            while(sum>k){
                if(nums[j]%2==1)
                sum-=1;
                j++;
            }

            ans+=(i-j+1);

        }
        return ans;
    }
    public int numberOfSubarrays(int[] nums, int k) {
        return fun(nums,k)-fun(nums,k-1);
    }
}