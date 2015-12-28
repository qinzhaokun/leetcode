/*
A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.

Return a deep copy of the list.
*/


/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if(head == null){
            return null;
        }
        
        RandomListNode cur = head;
        while(cur != null){
            RandomListNode next = cur.next;
            RandomListNode cur1 = new RandomListNode(cur.label);
            cur.next = cur1;
            cur1.next = next;
            cur = next;
        }
        
        cur = head;
        
        while(cur != null){
            if(cur.random != null){
                cur.next.random = cur.random.next;
            }
            cur = cur.next.next;
        }
        
        cur = head;
        RandomListNode newHead = head.next;
        while(cur != null){
            RandomListNode next = cur.next;
            cur.next = next.next;
            next.next = (cur.next == null ? null:cur.next.next);
            cur = cur.next; 
        }
        return newHead;
    }
}
