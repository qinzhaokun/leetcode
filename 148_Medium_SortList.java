/*
Sort a linked list in O(n log n) time using constant space complexity.
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
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null) return head;
        
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        fast = slow.next;
        slow.next = null;
        slow = sortList(head);
        fast = sortList(fast);
        if(slow == null) return fast;
        if(fast == null) return slow;
        if(slow.val < fast.val){
            head = slow;
            slow = slow.next;
        }
        else{
            head = fast;
            fast = fast.next;
        }
        ListNode cur = head;
        while(slow != null && fast != null){
            if(slow.val < fast.val){
                cur.next = slow;
                slow = slow.next;
            }
            else{
                cur.next = fast;
                fast = fast.next;
            }
            cur = cur.next;
        }
        if(slow != null) cur.next = slow;
        else cur.next = fast;
        return head;
    }
}

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    //这题，那个链表，移来移去，算来算去，搞了好久，思维好不严密的我
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode cur1 = head;
        ListNode cur2 = cur1;
        ListNode last = null;
        while(cur2 != null && cur2.next != null){
            last = cur1;
            cur1 = cur1.next;
            cur2 = cur2.next.next;
        }
        cur2 = last.next;
        last.next = null;
        cur1 = sortList(head);
        cur2 = sortList(cur2);
        if(cur1 == null){
            return cur2;
        }
        if(cur2 == null){
            return cur1;
        }
        head = cur1;
        if(cur2.val < cur1.val){
            head = cur2;
            cur2 = cur1;
        }
        ListNode temp = head;
        ListNode temp1 = head.next;
        
        while(cur2 != null){
            if(temp1 == null){
                if(temp.val > cur2.val){
                    
                }
                else{
                    temp1 = cur2;
                    temp.next = temp1;
                    ListNode t = cur2.next;
                    temp1.next = null;
                    temp = temp1;
                    temp1 = temp1.next;
                    cur2 = t;
                }
            }
            else{
                if(temp.val <= cur2.val && temp1.val >= cur2.val){
                    ListNode t = cur2.next;
                    temp.next = cur2;
                    cur2.next = temp1;
                    temp = cur2;
                    cur2 = t;
                }
                else{
                    temp = temp1;
                    temp1 = temp1.next;
                }
            }
        }
        return head;
    }

}
