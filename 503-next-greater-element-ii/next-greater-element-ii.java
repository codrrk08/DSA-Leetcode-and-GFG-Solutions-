class Solution {
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> s = new Stack<>();
        int ans[] = new int[nums.length];
        Arrays.fill(ans,-1);
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int i = 0;i<nums.length;i++){
            hm.put(nums[i],i);
        }
        // for(int i = 0;i<nums.length;i++){
        //     int current = nums[i];
        //     while(!st.isEmpty() && current>st.peek()){
        //         int popped = st.pop();
        //         int index = hm.get(popped);
        //         ans[index] = current;
                
        //     }
        //     st.push(current);
        // }
        for(int i=0; i<nums.length; i++){
            while(!s.isEmpty() && (nums[s.peek()]<nums[i])){
                ans[s.peek()]=nums[i];
                s.pop();
            }
            s.push(i);
        }
        System.out.println(Arrays.toString(ans));
        System.out.println(s.toString());
        for(int i=0; i<nums.length; i++){
            while(!s.isEmpty() && (nums[s.peek()]<nums[i])){
                ans[s.peek()]=nums[i];
                s.pop();
            }
            // s.push(i);
        }
        // for(int i = 0;i<hm.get(st.peek());i++){
        //     int current = nums[i];
        //     while(!st.isEmpty() && current>st.peek()){
        //         ans[hm.get(st.peek())] = current;
        //         st.pop();
        //     }
        // }
        return ans;
        
    }
}