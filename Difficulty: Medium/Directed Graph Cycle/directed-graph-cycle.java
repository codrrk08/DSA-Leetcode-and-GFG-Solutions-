//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class DriverClass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            int V = sc.nextInt();
            int E = sc.nextInt();
            for (int i = 0; i < V; i++)
                list.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                list.get(u).add(v);
            }
            if (new Solution().isCyclic(V, list) == true)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
}
// } Driver Code Ends


/*Complete the function below*/

class Solution {
    // Function to detect cycle in a directed graph.
    public boolean check( ArrayList<ArrayList<Integer>> adj,int vis[],int pathVis[],int index){
        
        vis[index] = 1;
        pathVis[index] = 1;
        
        for(int n:adj.get(index)){
            if(vis[n]==0){
                if(check(adj,vis,pathVis,n))
                return true;
            }
            else if(pathVis[n]==1)
            return true;
            
        }
        pathVis[index] = 0;
        return false;
    }
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        int vis[] = new int[V];
        int pathVis[] = new int[V];
        // vis[0] = 1;
        // pathVis[0] = 1;
        for(int i = 0;i<V;i++){
            if(vis[i]==0){
                if(check(adj,vis,pathVis,i))
                return true;
            }
        }
        return false;
    }
}