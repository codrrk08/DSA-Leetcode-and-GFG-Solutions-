class Solution {
    public int majorityElement(int[] nums) {

        Arrays.sort(nums);
        int i=0,count=1;
        
        while(i<nums.length-1)
        {
            
            
            if(nums[i]==nums[i+1])
            {
                count++;
               

            }
            if(count>(nums.length/2))
            return nums[i];
            if(nums[i]!=nums[i+1])
            count=1;
            i++;


        }
        return nums[i];
    }
}




