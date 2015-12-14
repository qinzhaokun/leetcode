/*
Given a singly linked list, determine if it is a palindrome.

Follow up:
Could you do it in O(n) time and O(1) space?
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
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null){
            return true;
        }
        ListNode cur1 = head;
        ListNode cur2 = head;
        ListNode last = null;
        while(cur2 != null && cur2.next != null){
            ListNode tmp = cur1;
            cur1 = cur1.next;
            cur2 = cur2.next.next;
            //reserve ListNode
            tmp.next = last;
            last = tmp;
            
        }
        if(cur2 != null){
            cur1 = cur1.next;
        }
        while(cur1 != null){
            if(cur1.val != last.val){
                return false;
            }
            cur1 = cur1.next;
            last = last.next;
        }
        return true;
    }
}
