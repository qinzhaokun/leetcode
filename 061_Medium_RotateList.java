/*
Given a list, rotate the list to the right by k places, where k is non-negative.

For example:
Given 1->2->3->4->5->NULL and k = 2,
return 4->5->1->2->3->NULL.
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
    public ListNode rotateRight(ListNode head, int k) {
        ListNode cur = head;
        if(cur == null || cur.next == null){
            return cur;
        }
        int total = 0;
        while(cur.next != null){
            total++;
            cur = cur.next;
        }
        total++;
        ListNode last = cur;
        k = k%total;
        int t = total - k;
        cur = head;
        while(t > 1){
            cur = cur.next;
            t--;
        }
        if(cur.next != null){
            ListNode newHead = cur.next;
            last.next = head;
            cur.next = null;
            return newHead;
        }
        else{
            return head;
        }
    }
}
