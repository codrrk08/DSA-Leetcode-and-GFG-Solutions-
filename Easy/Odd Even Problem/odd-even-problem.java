//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            String s;
            s = br.readLine();

            Solution obj = new Solution();
            String res = obj.oddEven(s);

            System.out.println(res);
        }
    }
}

// } Driver Code Ends



class Solution {
    public static String oddEven(String s) {
        HashMap<Integer,Integer> map=new HashMap<>();
        int odd=0,even=0,n=s.length();
        for(int i=0;i<n;i++)
        {
            char ch=s.charAt(i);
            int x=ch-'a'+1;  
            map.put(x,map.getOrDefault(x,0)+1);
        }
        for(Integer key:map.keySet())
        {
            if(key%2==0 && (map.get(key))%2==0)
            {
                even++;
            }
            else if(key%2!=0 && (map.get(key)%2!=0))
            {
                odd++;
            }
        }
        int sum=odd+even;
        if(sum%2==0)
        {
            return "EVEN";
        }
        return "ODD";
    }
}
