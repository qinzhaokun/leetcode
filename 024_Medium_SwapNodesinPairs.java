/*
Given a linked list, swap every two adjacent nodes and return its head.

For example,
Given 1->2->3->4, you should return the list as 2->1->4->3.

Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be changed.

Subscribe to see which companies asked this question
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
    public ListNode swapPairs(ListNode head) {
        ListNode pre = head;
        if(pre != null && pre.next != null){
            head = pre.next;
        }
        else{
            return head;
        }
        ListNode cur = pre.next;
        while(pre != null && pre.next != null){
            cur = pre.next;
            ListNode tmp = cur.next;
            cur.next = pre;
            pre.next = (tmp == null ? null : (tmp.next==null?tmp:tmp.next));
            pre = tmp;
        }
        return head;
    }
}
