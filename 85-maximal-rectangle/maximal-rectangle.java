class Solution {
    static int[] nextSmallerIndex(int arr[]){
        int n = arr.length;
        int nsi[] = new int[n];
        nsi[n-1] = n;
        Stack<Integer> st = new Stack<>();
        st.push(n-1);

        for(int i=n-2; i>=0; i--){
            while(st.size()!=0 && arr[st.peek()]>=arr[i]) st.pop();

            if(st.size()==0) nsi[i] = n;
            else nsi[i] = st.peek();
            st.push(i);
        }
        return nsi;
    }

    static int[] previousSmallerIndex(int arr[]){
        int n = arr.length;
        int psi[] = new int[n];
        psi[0] = -1;
        Stack<Integer> st = new Stack<>();
        st.push(0);

        for(int i=1; i<n; i++){
            while(st.size()!=0 && arr[st.peek()]>=arr[i]) st.pop();

            if(st.size()==0) psi[i] = -1;
            else psi[i] = st.peek();
            st.push(i);
        }
        return psi;
    }

    static int findArea(int arr[]){
        int n = arr.length;
        int nsi[] = nextSmallerIndex(arr);
        int psi[] = previousSmallerIndex(arr);
        int area = 0;
        for(int i=0; i<n; i++){
            int h = arr[i];
            int b = Math.abs(nsi[i]-psi[i])-1;
            area = Math.max(area,h*b);
        }
        return area;
    }
    public int maximalRectangle(char[][] matrix) {
    
        int area = 0;
        int n = matrix.length;
        int m = matrix[0].length;
        int arr[] = new int[m];
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(matrix[i][j]=='0') arr[j] = 0;
                else arr[j] = arr[j]+1;
            }
            area = Math.max(area,findArea(arr));
        }
        return area;
    }   
}