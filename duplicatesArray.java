class Solution {
    public List<Integer> findDuplicates(int[] nums) {

        Arrays.sort(nums);
        int i=0;
        List<Integer> list = new ArrayList<Integer>();
        while(i<nums.length)
        {
            if(i==nums.length-1)
            break;
            if(nums[i]==nums[i+1])
            {
                list.add(nums[i]);
                i+=2;
            }
            else
            i++;

        }
        return list;




        
    }
}
