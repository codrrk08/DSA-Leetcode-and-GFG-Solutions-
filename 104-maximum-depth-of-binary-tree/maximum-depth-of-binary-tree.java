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
    public int answer(TreeNode node,int count){
        if(node==null)
        return count;

        count++;
        int maxCount = Math.max(answer(node.left,count),answer(node.right,count));

        return maxCount;
    }
    public int maxDepth(TreeNode root) {
        TreeNode node = root;
        return answer(node,0);
    }
}