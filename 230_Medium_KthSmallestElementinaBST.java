/*
Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.

Note: 
You may assume k is always valid, 1 ≤ k ≤ BST's total elements.

Follow up:
What if the BST is modified (insert/delete operations) often and you need to find the kth smallest frequently? How would you optimize the kthSmallest routine?

Hint:

Try to utilize the property of a BST.
What if you could modify the BST node's structure?
The optimal runtime complexity is O(height of BST).
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
    int re;
    boolean find;
    int index;
    public int kthSmallest(TreeNode root, int k) {
        find = false;
        index = 0;
        dfs(root,k);
        return re;
    }
    
    void dfs(TreeNode node, int k){
        if(node == null || find){
            return;
        }
        else{
            dfs(node.left,k);
            if(find){
                return;
            }
            if(index+1==k){
                re = node.val;
                find = true;
                return;
            }
            index++;
            dfs(node.right,k);
        }
    }
}
