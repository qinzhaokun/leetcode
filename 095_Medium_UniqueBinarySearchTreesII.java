/*
Given n, generate all structurally unique BST's (binary search trees) that store values 1...n.

For example,
Given n = 3, your program should return all 5 unique BST's shown below.

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3
confused what "{1,#,2,3}" means? > read more on how binary tree is serialized on OJ.

Subscribe to see which companies asked this question
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
    public List<TreeNode> generateTrees(int n) {
        return gen(1,n);
    }
    
    List<TreeNode> gen(int left, int right){
        List<TreeNode> re = new ArrayList<>();
        for(int i = left;i <= right;i++){
            List leftTree = gen(left,i-1);
            List rightTree = gen(i+1,right);
            if(leftTree.size() == 0 && rightTree.size() != 0){
                for(int j = 0;j < rightTree.size();j++){
                    TreeNode node = new TreeNode(i);
                    node.left = null;
                    node.right = (TreeNode)rightTree.get(j);
                    re.add(node);
                }
            }
            else if(leftTree.size() != 0 && rightTree.size() == 0){
                for(int k = 0;k < leftTree.size();k++){
                    TreeNode node = new TreeNode(i);
                    node.left = (TreeNode)leftTree.get(k);;
                    node.right = null;
                    re.add(node);
                }
            }
            else if(leftTree.size() == 0 && rightTree.size() == 0){
                re.add(new TreeNode(i));
            }
            else{
               for(int k = 0;k < leftTree.size();k++){
                for(int j = 0;j < rightTree.size();j++){
                    TreeNode node = new TreeNode(i);
                    node.left = (TreeNode)leftTree.get(k);
                    node.right = (TreeNode)rightTree.get(j);
                    re.add(node);
                }
               } 
            }
            
        }
        return re;
    }
}
