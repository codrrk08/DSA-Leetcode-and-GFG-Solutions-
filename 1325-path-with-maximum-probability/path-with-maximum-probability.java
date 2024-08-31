class Solution {
    class Pair{
        int node;
        double prob;
        public Pair(int node,double prob){
            this.node = node;
            this.prob = prob;
        }
    }
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {

        Map<Integer,List<Pair>> adj = new HashMap<>();
        for(int i = 0;i<n;i++){
            adj.put(i,new ArrayList<>());
        }
        //adjacency list
        for(int i = 0;i<edges.length;i++){
            adj.get(edges[i][0]).add(new Pair(edges[i][1],succProb[i]));
            adj.get(edges[i][1]).add(new Pair(edges[i][0],succProb[i]));
        }
        //we have to pick the node which has the highest probability next
        PriorityQueue<Pair> q = new PriorityQueue<>((a, b) -> Double.compare(b.prob, a.prob));
        double []p = new double[n];
        p[start_node] = 1.0;
        q.add(new Pair(start_node,1.0));
        while(!q.isEmpty()){
            Pair pair = q.poll();
            int currNode = pair.node;
            double currProb = pair.prob;

            if(currNode==end_node)
            return currProb;

            for(Pair edge:adj.get(currNode)){
                int nextVert = edge.node;
                double edgeProb = edge.prob;
                if((currProb*edgeProb) > p[nextVert]){
                    p[nextVert] = currProb*edgeProb;
                    q.add(new Pair(nextVert,p[nextVert]));
                }
            }
        }
        return 0.0;
    }
}