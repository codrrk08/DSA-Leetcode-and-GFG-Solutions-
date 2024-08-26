class Solution {
    public int answer(int nums[],int k){
        int n = nums.length;
        int i = 0;
        int j = 0;
        int count =0 ;
        HashMap<Integer,Integer> hm = new HashMap<>();
        while(j<n){
            hm.put(nums[j],hm.getOrDefault(nums[j],0)+1);
            while(hm.size()>k){
                hm.put(nums[i],hm.get(nums[i])-1);
                if(hm.get(nums[i])==0)
                hm.remove(nums[i]);
                i++;
            }
            count+=j-i+1;
            j++;
        }
        return count;
    }
    public int subarraysWithKDistinct(int[] nums, int k) {
        return answer(nums,k)-answer(nums,k-1);

    }
}