/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> ans = new ArrayList<>();
        if (root == null)
            return ans;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            int levelSize = q.size();
            ArrayList<Integer> currLevelItems = new ArrayList<>(levelSize);

            for (int i = 0; i < levelSize; i++) {
                TreeNode currNode = q.poll();
                currLevelItems.add(currNode.val);
                if (currNode.left != null)
                    q.offer(currNode.left);
                if (currNode.right != null)
                    q.offer(currNode.right);
            }

            double sum = 0;
            for (int items : currLevelItems) {
                sum += items;
            }
            ans.add( (sum / currLevelItems.size()));
        }
        return ans;

    }
}