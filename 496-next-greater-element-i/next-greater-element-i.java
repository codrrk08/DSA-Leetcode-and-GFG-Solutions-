class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
       Stack<Integer> st = new Stack<>();
       for(int num:nums2){
            st.push(num);
       } 
       int ans[] = new int[nums1.length];
       for(int i = 0;i<nums1.length;i++){
            int index = st.indexOf(nums1[i]);
            int f=0;
            for(int j = index+1;j<nums2.length;j++){
                if(nums2[j]>nums1[i]){
                    ans[i]=nums2[j];
                    f=1;
                    break;
                }
                else
                continue;
            }
            if(f!=1)
            ans[i]=-1;
        }
        return ans;

    }
}