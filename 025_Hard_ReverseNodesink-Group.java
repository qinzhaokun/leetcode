/*
Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.

If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.

You may not alter the values in the nodes, only nodes itself may be changed.

Only constant memory is allowed.

For example,
Given this linked list: 1->2->3->4->5

For k = 2, you should return: 2->1->4->3->5

For k = 3, you should return: 3->2->1->4->5

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
    public ListNode reverseKGroup(ListNode head, int k) {
        if(k == 0 || k == 1){
            return head;
        }
        if(head == null || head.next == null){
            return head;
        }
        
        ListNode cur = head;
        ListNode newhead = null;
        ListNode last = null;
        while(true){
            int count = 0;
            ListNode now = cur;
            while(count < k-1 && cur != null){
            cur = cur.next;
            count++;
            } 
            if(cur != null){
              int t = 0;
              ListNode next = now.next;
              ListNode now1 = now;
              while(t < k-1){
                  ListNode newnext = next.next;
                  next.next = now;
                  now = next;
                  next = newnext;
                  t++;
              }
              if(newhead == null){
                  newhead = now;
              }
              else{
                  last.next = now;
              }
              now1.next = next;
              last = now1;
              cur = next;
            }
            else{
                break;
            }
        }
        if(newhead == null){
            return head;
        }
        else{
            return newhead;
        }
    }
}
