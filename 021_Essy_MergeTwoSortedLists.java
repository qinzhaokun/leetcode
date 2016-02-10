/*
Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.

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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null){
            return l2;
        }
        if(l2 == null){
            return l1;
        }
        ListNode head = l1;
        if(l2.val < l1.val){
            head = l2;
            l2 = l2.next;
        }
        else{
            l1 = l1.next;
        }
        ListNode reHead = head;
        while(l1 != null && l2 != null){
            if(l1.val > l2.val){
                head.next = l2;
                l2 = l2.next;
            }
            else{
                head.next = l1;
                l1 = l1.next;
            }
            head = head.next;
        }
        if(l1 == null){
            head.next = l2;
        }
        else{
            head.next = l1;
        }
        return reHead;
    }
}
