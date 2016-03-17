/*
Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
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
    TreeNode* sortedArrayToBST(vector<int>& nums) {
        int n = nums.size();
        return build(nums,0,n-1);
    }
    
    TreeNode* build(vector<int>& nums, int l,int r){
        if(l > r){
            return NULL;
        }
        else {
            int mid = l + (r-l)/2;
            TreeNode* node = new TreeNode(nums[mid]);
            node->left = build(nums,l,mid-1);
            node->right = build(nums,mid+1,r);
            return node;
        }
    }
};
