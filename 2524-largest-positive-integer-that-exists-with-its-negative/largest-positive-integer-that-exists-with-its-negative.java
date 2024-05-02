class Solution {
    public int findMaxK(int[] nums) {
        // HashSet<Integer> hs2  = new HashSet<>();
        
        HashSet<Integer> hs = new HashSet<>();
        int max = -1;
        for(int i = 0;i<nums.length;i++){
            if(hs.contains(-nums[i])){
                max = Math.max(max,Math.abs(-nums[i]));
            }
            else
            hs.add(nums[i]);
        }
        return max;
        

        
    }
}