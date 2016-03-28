/*
Sort a linked list using insertion sort.
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
    public ListNode insertionSortList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode cur = head.next;
        head.next = null;
        while(cur != null){
            ListNode tmp = cur.next;
            cur.next = null;
            head = addOne(head,cur);
            cur = tmp;
        }
        return head;
    }
    
    ListNode addOne(ListNode head, ListNode node){
       if(node.val <= head.val){
           node.next = head;
           return node;
       }
       
        ListNode bef = head;
        ListNode cur = head.next;
        while(cur != null){
            if(cur.val >= node.val){
                bef.next = node;
                node.next = cur;
                return head;
            }
            else{
                bef = cur;
                cur = cur.next;
            }
        }
        bef.next = node;
        return head;
    }
}
