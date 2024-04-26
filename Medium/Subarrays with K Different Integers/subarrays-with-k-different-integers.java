//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.math.*;
import java.io.*;

class GFG {
  public static void main(String[] args) throws IOException {
    Scanner sc = new Scanner(System.in);
    int T = sc.nextInt();
    while (T-- > 0) {
      int n = sc.nextInt();
      int k = sc.nextInt();
      int a[] = new int[n];
      for(int i=0;i<n;i++){
        a[i]=sc.nextInt();
      }
      Solution obj = new Solution();
      int ans = obj.subarrayCount(a,n,k);
      System.out.println(ans);
    }
  }
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    public static int atMost(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int i = 0, j = 0, n = nums.length, ans = 0;

        while (j < n) {
            map.put(nums[j], map.getOrDefault(nums[j], 0) + 1);
            while (map.size() > k && i <= j) {
                map.put(nums[i], map.get(nums[i]) - 1);
                if (map.get(nums[i]) == 0) map.remove(nums[i]);
                i++;
            }
            ans += (j - i + 1);
            j++;
        }
        return ans;
    }
    static int subarrayCount(int arr[], int N, int k) {
        int ans = atMost(arr, k) - atMost(arr, k - 1);
        return ans;

  }
}
     