//{ Driver Code Starts
// Initial Template for Java
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            ArrayList<ArrayList<Integer>> adj =
                new ArrayList<ArrayList<Integer>>();
            for (int i = 0; i < V; i++) adj.add(new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            Solution obj = new Solution();
            ArrayList<Integer> ans = obj.dfsOfGraph(V, adj);
            for (int i = 0; i < ans.size(); i++)
                System.out.print(ans.get(i) + " ");
            System.out.println();
        }
    }
}

// } Driver Code Ends


class Solution {
    
    public void helper(ArrayList<Integer> dfs,boolean vis[],ArrayList<ArrayList<Integer>> adj,int index){
        
        for(int i = 0;i<adj.get(index).size();i++){
            if(!vis[adj.get(index).get(i)]){
                vis[adj.get(index).get(i)] =true;
                dfs.add(adj.get(index).get(i));
                helper(dfs,vis,adj,adj.get(index).get(i));
            }
        }
        
        return;
    }
    public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> dfs = new ArrayList<>();
        boolean vis[] = new boolean[V+1];
        Arrays.fill(vis,false);
        vis[0] = true;
        dfs.add(0);
        helper(dfs,vis,adj,0);
        return dfs;
    }
}