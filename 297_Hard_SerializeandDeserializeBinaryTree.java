/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> q = new LinkedList();
        q.offer(root);
        while(!q.isEmpty()){
            TreeNode node = (TreeNode)q.poll();
            if(node == null) sb.append("# ");
            else{
                sb.append(node.val+" ");
                q.offer(node.left);
                q.offer(node.right);
            }
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String [] s = data.split(" ");
        Queue<TreeNode> q = new LinkedList();
        int i = 0;
        TreeNode root;
        if(s[i].equals("#")) root = null;
        else root = new TreeNode(Integer.valueOf(s[i]));
        q.offer(root);
        i++;
        while(!q.isEmpty()){
            TreeNode node = (TreeNode)q.poll();
            if(node == null) continue;
            else{
                node.left = s[i++].equals("#") ? null : new TreeNode(Integer.valueOf(s[i-1]));
                node.right = s[i++].equals("#") ? null : new TreeNode(Integer.valueOf(s[i-1]));
                q.offer(node.left);
                q.offer(node.right);
            }
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
