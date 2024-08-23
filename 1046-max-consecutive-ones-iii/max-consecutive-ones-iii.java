class Solution {
    public int longestOnes(int[] nums, int k) {
        // int maxlen= 0;
        // int l = 0;
        // int r = 0;
        // int zeros = 0 ;
        // while(r<nums.length){
        //     // if(nums[r]==0){
        //     //     numzero++;
        //     // }
        //     // while(numzero>k){
        //     //     if(nums[l]==0)
        //     //     numzero--;
        //     //     l++;
        //     // }
        //     // if(numzero<=k){
        //     //     maxlen = Math.max(maxlen,r-l+1);
        //     // }
        //     // r++;
        //     if(nums[r]==0){
        //         zeros++;
        //     }
        //     if(zeros>k){
        //         if(nums[l]==0)
        //         zeros--;
        //         l++;
        //     }
        //     if(zeros<=k)
        //     maxlen = Math.max(maxlen,r-l+1);
        //     r++;
        // }
        // return maxlen;
		int max  =0;
		int i = 0;
		int j = 0;
        int n = nums.length;
		while(j<n){
			if(nums[j]==0) k--;

			if (k < 0){
                if (nums[i] == 0) k++;
                i++;
            }
        	max = Math.max(max, j - i +1);
            j++;
		}
		return max;
        
    }
}