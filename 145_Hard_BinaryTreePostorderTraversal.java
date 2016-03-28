/*
Given a binary tree, return the postorder traversal of its nodes' values.

For example:
Given binary tree {1,#,2,3},
   1
    \
     2
    /
   3
return [3,2,1].
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
    public List<Integer> postorderTraversal(TreeNode root) {
        List re = new ArrayList();
        post(root,re);
        return re;
    }
    
    void post(TreeNode node, List re){
        if(node != null){
            post(node.left,re);
            post(node.right,re);
            re.add(node.val);
        }
    }
}
