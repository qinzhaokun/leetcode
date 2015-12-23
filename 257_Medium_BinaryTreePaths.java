/*
Given a binary tree, return all root-to-leaf paths.

For example, given the following binary tree:

   1
 /   \
2     3
 \
  5
All root-to-leaf paths are:

["1->2->5", "1->3"]
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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> re = new ArrayList<>();
        if(root == null){
            
        }
        else if(root.left == null && root.right == null){
            re.add(String.valueOf(root.val));
        }
        else{
            if(root.left != null){
              dfs(root.left,re,String.valueOf(root.val));  
            }
            if(root.right != null){
              dfs(root.right,re,String.valueOf(root.val));  
            }
            
        }
        return re;
    }
    
    void dfs(TreeNode node, List<String> re, String tmp){
        tmp += ("->"+String.valueOf(node.val));
        if(node.left == null && node.right == null){
            re.add(tmp);
            return;
            
        }
        if(node.left != null){
            dfs(node.left,re,tmp);
        }
        if(node.right != null){
            dfs(node.right,re,tmp);
        }
    }
}
