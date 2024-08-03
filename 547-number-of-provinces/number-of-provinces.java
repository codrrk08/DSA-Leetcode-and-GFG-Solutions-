class Solution {
    public void dfs(int node,ArrayList<ArrayList<Integer>> adj,int vis[]){
        
        vis[node] = 1;

        for(int n:adj.get(node)){
            if(vis[n]!=1){
                dfs(n,adj,vis);
            }
        }

        return;
    }
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
        for(int i = 0;i<n;i++){
            adj.add(new ArrayList<Integer>());
        }

        //adjacency list
        for(int i = 0;i<n;i++){
            for(int j = 0;j<n;j++){
                if(isConnected[i][j]==1 && i!=j){
                    adj.get(i).add(j);
                    adj.get(j).add(i);
                }
            }
        }
        int vis[] = new int[n];
        Arrays.fill(vis,0);
        int count= 0;
        for(int i = 0;i<n;i++){
            if(vis[i]==0){
                dfs(i,adj,vis);
                count++;
            }
        }
        return count;
    }
}