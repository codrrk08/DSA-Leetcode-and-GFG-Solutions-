/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
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
    public boolean check(ListNode curr,TreeNode root){
        // if(root==null)
        // return false;
        // if(curr==null)
        // return true;

        // if(root.val==curr.val){
        //     if(curr.next==null)
        //     return true;
        //     curr = curr.next;
        //     // if(curr==null)
        //     // return true;
        // }
        // else
        // return false;

        // boolean left = check(head,root.left,curr);
        // boolean right = check(head,root.right,curr);

        // if(left||right)
        // return true;

        // curr = head;
        // return false;
         if (curr == null) return true;  // End of linked list means match found
        if (root == null) return false; // Reached the end of a tree branch without matching
        
        // Check if current values match and continue to both left and right subtrees
        if (root.val == curr.val) {
            return check(curr.next, root.left) || check(curr.next, root.right);
        }

        return false; // If current values don't match, return  false
    }
    public boolean isSubPath(ListNode head, TreeNode root) {
        // ListNode curr = head;
        // return check(head,root,curr);
        if (root == null) return false; // Base case: reached end of the tree
    
    // Check if there's a matching path from the current tree node or any of its children
        return check(head, root) || isSubPath(head, root.left) || isSubPath(head, root.right);
    }
}