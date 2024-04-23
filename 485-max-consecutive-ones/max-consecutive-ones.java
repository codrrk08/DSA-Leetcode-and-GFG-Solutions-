class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int count = 0;
        int max = Integer.MIN_VALUE;
        for(int num:nums){
            if(num==1)
            count++;
            else
            count = 0;
            max = Math.max(max,count);
        }
        return max;
        
    }
}