class Solution {
    public int findPairs(int[] nums, int k) {
        HashSet<String> hs = new HashSet<>();
        Arrays.sort(nums);
        for(int i = 0; i<nums.length;i++){
            int num1 = nums[i];
            for(int j = i+1; j<nums.length;j++){
                if(Math.abs(num1-nums[j])==k){
                    hs.add(num1+","+nums[j]);
                }
            }
        }
        return hs.size();
        
    }
}