/*
Given a binary tree, determine if it is height-balanced.

For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
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
    bool isBalanced(TreeNode* root) {
        if(height(root) == -1){
            return false;
        }
        else{
            return true;
        }
    }
    
    int height(TreeNode* node){
        if(!node){
            return 0;
        }
        else{
            int left = height(node->left);
            int right = height(node->right);
            if(left == -1 || right == -1 || left-right > 1 || right - left > 1){
                return -1;
            }
            else{
                return max(left,right)+1;
            }
        }
    }
};
