class Solution {
    public int findArea(int arr[]){
        int n = arr.length;
        // int array[] = new int[n];
        // for(int i = 0;i<n;i++){
        //     array[i] = arr[i]-'0';
        // }
        Stack<Integer> st = new Stack<>();
        int maxArea = 0;
        for(int i = 0;i<=n;i++){
            while(!st.isEmpty() && (i==n || arr[st.peek()]>=arr[i])){
                int height = arr[st.peek()];
                st.pop();
                int width;
                if(st.isEmpty())
                width = i;
                else
                width = i-st.peek()-1;
                maxArea = Math.max(maxArea,(width*height));
            }
            st.push(i);
        }
        return maxArea;
    }
    public int maximalRectangle(char[][] matrix) {
        int r = matrix.length;
        int c = matrix[0].length;
        int prefix[][] = new int[r][c];
        for(int j = 0;j<c;j++){
            int sum = 0;
            for(int i=0;i<r;i++){
                sum+=matrix[i][j]-'0';
                if(matrix[i][j]-'0'==0)
                sum = 0;
                prefix[i][j] = sum;
            }
        }


        int max = 0;
        for(int i = 0;i<r;i++){
            max = Math.max(max,findArea(prefix[i]));
        }
        return max;
    }
}