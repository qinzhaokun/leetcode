/*
Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.

According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes v and w as the lowest node in T that has both v and w as descendants (where we allow a node to be a descendant of itself).”

        _______3______
       /              \
    ___5__          ___1__
   /      \        /      \
   6      _2       0       8
         /  \
         7   4
For example, the lowest common ancestor (LCA) of nodes 5 and 1 is 3. Another example is LCA of nodes 5 and 4 is 5, since a node can be a descendant of itself according to the LCA definition.
*/

//Solution1: find a Path from root to p, and find a Path from root to q, find the first different treenode.

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 //find path from root to p and q
public class Solution {
    boolean finded;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> listP = new ArrayList<>();
        List<TreeNode> listQ = new ArrayList<>();
        finded = false;
        searchPath(root,listP,p);
        finded = false;
        searchPath(root,listQ,q);
        int i = 0;
        TreeNode re = root;
        while(i < listP.size() && i < listQ.size()){
            if(!listP.get(i).equals(listQ.get(i))){
                return i==0?listP.get(0):listP.get(i-1);
            }
            i++;
        }
        return listP.size() < listQ.size()?listP.get(i-1):listQ.get(i-1);
    }
    
    public void searchPath(TreeNode node, List list, TreeNode target){
        if(node == null || finded){
            return;
        }
        list.add(node);
        if(node.equals(target)){
            finded = true;
            return;
        }
        searchPath(node.left,list,target);
        if(finded){
            return;
        }
        searchPath(node.right,list,target);
        if(finded){
            return;
        }
        list.remove(list.size()-1);
    }
}


//Solution2: Recursive
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 
//节点p与节点q的公共祖先root一定满足：p与q分别出现在root的左右子树上（如果p或者q本身不是祖先的话）
public class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null){
            return null;
        }
        if(root.equals(p) || root.equals(q)){
            //表示找到了p或q
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if(left != null && right != null){
            return root;
        }
        else{
            return left == null ? right:left;
        }
    }
}
