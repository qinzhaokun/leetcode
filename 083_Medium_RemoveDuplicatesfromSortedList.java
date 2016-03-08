/*
Given a sorted linked list, delete all duplicates such that each element appear only once.

For example,
Given 1->1->2, return 1->2.
Given 1->1->2->3->3, return 1->2->3.
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
        if(head == null || head.next == null){
            return head;
        }
        
        ListNode before = head;
        ListNode cur = head.next;
        while(cur != null){
            if(cur.val != before.val){
                cur = cur.next;
                before = before.next;
            }
            else{
                while(cur != null && cur.val == before.val){
                    cur = cur.next;
                }
                before.next = cur;
                before = cur;
                if(cur != null){
                    cur = cur.next;
                }
            }
        }
        
        return head;
    }
}
