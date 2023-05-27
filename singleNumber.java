class Solution {
    public int singleNumber(int[] nums) {
        
        int i=0;
        Arrays.sort(nums);
        
        while(i<=nums.length-1)
        {
           
            if(i==nums.length-1)
            return nums[i];

            if(nums[i]==nums[i+1])
            i+=2;
            else
            break;
            
        }
        return nums[i];

    }
}
