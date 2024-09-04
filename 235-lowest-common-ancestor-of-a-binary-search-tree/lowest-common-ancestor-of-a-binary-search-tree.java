/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null)
        return null;

        if(root.val==p.val || root.val==q.val)
        return root;

        TreeNode findLeft = lowestCommonAncestor(root.left,p,q);
        TreeNode findRight = lowestCommonAncestor(root.right,p,q);

        if(findLeft!=null && findRight!=null)
        return root;

        return findLeft==null?findRight:findLeft;
    }
}