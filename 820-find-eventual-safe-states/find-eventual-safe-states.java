class Solution {
    private boolean dfsCheck(int node, ArrayList<ArrayList<Integer>> adj, int vis[], 
    int pathVis[], int check[]) {
        vis[node] = 1;
        pathVis[node] = 1;
        check[node] = 0;
        // traverse for adjacent nodes
        for (int it : adj.get(node)) {
            // when the node is not visited
            if (vis[it] == 0) {
                if (dfsCheck(it, adj, vis, pathVis, check) == true)
                    return true;
            }
            // if the node has been previously visited
            // but it has to be visited on the same path
            else if (pathVis[it] == 1) {
                return true;
            }
        }
        check[node] = 1;
        pathVis[node] = 0;
        return false;
    }

    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        // int term[] = new int[n];
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
        for(int i = 0;i<n;i++){
            adj.add(new ArrayList<Integer>());
        }
        for(int i = 0;i<n;i++){
            for(int x:graph[i]){
                adj.get(i).add(x);
            }
        }
        // System.out.println(adj);
        int vis[] = new int[n];
        int pathVis[] = new int[n];
        int check[] = new int[n];
        for (int i = 0; i < n; i++) {
            if (vis[i] == 0) {
                dfsCheck(i, adj, vis, pathVis, check);
            }
        }
        List<Integer> safeNodes = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (check[i] == 1)
                safeNodes.add(i);
        }
        return safeNodes;
    }
}