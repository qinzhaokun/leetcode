/*
Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.

You should preserve the original relative order of the nodes in each of the two partitions.

For example,
Given 1->4->3->2->5->2 and x = 3,
return 1->2->2->4->3->5
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
    public ListNode partition(ListNode head, int x) {
        ListNode small = new ListNode(0);
        ListNode smallHead = small;
        ListNode big = new ListNode(0);
        ListNode bigHead = big;
        ListNode cur = head;
        while(cur != null){
            if(cur.val < x){
                small.next = cur;
                cur = cur.next;
                small = small.next;
                small.next = null;
            }
            else{
                big.next = cur;
                cur = cur.next;
                big = big.next;
                big.next = null;
            }
        }
        if(smallHead.next == null){
            return bigHead.next;
        }
        else{
            small.next = bigHead.next;
            return smallHead.next;
        }
    }
}
