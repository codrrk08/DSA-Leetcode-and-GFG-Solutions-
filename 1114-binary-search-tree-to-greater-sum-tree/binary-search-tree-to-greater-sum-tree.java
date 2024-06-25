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
    // public TreeNode answer(TreeNode root,int sum){
    //     if(root!=null){
    //         answer(root.right,sum);
    //         sum+=root.val;
    //         root.val = sum;
    //         answer(root.left,sum);
    //     }
    //     return root;
    // }
    int sum = 0;
    public TreeNode bstToGst(TreeNode root) {
        // return answer(root,0);
        if(root!=null){
            bstToGst(root.right);
            sum+=root.val;
            root.val = sum;
            bstToGst(root.left);
        }
        return root;
        


    }
}