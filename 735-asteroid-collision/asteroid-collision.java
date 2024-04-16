class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        // Stack<Integer> st = new Stack<>();
        // st.push(asteroids[0]);
        // for(int i = 1; i<asteroids.length;i++){
        //     int curr = asteroids[i];
        //     if(st.peek()>0 && curr>0 || st.peek()<0 && curr<0){
        //         st.push(curr);
        //     }
        //     else{
        //         while(!st.isEmpty() && st.peek()>0 && curr<0){
        //             if(st.peek()==-curr){
        //                 st.pop();
        //                 break;
        //             }
        //             int bigger = Math.max(st.peek(),Math.abs(curr));
        //             if(st.peek()==bigger)
        //             break;
        //             else{
        //                 st.pop();
        //             }
        //         }
        //     }
        // }
        // int ans[] = new int[st.size()];
        // for(int i = st.size()-1;i>=0;i--){
        //     ans[i] = st.pop();
        // }
        // return ans;
        Stack<Integer> st=new Stack<>();
        
        for(int num:asteroids){
            int n=1;
            while(!st.isEmpty() && num<0 && st.peek()>0){
                if(st.peek()<Math.abs(num)){
                    st.pop();
                    continue;
                }
                else if(Math.abs(num)==st.peek()){
                    st.pop();
                }
                n=0;
                break;
            }
            if(n!=0){
                st.push(num);
            }
        }
        int[] ans=new int[st.size()];
        int i=ans.length-1;
        while(!st.isEmpty()){
            ans[i--]=st.pop();
        }
        return ans;
    }
}