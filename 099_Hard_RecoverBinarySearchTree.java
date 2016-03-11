/*
Two elements of a binary search tree (BST) are swapped by mistake.

Recover the tree without changing its structure.

Note:
A solution using O(n) space is pretty straight forward. Could you devise a constant space solution?
confused what "{1,#,2,3}" means? > read more on how binary tree is serialized on OJ.
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
    TreeNode pre;
    TreeNode n1;
    TreeNode n2;
    public void recoverTree(TreeNode root) {
        pre = null;
        n1 = null;
        n2 = null;
        inOrder(root);
        if(n1 != null && n2 != null){
            int tmp = n1.val;
            n1.val = n2.val;
            n2.val = tmp;
        }
    }
    
    void inOrder(TreeNode node){
        if(node != null){
            inOrder(node.left);
            if(pre != null){
                if(node.val < pre.val){
                    if(n1 == null){
                        n1 = pre;
                        n2 = node;
                    }
                    else{
                        n2 = node;
                    }
                }
            }
            pre = node;
            inOrder(node.right);
        }
    }
}
