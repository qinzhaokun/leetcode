/*
Given a linked list, remove the nth node from the end of list and return its head.

For example,

   Given linked list: 1->2->3->4->5, and n = 2.

   After removing the second node from the end, the linked list becomes 1->2->3->5.
Note:
Given n will always be valid.
Try to do this in one pass.
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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode cur = head;
        int i = 0;
        while(i < n){
            cur = cur.next;
            i++;
        }
        //remove head;
        if(cur == null){
            return head.next;
        }
        ListNode pre = head;
        while(cur.next != null){
            cur = cur.next;
            pre = pre.next;
        }
        pre.next = pre.next.next;
        return head;
    }
}
