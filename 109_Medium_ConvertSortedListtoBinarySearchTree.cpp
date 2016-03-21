/*
Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.
*/


/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
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
    TreeNode* sortedListToBST(ListNode* head) {
        if(!head){
            return NULL;
        }
        ListNode* low = head;
        ListNode* fast = head;
        ListNode* lastLow = NULL;
        while(fast != NULL && fast->next != NULL){
            lastLow = low;
            low = low->next;
            fast = fast->next;
            fast = fast->next;
        }
        TreeNode* node = new TreeNode(low->val);
        if(!lastLow){
            return node;
        }
        else{
            lastLow->next = NULL;
            node->left = sortedListToBST(head);
            node->right = sortedListToBST(low->next);
            return node;
        }
        
    }
};
