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
    int max = 0;
    public int dfsMaxSumBetweenSubTrees(TreeNode node){
        if(node==null)
        return 0;

        int heightLeftSubtree = dfsMaxSumBetweenSubTrees(node.left);
        int heightRightSubtree = dfsMaxSumBetweenSubTrees(node.right);
        // int max = 0;
        max = Math.max(max,heightLeftSubtree + heightRightSubtree); //max diameter b/w the current left and right subtrees

        return Math.max(heightLeftSubtree,heightRightSubtree) + 1;  //return height of the current tree
    }
    public int diameterOfBinaryTree(TreeNode root) {
        dfsMaxSumBetweenSubTrees(root);
        return max;
    }
}