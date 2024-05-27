class Solution {
    public int specialArray(int[] nums) {
        // HashSet<Integer> hs = new HashSet<>();
        int max = Integer.MIN_VALUE;
        for(int num:nums){
            max = Math.max(max,num);
        }
        for(int i = 0;i<=max;i++){
            int count = 0;
            for(int num:nums){
                if(num>=i)
                count++;
            }
            if(count==i)
            return i;
        }
        return -1;
    }
}