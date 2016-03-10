/*
Given a binary tree, determine if it is a valid binary search tree (BST).

Assume a BST is defined as follows:

The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.
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
 
 //recursive
public class Solution {
    public boolean isValidBST(TreeNode root) {
        if(root == null){
            return true;
        }
        else{
            return isV(root,Long.MIN_VALUE,Long.MAX_VALUE);
        }
    }
    
    boolean isV(TreeNode node, long min, long max){
        if(node.val <= min || node.val >= max){
            return false;
        }
        
        if(node.left != null){
            if(!isV(node.left,min, Math.min(max,node.val))){
                return false;
            }
        }
        if(node.right != null){
            if(!isV(node.right,Math.max(min,node.val),max)){
                return false;
            } 
        }
        return true;
    }
}

//inOrder
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
    public boolean isValidBST(TreeNode root) {
        //must use <Integer>, because we need compare with two int.
     List<Integer> re = new ArrayList<Integer>();
     inOrder(root,re);
     for(int i = 1;i < re.size();i++){
         if(re.get(i)<=re.get(i-1)){
             return false;
         }
     }
     return true;
    }
    
    void inOrder(TreeNode root,List re){
        if(root != null){
            inOrder(root.left,re);
            re.add(root.val);
            inOrder(root.right,re);
        }
    }
}
