//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {

            int N;
            N = sc.nextInt();

            int[] asteroids = new int[N];
            for (int i = 0; i < N; i++) asteroids[i] = sc.nextInt();

            Solution obj = new Solution();
            int[] res = obj.asteroidCollision(N, asteroids);

            for (int e : res) System.out.print(e + " ");
            System.out.println();
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public static int[] asteroidCollision(int N, int[] asteroids) {
        Stack<Integer> st = new Stack<>();
        int f=1;
        for(int i = 0; i<N;i++){
            int curr = asteroids[i];
            if(curr>0 || st.isEmpty())
            st.push(curr);
            else{
                f=1;
                while(!st.isEmpty() && st.peek()>0 && curr<0){
                    int bigger = Math.max(st.peek(),Math.abs(curr));
                    if(st.peek()==-curr){
                        st.pop();
                    }
                    else if(st.peek()<bigger){
                        st.pop();
                        continue;
                    }
                    f=0;
                    break;
                }
                if(f==1)
                st.push(curr);
            }
        }
        int ans[] = new int[st.size()];
        for(int i = st.size()-1;i>=0;i--){
            ans[i] = st.pop();
        }
        return ans;
    }
}
