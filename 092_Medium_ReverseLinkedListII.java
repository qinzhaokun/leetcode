/*
Reverse a linked list from position m to n. Do it in-place and in one-pass.

For example:
Given 1->2->3->4->5->NULL, m = 2 and n = 4,

return 1->4->3->2->5->NULL.

Note:
Given m, n satisfy the following condition:
1 ≤ m ≤ n ≤ length of list.
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(m == n){
            return head;
        }
        ListNode newHead = new ListNode(-1);
        newHead.next = head;
        ListNode cur = newHead;
        int i = 1;
        while(i < m){
            cur = cur.next;
            i++;
        }
        ListNode markHead = cur;
        cur = cur.next;
        ListNode mPoi = cur;
        ListNode cur1 = cur.next;
        i = 0;
        while(i < n-m){
            ListNode tmp = cur1.next;
            cur1.next = cur;
            cur = cur1;
            cur1 = tmp;
            i++;
        }
        markHead.next = cur;
        mPoi.next = cur1;
        return newHead.next;
    }
}
