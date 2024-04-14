class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> st = new Stack<>();
        int max = 0;
        st.push(0);

        for(int i = 1;i<heights.length;i++){
            while(!st.isEmpty() && heights[i]<heights[st.peek()]){
                max = getMax(heights,st,max,i);
            }
            st.push(i);
        }

        int i = heights.length;
        while(!st.isEmpty()){
            max = getMax(heights,st,max,i);
        }
        return max;
        
    }
    static int getMax(int []arr, Stack<Integer> stack, int max,int i){
        int area;
        int popped = stack.pop();
        if (stack.isEmpty()) {
        area = arr[popped] * i;
        } else {
        area = arr[popped] * (i - 1 - stack.peek());
        }
        return Math.max(max, area);
    }
}