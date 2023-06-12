class Solution {
    public int findMiddleIndex(int[] nums) {
        if(nums.length==1)
        return 0;
        int i =0,left=0,right=0;
        while(i<nums.length)
        {
            if(i==0)
            {
                left=0;
                right=0;
                for(int j =i+1;j<nums.length;j++)
                right = right+ nums[j];
                if(left==right)
                return i;
                else
                {
                    i++;
                    right=0;
                }
            }
            else if(i==nums.length-1)
            {
                right=0;
                left=0;
                for(int j=i-1;j>=0;j--)
                left= left+nums[j];
                if(left==right)
                return i;
                else
                i++;
            }
            else
            {
                
                left = left+ nums[i-1];
                for(int j=i+1;j<nums.length;j++)
                right = right + nums[j];
                if(left==right)
                return i;
                else
                {
                    i++;
                    right=0;

                }
            }
        }
        return -1;
        
    }
}
