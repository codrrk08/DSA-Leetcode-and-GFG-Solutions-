class Solution {
    public int minIncrementForUnique(int[] nums) {
//   2ND APPROACH
        // TreeMap<Integer,Integer> tm = new TreeMap<>();
        // for(int num:nums){
        //     tm.put(num,tm.getOrDefault(num,0)+1);
        // }
        // int moves = 0;
        // ArrayList<Integer> keys = new ArrayList<>(tm.keySet());
        // System.out.println(keys);
        // Stack<Integer> st = new Stack<>();
        // for(int key:keys){
        //     st.push(key);
        // }
        // while(!st.isEmpty()){
        //     int curr = st.peek();
        //     if(tm.get(curr)>1){
        //         tm.put(curr,tm.get(curr)-1);
        //         tm.put(curr+1,tm.getOrDefault(curr,0)+1);
        //         st.push(curr+1);
        //         moves++;
        //     }
        //     else
        //     st.pop();
        // }
        // return moves;
// 1ST APPROACH
        // for(Map.Entry<Integer,Integer>entry:hm.entrySet()){
        //     if(entry.getValue()>1){
        //         int current = entry.getKey();
        //         while(entry.getValue()>1){
        //             hm.put(current+1,hm.getOrDefault(current+1,0)+1);
        //             hm.put(current,hm.get(current)-1);
        //             moves++;
        //         }
        //     }
        // }
        // return moves;
// 3RD APPROACH
        Arrays.sort(nums);
        int moves = 0;
        for(int i = 1;i<nums.length;i++){
            if(nums[i]<=nums[i-1]){
                int movesRequired = Math.abs(nums[i]-nums[i-1])+1;
                moves+=movesRequired;
                nums[i]+=movesRequired;
            }
        }
        return moves;
        
    }
}