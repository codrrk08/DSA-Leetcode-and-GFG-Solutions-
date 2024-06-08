//{ Driver Code Starts
import java.util.*;

class ExtraElement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] a = new int[n];
            int[] b = new int[n - 1];
            for (int i = 0; i < n; i++) a[i] = sc.nextInt();
            for (int i = 0; i < n - 1; i++) b[i] = sc.nextInt();
            Solution g = new Solution();
            System.out.println(g.findExtra(n, a, b));
        }
    }
}
// } Driver Code Ends


/*Complete the function below*/
class Solution {
    public int findExtra(int n, int arr1[], int arr2[]) {
         int min = Math.min(arr1.length, arr2.length);
        for(int i = 0; i < min; i++) {
            if(arr1[i] != arr2[i]) return i;
        }
        
        if(arr1.length > arr2.length) return arr1.length - 1;
        
        return arr2.length - 1;
        // int i= 0;
        // int j = arr1.length-1;
        // // int k = arr2.length-1;
        // int mid = 0;
        // while(i<j){
        //     mid = (i+j)/2;
        //     // int mid2 = (i+k)/2;
        //     if(arr1[mid]==arr2[mid])
        //     i=mid;
        //     else
        //     break;
        // }
        // return mid;
    }
}