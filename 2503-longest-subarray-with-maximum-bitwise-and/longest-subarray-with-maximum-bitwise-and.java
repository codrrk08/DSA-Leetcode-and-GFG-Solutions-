class Solution {
    public int longestSubarray(int[] nums) {
        int maxAnd = 0;
        for(int x:nums){
            maxAnd = Math.max(maxAnd,x);
        }
        int maxLen = 0;
        int len = 0;
        // int prev = maxAnd;
        for(int i = 0;i<nums.length;i++){
            if(nums[i]==maxAnd){
                len++;
                // prev = nums[i];
                continue;
            }
            
            maxLen = Math.max(maxLen,len);
            len = 0;
        }
        maxLen = Math.max(maxLen,len);
        return maxLen;
    }
}