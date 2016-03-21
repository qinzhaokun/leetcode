/*
Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.

For example:
Given the below binary tree and sum = 22,
              5
             / \
            4   8
           /   / \
          11  13  4
         /  \    / \
        7    2  5   1
return
[
   [5,4,11,2],
   [5,8,4,5]
]
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
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List re = new ArrayList();
        List temp = new ArrayList();
        findpath(root,sum,re,temp);
        return re;
    }
    
    public void findpath(TreeNode node,int sum,List re,List temp){
        if(node == null){
            return;
        }
        if(node.left == null && node.right == null && node.val == sum){
            temp.add(node.val);
            re.add(new ArrayList(temp));
            temp.remove(temp.size()-1);
        }
        else{
            temp.add(node.val);
            findpath(node.left,sum-node.val,re,temp);
            findpath(node.right,sum-node.val,re,temp);
            temp.remove(temp.size()-1);
        }
    }
}
