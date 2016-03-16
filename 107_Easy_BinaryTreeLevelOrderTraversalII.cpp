/*
Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).

For example:
Given binary tree {3,9,20,#,#,15,7},
    3
   / \
  9  20
    /  \
   15   7
return its bottom-up level order traversal as:
[
  [15,7],
  [9,20],
  [3]
]
confused
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
    vector<vector<int>> levelOrderBottom(TreeNode* root) {
        vector<vector<int>> re;
        dfs(re,root,0);
        return vector<vector<int>>(re.rbegin( ), re.rend( ) );
    }
    
    void dfs(vector<vector<int>>& re, TreeNode* node, int level){
        if(node != NULL){
          if(re.size() == level){
            re.push_back(vector<int>());
          }
           re[level].push_back(node->val);
           dfs(re,node->left,level+1);
           dfs(re,node->right,level+1);  
        }
        
    }
};
