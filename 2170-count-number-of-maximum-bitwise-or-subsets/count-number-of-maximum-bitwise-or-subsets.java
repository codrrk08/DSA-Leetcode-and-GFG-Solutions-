class Solution {
    int count =0;
    public void findAnswer(int nums[],int index,int maxOr,int currOr){
        
        if(index==nums.length){
            if(currOr==maxOr){
                count++;
            }
            return;
        }
        

        findAnswer(nums,index+1,maxOr,currOr|nums[index]);
        findAnswer(nums,index+1,maxOr,currOr);

        return;

    }
    public int countMaxOrSubsets(int[] nums) {
        int maxOr = 0;
        for (int num : nums) {
            maxOr = maxOr | num;
        }
        // count = 0;
        findAnswer(nums,0,maxOr,0);
        return count;
    }
}