/*
Given preorder and inorder traversal of a tree, construct the binary tree.

Note:
You may assume that duplicates do not exist in the tree.
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
    TreeNode* buildTree(vector<int>& preorder, vector<int>& inorder) {
        if(inorder.size() != preorder.size()){
            return NULL;
        }
        else{
            return build(preorder,0,preorder.size()-1,inorder,0,inorder.size()-1);
        }
    }
    
    TreeNode* build(vector<int>& pre, int startPre, int endPre, vector<int>& in, int startIn, int endIn){
        if(startPre > endPre){
            return NULL;
        }
        else{
            TreeNode* newNode = new TreeNode(pre[startPre]);
            int i = startIn;
            while(i <= endIn && in[i] != pre[startPre]) {i++;}
            if(i == endIn+1) return newNode;
            int leftLength = i-startIn;
            newNode->left = build(pre,startPre+1,startPre+leftLength,in,startIn,i-1);
            newNode->right = build(pre,startPre+leftLength+1,endPre,in,i+1,endIn);
            return newNode;
        }
    }
};
