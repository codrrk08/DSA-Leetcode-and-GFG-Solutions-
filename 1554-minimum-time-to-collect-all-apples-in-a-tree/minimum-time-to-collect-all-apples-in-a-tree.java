class Solution {
    int ans = 0;
    public boolean helper(ArrayList<ArrayList<Integer>> adj, List<Boolean> hasApple,int index, boolean vis[]){
        vis[index] = true;
        boolean hasAppleInSubtree = false;

        for(int v:adj.get(index)){
            if(!vis[v]){
                if(helper(adj,hasApple,v,vis)){
                    ans+=2;
                    hasAppleInSubtree = true;
                }
            }
        }
        return hasAppleInSubtree || hasApple.get(index);

    }
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
        for(int i = 0;i<n;i++){
            adj.add(new ArrayList<Integer>());
        }
        for(int edge[]:edges){
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        boolean vis[] = new boolean[n];
        Arrays.fill(vis,false);
        helper(adj,hasApple,0,vis);
        return ans;

    }
}