/*
Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.

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
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0){
            return null;
        }
        int l = 0;
        int r = lists.length-1;
        return mergesort(lists,l,r);
    }
    
    ListNode mergesort(ListNode[] lists, int l, int r){
        if(l == r){
            return lists[l];
        }
        else if(r - l == 1){
            return merge(lists[l],lists[r]);
        }
        int mid = l + (r-l)/2;
        ListNode left = mergesort(lists,l,mid);
        ListNode right = mergesort(lists,mid+1,r);
        return merge(left,right);
    }
    
    ListNode merge(ListNode l1, ListNode l2){
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
        ListNode cur = head;
        while(l1 != null && l2 !=null){
            if(l1.val < l2.val){
                cur.next = l1;
                l1 = l1.next;
            }
            else{
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        if(l1 == null){
            cur.next = l2;
        }
        else{
            cur.next = l1;
        }
        return head;
    }
}
