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
    List<String> ans = new ArrayList<>();
    public void answer(TreeNode node,List<Integer> list){
        if(node==null){
            return;
        }

        list.add(node.val);
        if(node.left==null && node.right==null){
            String s = "";
            for(int i = 0;i<list.size();i++){
                if(i<list.size()-1)
                s+=String.valueOf(list.get(i))+"->";
                else
                s+=String.valueOf(list.get(i));
            }
            ans.add(s);
        }
        else{
            answer(node.left,list);
            answer(node.right,list);
        }
        list.remove(list.size()-1);
    }
    public List<String> binaryTreePaths(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        answer(root,list);
        return ans;
    }
}