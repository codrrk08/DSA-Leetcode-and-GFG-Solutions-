class Solution {
    public int longestOnes(int[] nums, int k) {
        int maxlen= 0;
        int l = 0;
        int r = 0;
        int numzero = 0 ;
        while(r<nums.length){
            if(nums[r]==0){
                numzero++;
            }
            while(numzero>k){
                if(nums[l]==0)
                numzero--;
                l++;
            }
            if(numzero<=k){
                maxlen = Math.max(maxlen,r-l+1);
            }
            r++;
        }
        return maxlen;
        
    }
}