class Solution {
    public void sortColors(int[] nums) {
        TreeMap<Integer,Integer> tm = new TreeMap<>();
        for(int num:nums){
            tm.put(num,tm.getOrDefault(num,0)+1);
        }
        // System.out.println(tm.toString());
        int k = 0;
        int index = 0;
        int loop=0;
        for(int i =0;i<3;i++){
            if(tm.containsKey(i))
            loop = tm.get(i);
            else
            continue;
            while(loop!=0){
                nums[index] = i;
                index++;
                loop--;
            }
        }
        
        
    }
}