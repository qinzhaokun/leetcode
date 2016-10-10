/**
 * Definition for binary tree
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
class BSTIterator {
    
private:
    stack<TreeNode*> s;
public:
    BSTIterator(TreeNode *root) {
        TreeNode* now = root;
        while(now != NULL){
            s.push(now);
            now = now->left;
        }
    }

    /** @return whether we have a next smallest number */
    bool hasNext() {
        return !s.empty();
    }

    /** @return the next smallest number */
    int next() {
        TreeNode* t = s.top();
        s.pop();
        int ret = t->val;
        t = t->right;
        while(t != NULL){
            s.push(t);
            t = t->left;
        }
        return ret;
    }
};

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = BSTIterator(root);
 * while (i.hasNext()) cout << i.next();
 */
