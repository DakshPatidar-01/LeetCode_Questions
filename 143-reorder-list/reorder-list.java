/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public void reorderList(ListNode head) {
        ListNode slow=head,fast=head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }

        ListNode prev=null;
        ListNode curr=slow.next;
        slow.next=null;
        ListNode next = curr;
        while (next!=null) {
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        ListNode first=head;
        ListNode right=prev;

        while(right!=null){
            ListNode firstNext=first.next;
            ListNode rightNext=right.next;

            first.next=right;
            right.next=firstNext;

            first=firstNext;
            right=rightNext;
        }
    }
}                  