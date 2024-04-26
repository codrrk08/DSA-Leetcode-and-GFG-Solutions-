class Solution {
public:
    int fun(vector<int>& nums, int goal){
        if(goal<0) return 0;
        int j=0,ans=0,sum=0;

        for(int i=0;i<nums.size();i++){
            sum+=nums[i];

            while(sum>goal){
                sum-=nums[j];
                j++;
            }

            ans+=(i-j+1);

        }
        return ans;
    }
    int numSubarraysWithSum(vector<int>& nums, int goal) {
        return fun(nums,goal)-fun(nums,goal-1);
        
    }
};