class Solution {
    public int[] twoSum(int[] nums, int target) {
        int i=0,j;

        while(i<nums.length)
        {
            j=i+1;
            while(j<nums.length)
            {
                if(nums[i]+nums[j]==target)
                return new int[]{i,j};
                j++;
            }
            i++;
        }
        return null;
        
    }
}
