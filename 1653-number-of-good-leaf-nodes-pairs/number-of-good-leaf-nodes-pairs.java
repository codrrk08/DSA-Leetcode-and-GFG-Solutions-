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
    // int count = 0;
    public ArrayList<Integer> findLeafNodes(TreeNode root,int dist,int count[]){
        if(root==null)
        return new ArrayList<>();
        if(root.left==null && root.right==null){
            ArrayList<Integer> list = new ArrayList<>();
            list.add(1);
            return list;
        }

        ArrayList<Integer> leftNodes = findLeafNodes(root.left,dist,count);
        ArrayList<Integer> rightNodes = findLeafNodes(root.right,dist,count);

        for(int left:leftNodes){
            for(int right:rightNodes){
                if(left+right<=dist)
                count[0]++;
            }
        }
        
        ArrayList<Integer> parent = new ArrayList<>();
        for(int left:leftNodes)
        parent.add(left+1);

        for(int right:rightNodes)
        parent.add(right+1);

        return parent;
    }
    public int countPairs(TreeNode root, int distance) {
        List<TreeNode> leafNodes = new ArrayList<>();
        // Integer count = new Integer(0);
        int count[] = new int[1];
        findLeafNodes(root,distance,count);
        return count[0];

    }
}