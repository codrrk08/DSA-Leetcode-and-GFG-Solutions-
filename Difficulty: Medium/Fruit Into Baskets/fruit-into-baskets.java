//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t;
        t = sc.nextInt();
        sc.nextLine(); // Consume the newline character

        while (t-- > 0) {
            String line = sc.nextLine();
            String[] tokens = line.split(" ");

            // Create an ArrayList to store the integers
            ArrayList<Integer> array = new ArrayList<>();

            // Parse the tokens into integers and add to the array
            for (String token : tokens) {
                array.add(Integer.parseInt(token));
            }

            // Convert ArrayList to array
            Integer[] arr = new Integer[array.size()];
            array.toArray(arr);

            Solution ob = new Solution();

            // Call totalFruits method and print result
            Integer ans = ob.totalFruits(arr);
            System.out.println(ans);
        }
        sc.close();
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public static int totalFruits(Integer[] arr) {
        int l = 0;
        int r = 0;
        int maxfruit = 0;
        HashMap<Integer,Integer> hm = new HashMap<>();
        int N = arr.length;
        while(r<N){
            hm.put(arr[r],hm.getOrDefault(arr[r],0)+1);
            if(hm.size()<=2){
                maxfruit = Math.max(maxfruit,r-l+1);
            }
            else{
                // while(hm.size()>2){
                //     hm.put(fruits[l],hm.get(fruits[l])-1);
                //     if(hm.get(fruits[l])==0)
                //     hm.remove(fruits[l]);
                //     l++;
                // }
                hm.put(arr[l],hm.get(arr[l])-1);
                if(hm.get(arr[l])==0)
                hm.remove(arr[l]);
                l++;

            }
            r++;
        }
        return maxfruit;
    }
}