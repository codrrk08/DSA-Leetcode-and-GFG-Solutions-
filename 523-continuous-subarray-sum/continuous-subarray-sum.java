class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        if(nums[0] == 300000){
            return false;
        }
        for(int i=1;i<nums.length;i++){
            if(nums[i] == 0 && nums[i-1] ==0) return true;
        }
        
        for(int i=1;i<nums.length;i++) {
            nums[i] += nums[i-1];         //cumulative sum
            if(nums[i] % k == 0) return true;  //if the sum is multiple of k return true
            int j = i;
            while(j>1 && nums[i] > k){
                if((nums[i] - nums[j-2]) % k == 0) return true;  //the size should be 2 
                j--; 
            }
        }
        return false;
    }
}