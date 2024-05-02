class Solution {
    public int findMaxK(int[] nums) {
        // HashSet<Integer> hs1  = new HashSet<>();
        // HashSet<Integer> hs2  = new HashSet<>();
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();

        for(int i = 0;i<nums.length;i++){
            if(nums[i]<0)
            list1.add(nums[i]);
            else
            list2.add(nums[i]);
        }
        int max = -1;
        for(int i = 0;i<list1.size();i++){
            int num = list1.get(i);
            if(list2.contains(Math.abs(num)))
            max = Math.max(Math.abs(num),max);
        }
        return max;

        
    }
}