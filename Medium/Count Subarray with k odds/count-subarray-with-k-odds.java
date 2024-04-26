//{ Driver Code Starts
import java.io.*;
import java.util.*;


class IntArray
{
    public static int[] input(BufferedReader br, int n) throws IOException
    {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for(int i = 0; i < n; i++)
            a[i] = Integer.parseInt(s[i]);

        return a;
    }

    public static void print(int[] a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }

    public static void print(ArrayList<Integer> a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            int n;
            n = Integer.parseInt(br.readLine());
            
            
            int[] nums = IntArray.input(br, n);
            
            
            int k;
            k = Integer.parseInt(br.readLine());
            
            Solution obj = new Solution();
            int res = obj.countSubarray(n, nums, k);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends


class Solution {
    public static int fun(int[] nums, int k) {
        if(k<0) return 0;
        int j=0,ans=0,sum=0;

        for(int i=0;i<nums.length;i++){
            if(nums[i]%2==1)
            sum+=1;
            else
            sum+=0;

            while(sum>k){
                if(nums[j]%2==1)
                sum-=1;
                j++;
            }

            ans+=(i-j+1);

        }
        return ans;
    }
    public static int countSubarray(int n, int[] nums, int k) {
        return fun(nums,k)-fun(nums,k-1);
    }
}
        
