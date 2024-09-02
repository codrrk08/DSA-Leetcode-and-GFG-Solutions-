/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    class Tuple{
        TreeNode node;
        int row;
        int col;
        public Tuple(TreeNode node,int row,int col){
            this.node = node;
            this.row = row;
            this.col = col;
        }
    }
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        TreeMap<Integer,TreeMap<Integer,PriorityQueue<Integer>>> mapOfVerticals = new TreeMap<>();
        Queue<Tuple> q = new LinkedList<>();
        q.offer(new Tuple(root,0,0));
        while(!q.isEmpty()){
            Tuple t = q.poll();
            TreeNode currNode = t.node;
            int currCol = t.col;
            int currRow = t.row;

            if(!mapOfVerticals.containsKey(currCol)){
                mapOfVerticals.put(currCol,new TreeMap<>());
            }
            if(!mapOfVerticals.get(currCol).containsKey(currRow)){
                mapOfVerticals.get(currCol).put(currRow,new PriorityQueue<>());
            }
            mapOfVerticals.get(currCol).get(currRow).offer(currNode.val);

            if(currNode.left!=null){
                q.offer(new Tuple(currNode.left,currRow+1,currCol-1));
            }
            if(currNode.right!=null){
                q.offer(new Tuple(currNode.right,currRow+1,currCol+1));
            }
        }

        List<List<Integer>> ans = new ArrayList<>();
        for (TreeMap<Integer, PriorityQueue<Integer>> map : mapOfVerticals.values()) {
            List<Integer> vertical = new ArrayList<>();
            for (PriorityQueue<Integer> pq : map.values()) {
                while (!pq.isEmpty()) {
                    vertical.add(pq.poll());
                }
            }
            ans.add(vertical);
        }

        return ans;
    }
}