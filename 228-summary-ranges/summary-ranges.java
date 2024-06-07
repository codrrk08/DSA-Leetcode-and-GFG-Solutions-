class Solution {
    public List<String> summaryRanges(int[] nums) {
        if(nums.length==0)
        return new ArrayList<>();
        List<String> list = new ArrayList<>();
        int k = 0;
        int i = 0;
        for(i= 1;i<nums.length;i++){
            if(nums[i]-nums[i-1]==1){
                k++;
                continue;
            }
            else{
                if(k!=0)
                list.add(String.valueOf(nums[i-1]-k)+"->"+String.valueOf(nums[i-1]));
                else
                list.add(String.valueOf(nums[i-1]));
                k=0;
            }
        }
        if(k!=0)
        list.add(String.valueOf(nums[i-1]-k)+"->"+String.valueOf(nums[i-1]));
        else
        list.add(String.valueOf(nums[i-1]));
        return list;
    }
}