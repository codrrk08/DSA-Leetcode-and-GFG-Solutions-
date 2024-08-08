//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int m=sc.nextInt();
            int[][] edge = new int[m][2];
            for(int i=0;i<m;i++){
                edge[i][0]=sc.nextInt();
                edge[i][1]=sc.nextInt();
            }
            int src=sc.nextInt();
            Solution obj = new Solution();
            int res[] = obj.shortestPath(edge,n,m,src);
            for(int i=0;i<n;i++){
                System.out.print(res[i]+" ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends


class Solution {
    class Pair{
        int vertex;
        int weight;
        public Pair(int k,int v){
            this.vertex = k;
            this.weight = v;
        }
    }
    public int[] shortestPath(int[][] edges,int n,int m ,int src) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int edge[]:edges){
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        // System.out.println(adj.toString());
        Queue<Pair> q =  new LinkedList<>();
        q.add(new Pair(src,0));
        int dist[] = new int[n];
        Arrays.fill(dist,(int)1e9);
        dist[src] = 0;
        while(!q.isEmpty()){
            int node = q.peek().vertex;
            int d = q.peek().weight;
            q.poll();
            for(int edge:adj.get(node)){
                if(d+1<dist[edge]){
                    dist[edge] = d+1;
                    q.offer(new Pair(edge,dist[edge]));
                }
            }
        }
        for(int i =0 ;i<n;i++){
            if(dist[i]==(int)(1e9)){
                dist[i]=-1;
            }
        }
        return dist;
        
    }
}