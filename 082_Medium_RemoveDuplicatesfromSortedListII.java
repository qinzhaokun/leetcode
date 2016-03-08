/*
Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.

For example,
Given 1->2->3->3->4->4->5, return 1->2->5.
Given 1->1->1->2->3, return 2->3.
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
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }
        ListNode newHead = new ListNode(-1);
        newHead.next = head;
        ListNode before = newHead;
        ListNode cur = head;
        ListNode after = head.next;
        while(after != null){
            if(after.val != cur.val){
                before = before.next;
                cur = cur.next;
                after = after.next;
            }
            else{
                while(after !=null && after.val == cur.val){
                    after = after.next;
                }
                before.next = after;
                cur = after;
                if(after != null){
                    after = after.next;
                }
            }
        }
        return newHead.next;
    }
}
