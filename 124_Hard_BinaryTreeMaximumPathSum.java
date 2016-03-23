/*
Given a binary tree, find the maximum path sum.

For this problem, a path is defined as any sequence of nodes from some starting node to any node in the tree along the parent-child connections. The path does not need to go through the root.

For example:
Given the below binary tree,

       1
      / \
     2   3
Return 6.
*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    int sum;
    public int maxPathSum(TreeNode root) {
        sum = Integer.MIN_VALUE;
        myMax(root);
        return sum;
    }
    
    public int myMax(TreeNode node){
        if(node == null){
            return 0;
        }
        int left = myMax(node.left);
        int right = myMax(node.right);
        int localMax = node.val;
        if(left > 0) localMax += left;
        if(right > 0) localMax += right;
        if(sum < localMax) sum = localMax;
        return Math.max(node.val,Math.max(node.val+left,node.val+right));
    }
}
