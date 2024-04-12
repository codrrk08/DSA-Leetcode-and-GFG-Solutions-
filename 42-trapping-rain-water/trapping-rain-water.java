class Solution {
    public int trap(int[] height) {
        // int left= 0;
        // int right=height.length-1;
        // int ans=0,area=0;
        // // Two-pointer approach
        // while(left<right)
        // {
        //     area =Math.min(height[left],height[right]) * (right-left);
        //     ans = Math.max(ans,area);
        //     if(height[left]<height[right])
        //     left++;
        //     else if(height[left]==height[right])
        //     {
        //         left++;
        //         right--;
        //     }
        //     else
        //     right--;
        // }
        // return ans;
        Stack<Integer> st = new Stack<>();
        int water = 0;
        int max = Integer.MIN_VALUE;
        for(int i = 0; i<height.length;i++){
            max = Math.max(max,height[i]);
        }
        int f=0;
        int index=0;
        for(int i = 0;i<height.length;i++){
            if(i==0 && height[i]==0)
            continue;
            int current = height[i];
            // st.push(current);
            while(!st.isEmpty() && current>=st.get(0)){
                int minLeft = Math.min(st.get(0),current);
                water+=minLeft-st.peek();
                st.pop();
            }
            if(current!=max)
            st.push(current);
            else{
                index = i;
                f=1;
                break;
            }
        }
        if(f==1){
            for(int j = height.length-1;j>=index;j--){
                int current = height[j];
                while(!st.isEmpty() && current>=st.get(0)){
                    int minLeft = Math.min(st.get(0),current);
                    water+=minLeft-st.peek();
                    st.pop();
                }
                st.push(current);
            }
        }
        return water;
        
    }
}