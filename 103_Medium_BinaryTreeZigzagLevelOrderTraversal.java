/*
Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).

For example:
Given binary tree {3,9,20,#,#,15,7},
    3
   / \
  9  20
    /  \
   15   7
return its zigzag level order traversal as:
[
  [3],
  [20,9],
  [15,7]
]
confused what "{1,#,2,3}" means?
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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        List<List<Integer>> re = new ArrayList<>();
        if(root != null){
            stack1.add(root);
        }
        while(!stack1.isEmpty() || !stack2.isEmpty()){
            if(!stack1.isEmpty()){
                List<Integer> tmp = new ArrayList<>();
                while(!stack1.isEmpty()){
                    TreeNode node = (TreeNode)stack1.pop();
                    tmp.add(node.val);
                    if(node.left != null){
                        stack2.push(node.left);
                    }
                    if(node.right != null){
                        stack2.push(node.right);
                    }
                }
                re.add(tmp);
            }
            else{
                List<Integer> tmp = new ArrayList<>();
                while(!stack2.isEmpty()){
                    TreeNode node = (TreeNode)stack2.pop();
                    tmp.add(node.val);
                    if(node.right != null){
                        stack1.push(node.right);
                    }
                    if(node.left != null){
                        stack1.push(node.left);
                    }
                }
                re.add(tmp);
            }
        }
        return re;
    }
}
