/*
Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.

An example is the root-to-leaf path 1->2->3 which represents the number 123.

Find the total sum of all root-to-leaf numbers.

For example,

    1
   / \
  2   3
The root-to-leaf path 1->2 represents the number 12.
The root-to-leaf path 1->3 represents the number 13.

Return the sum = 12 + 13 = 25.
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
    int sum = 0;
    public int sumNumbers(TreeNode root) {
        if(root == null){
            return 0;
        }
        sum = 0;
        in(root,0);
        return sum;
    }
    
    public void in(TreeNode node,int now){
        if(node.left == null && node.right == null){ sum += (10*now+node.val);}
        else{
            if(node.left != null) {in(node.left,10*now+node.val);}
            if(node.right != null) {in(node.right,10*now+node.val);}
        }
    }
}
