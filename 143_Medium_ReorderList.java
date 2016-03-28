/*
Given a singly linked list L: L0→L1→…→Ln-1→Ln,
reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…

You must do this in-place without altering the nodes' values.

For example,
Given {1,2,3,4}, reorder it to {1,4,2,3}.
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
    public void reorderList(ListNode head) {
        //利用快慢指针找到中间节点
        ListNode cur1 = head;
        ListNode cur2 = head;
        while(cur2 != null && cur2.next != null){
            cur1 = cur1.next;
            cur2 = cur2.next.next;
        }
        //单数和双数情况下，cur1均为最后一个节点
        if(cur1 == null || cur1.next == null){
            return;
        }
        //切断链表
        ListNode after = cur1.next;
        ListNode tail = after;
        cur1.next = null;
        cur1 = after.next;
        while(cur1 != null){
            ListNode nn = cur1.next;
            cur1.next = after;
            after = cur1;
            cur1 = nn;
        }
        tail.next = null;
        //将after链表插入前一段链表
        cur2 = head;
        while(after != null){
            ListNode temp = cur2.next;
            cur2.next = after;
            ListNode temp1 = after.next;
            after.next = temp;
            after = temp1;
            cur2 = temp;
        }
    }
}
