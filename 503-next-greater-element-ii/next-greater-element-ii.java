class Solution {
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> s = new Stack<>();
        int ans[] = new int[nums.length];
        Arrays.fill(ans,-1);
        for(int i=0; i<nums.length; i++){
            while(!s.isEmpty() && (nums[s.peek()]<nums[i])){
                ans[s.peek()]=nums[i];
                s.pop();
            }
            s.push(i);
        }
        for(int i=0; i<nums.length; i++){
            while(!s.isEmpty() && (nums[s.peek()]<nums[i])){
                ans[s.peek()]=nums[i];
                s.pop();
            }
        }
        return ans;
        
    }
}