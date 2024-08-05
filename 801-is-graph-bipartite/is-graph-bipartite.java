class Solution {
    public boolean check(int graph[][],int start,int color[]){
        int n = graph.length;
        // int m = graph[0].length;
        Queue<Integer> q = new LinkedList<>();
        // int color = 0;
        q.offer(start);
        color[start] = 0;
        while(!q.isEmpty()){
            int node = q.peek();
            q.poll();
            for(int x:graph[node]){
                if(color[x]==-1){
                    color[x] = Math.abs(color[node]-1);
                    q.offer(x);
                }
                else if(color[x]==color[node])
                return false;
            }
        }
        return true;
    }
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        // int m = graph[0].length;
        int color[] = new int[n];
        Arrays.fill(color,-1);
        for(int i = 0;i<n;i++){
            if(color[i]==-1){
                if(!check(graph,i,color))
                return false;
            }
        }
        return true;
    }
}