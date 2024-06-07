//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while (t-- > 0) {

            // taking size of array
            int n = Integer.parseInt(br.readLine().trim());
            int l[] = new int[n];
            int r[] = new int[n];
            String inputLine[] = br.readLine().trim().split(" ");

            // adding elements to array L
            for (int i = 0; i < n; i++) {
                l[i] = Integer.parseInt(inputLine[i]);
            }
            inputLine = br.readLine().trim().split(" ");
            int maxx = Integer.MIN_VALUE;

            // adding elements to array R
            for (int i = 0; i < n; i++) {
                r[i] = Integer.parseInt(inputLine[i]);
                if (r[i] > maxx) {
                    maxx = r[i];
                }
            }

            Solution obj = new Solution();

            // calling maxOccured() function
            System.out.println(obj.maxOccured(n, l, r, maxx));
        }
    }
}


// } Driver Code Ends
// L[] and R[] are input ranges
// n : size of array
// maxx: maximum element in R[]
// arr[]: declared globally with size equal to 1000000

class Solution {
    // Function to find the maximum occurred integer in all ranges.
    public static int maxOccured(int n, int l[], int r[], int maxx) {
        // TreeMap<Integer,Integer> tm = new TreeMap<>();
        // int i = 0;
        // // int j = 0;
        // while(i<l.length){
        //     int start = l[i];
        //     int end = r[i];
        //     for(int j = start;j<=end;j++){
        //         tm.put(j,tm.getOrDefault(j,0)+1);
        //     }
        //     i++;
        // }
        // int maxFreq = Integer.MIN_VALUE;
        // for(int num:tm.values()){
        //     maxFreq = Math.max(maxFreq,num);
        // }
        // int ans=0;
        // for(Map.Entry<Integer,Integer> entry:tm.entrySet()){
        //     if(entry.getValue()==maxFreq){
        //         ans = entry.getKey();
        //         break;
        //     }
        // }
        // return ans;
        TreeMap<Integer, Integer> tm = new TreeMap<>();

        // Use a difference array approach
        for (int i = 0; i < n; i++) {
            int start = l[i];
            int end = r[i] + 1;  // mark end+1 for end of the range
            tm.put(start, tm.getOrDefault(start, 0) + 1);
            tm.put(end, tm.getOrDefault(end, 0) - 1);
        }

        int maxFreq = Integer.MIN_VALUE;
        int currentFreq = 0;
        int ans = 0;

        // Traverse the TreeMap to find the prefix sum and track the maximum frequency
        for (Map.Entry<Integer, Integer> entry : tm.entrySet()) {
            currentFreq += entry.getValue();
            if (currentFreq > maxFreq) {
                maxFreq = currentFreq;
                ans = entry.getKey();
            }
        }

        return ans;
        
        
    }
}

//{ Driver Code Starts.

// } Driver Code Ends