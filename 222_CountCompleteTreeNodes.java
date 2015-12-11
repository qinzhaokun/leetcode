/*
Given a complete binary tree, count the number of nodes.

Definition of a complete binary tree from Wikipedia:
In a complete binary tree every level, except possibly the last, is completely filled, and all nodes in the last level are as far left as possible. It can have between 1 and 2h nodes inclusive at the last level h.
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
    static int c = 0;
    public int countNodes(TreeNode root) {
        if(root == null){
            return 0;
        }
        int left = 0;
        int right = 0;
        TreeNode cur = root;
        while(cur != null){
            cur = cur.left;
            left++;
        }
        cur = root;
        while(cur != null){
            cur = cur.right;
            right++;
        }
        if(left == right){
            return (2 << (left-1)) -1;
        }
        else{
            return countNodes(root.left) + countNodes(root.right) + 1;
        }
    }
    
}
