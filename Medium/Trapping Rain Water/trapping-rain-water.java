//{ Driver Code Starts
import java.io.*;
import java.util.*;
import java.lang.*;


class Array {

	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim()); //Inputting the testcases
		while(t-->0){
		  
		    //size of array
		    int n = Integer.parseInt(br.readLine().trim());
		    int arr[] = new int[n];
		    String inputLine[] = br.readLine().trim().split(" ");
		    
		    //adding elements to the array
		    for(int i=0; i<n; i++){
		        arr[i] = Integer.parseInt(inputLine[i]);
		    }
		    
		    Solution obj = new Solution();
		    
		    //calling trappingWater() function
		    System.out.println(obj.trappingWater(arr, n));
		}
	}
}


// } Driver Code Ends


class Solution{
    
    // arr: input array
    // n: size of array
    // Function to find the trapped water between the blocks.
    static long trappingWater(int arr[], int n) { 
        if(n<=2){
            return 0;
        }
       
       Long[] left = new Long[n];
       Long[] right = new Long[n];
       left[0]=0l;
       right[n-1]=0l;
       
       long leftMax = arr[0];
       
       //store left max for each bar
       
       for(int i=1;i<n;i++){
           left[i]=leftMax;
           leftMax = Math.max(leftMax,arr[i]);
       }
       
       long rightMax = arr[n-1];
       
       // store right max for each bar
       
       for(int i=n-2;i>=0;--i){
           right[i] = rightMax;
           rightMax = Math.max(rightMax, arr[i]);
       }
       
       //now trap water
       long trappedWater = 0;
       
       for(int i=1;i<n-1;i++){
           
           if(arr[i]<left[i] && arr[i]<right[i]){
               trappedWater+=Math.min(left[i],right[i])-arr[i];
           }
           
       }
     
     
      return trappedWater;
    } 
}


