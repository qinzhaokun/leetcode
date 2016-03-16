/*
Given inorder and postorder traversal of a tree, construct the binary tree.

Note:
You may assume that duplicates do not exist in the tree.
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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder.length != postorder.length || inorder.length == 0 || postorder.length == 0){
            return null;
        }
        return build(inorder,postorder,0,inorder.length-1,0,postorder.length-1);
    }
    
    public TreeNode build(int [] in, int [] post, int il, int ir, int pl, int pr){
        if(il > ir || pl > pr){
            return null;
        }
        if(il == ir){
            return new TreeNode(in[il]);
        }
        int i = il;
         for(;i <= ir;i++){
             if(in[i] == post[pr]){
                 break;
             }
         }
         int lenleft = i - il;
         int lenright = ir - i;
         TreeNode node = new TreeNode(post[pr]);
         node.left = build(in,post,il,i-1,pl,pr-lenright-1);
         node.right = build(in,post,i+1,ir,pr-lenright,pr-1);
         return node;
    }
}
