/*
Given a binary tree, find its minimum depth.

The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
*/

/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
class Solution {
public:
    int minDepth(TreeNode* root) {
        if(!root){
            return 0;
        }
        else if(!root->left && !root->right){
            return 1;
        }
        else if(!root->left){
            return minDepth(root->right)+1;
        }
        else if(!root->right){
            return minDepth(root->left)+1;
        }
        else{
            return min(minDepth(root->left),minDepth(root->right))+1;
        }
    }
};
