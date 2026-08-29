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
    public ListNode reverseEvenLengthGroups(ListNode head) {
        // step-01 = check k nodes available
        // step-02 = check even odd and take action accordingly
        // step-03 = k++

        if(head==null || head.next==null)return head;
        ListNode curr = head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prevGTail = dummy;
        ListNode grpStart = curr;
        int k=1;
        ListNode prev = dummy;
        while(curr!=null){
            int len = getLen(curr,k);
            if(len%2==0){
                prev=null;
                for(int i=0;i<len;i++){
                    ListNode next = curr.next;
                    curr.next = prev;
                    prev = curr;
                    curr=next;
                }
                prevGTail.next = prev;
                grpStart.next=curr;
                prevGTail = grpStart;
                grpStart = curr;
            }else{
                for(int i=0;i<len;i++){
                    prevGTail = curr;
                    curr=curr.next;
                }
                grpStart=curr;
            }
            k++;
        }
        return dummy.next;
    }

    private int getLen(ListNode curr,int k){
        int count=0;
        while(curr!=null && count<k){
            count++;
            curr=curr.next;
        }
        return count;
    }
}