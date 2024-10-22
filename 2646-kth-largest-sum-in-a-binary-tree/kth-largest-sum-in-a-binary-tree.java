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
    public long kthLargestLevelSum(TreeNode root, int k) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        PriorityQueue<Long> pq = new PriorityQueue<>(Collections.reverseOrder());
        while(!q.isEmpty()){
            long sum = 0;
            int size = q.size();
            for(int i = 0;i<size;i++){
                TreeNode curr = q.poll();
                sum+=curr.val;
                if(curr.left!=null){
                    q.offer(curr.left);
                }
                if(curr.right!=null){
                    q.offer(curr.right);
                }
            }
            pq.offer(sum);
        }
        long ans = -1;
        if(k>pq.size())
        return -1;
        while(k!=0 && !pq.isEmpty()){
            ans = pq.poll();
            k--;
        }
        return ans;

    }
}