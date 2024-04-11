class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> st = new Stack<>();
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int i = 0; i<nums1.length;i++)
        hm.put(nums1[i],i);
        int ans[] = new int[nums1.length];
        Arrays.fill(ans,-1);
        for (int i = 0; i < nums2.length; i++) {
            int current = nums2[i];
            while(!st.isEmpty() && current>st.peek()){
                int popped = st.pop();
                int index = hm.get(popped);
                ans[index] = current;
            }
            if(hm.get(current)!=null){
                st.push(current);
            }
        }
        return ans;
        // for(int num:nums2){
        // st.push(num);
        // }
        // int ans[] = new int[nums1.length];
        // for(int i = 0;i<nums1.length;i++){
        // int index = st.indexOf(nums1[i]);
        // int f=0;
        // for(int j = index+1;j<nums2.length;j++){
        // if(nums2[j]>nums1[i]){
        // ans[i]=nums2[j];
        // f=1;
        // break;
        // }
        // else
        // continue;
        // }
        // if(f!=1)
        // ans[i]=-1;
        // }
        // return ans;

    }
}