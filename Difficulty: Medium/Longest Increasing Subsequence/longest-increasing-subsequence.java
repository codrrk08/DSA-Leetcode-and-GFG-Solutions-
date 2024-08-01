//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {

        // taking input using Scanner class
        Scanner sc = new Scanner(System.in);

        // taking total testcases
        int t = sc.nextInt();
        while (t > 0) {

            // taking size of array
            int n = sc.nextInt();
            int array[] = new int[n];

            // inserting elements in the array
            for (int i = 0; i < n; ++i) {
                array[i] = sc.nextInt();
            }

            // creating an object of class Solution
            Solution ob = new Solution();

            // calling longestSubsequence() method of class
            // Solution
            System.out.println(ob.longestSubsequence(n, array));
            t--;
        }
    }
}
// } Driver Code Ends




class Solution {
    // Function to find length of longest increasing subsequence.
    static int longestSubsequence(int n, int a[]) {
        
        ArrayList<Integer> list = new ArrayList<>();
        int prev =0;
        for(int i =0 ;i<n;i++){
            if(i==0)
            list.add(a[i]);
            
            if(a[i]>list.get(prev)){
                list.add(a[i]);
                prev++;
            }
            else{
                int ind = Collections.binarySearch(list,a[i]);
                if(ind<0){
                    ind = -ind-1;
                }
                list.set(ind,a[i]);
            }
        }
        return list.size();
        
        
    }
}