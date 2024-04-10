class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> hm = new HashMap<Integer,Integer>();
        for(int i = 0; i<nums.length;i++){
            int second = target-nums[i];
            if(hm.containsKey(second)){
                return new int[]{hm.get(second),i};
            }
            hm.put(nums[i],i);
        }
        return new int[]{0,0};
    }
}