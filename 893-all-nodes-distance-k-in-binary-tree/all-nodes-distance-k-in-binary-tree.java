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
    private void markPresent(TreeNode root,HashMap<TreeNode,TreeNode> parentM,TreeNode target){
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            TreeNode curr = q.poll();
            if(curr.left!=null){
                parentM.put(curr.left,curr);
                q.offer(curr.left);
            }
            if(curr.right!=null){
                parentM.put(curr.right,curr);
                q.offer(curr.right);
            }
        }
    }
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        HashMap<TreeNode,TreeNode> parentM = new HashMap<>();
        markPresent(root,parentM,target);
        Map<TreeNode,Boolean> visited = new HashMap<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(target);  //start from the target node 
        visited.put(target,true);
        int currLevel = 0;
        while(!q.isEmpty()){
            int size = q.size();
            if(currLevel==k)break;
            currLevel++;
            for(int i = 0;i<size;i++){
                TreeNode currNode = q.poll();
                if(currNode.left!=null && visited.get(currNode.left)==null){
                    q.offer(currNode.left);
                    visited.put(currNode.left,true);
                }
                if(currNode.right!=null && visited.get(currNode.right)==null){
                    q.offer(currNode.right);
                    visited.put(currNode.right,true);
                }
                if(parentM.get(currNode)!=null && visited.get(parentM.get(currNode))==null){
                    q.offer(parentM.get(currNode));
                    visited.put(parentM.get(currNode),true);
                }
            }
        }
        List<Integer> ans = new ArrayList<>();
        while(!q.isEmpty()){
            ans.add(q.poll().val);
        }
        return ans;
    }
}