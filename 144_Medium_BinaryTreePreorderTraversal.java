/*
Given a binary tree, return the preorder traversal of its nodes' values.

For example:
Given binary tree {1,#,2,3},
   1
    \
     2
    /
   3
return [1,2,3].
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
    public List<Integer> preorderTraversal(TreeNode root) {
        List re = new ArrayList();
        pre(root,re);
        return re;
    }
    
    void pre(TreeNode node, List re){
        if(node != null){
            re.add(node.val);
            pre(node.left,re);
            pre(node.right,re);
        }
    }
}
