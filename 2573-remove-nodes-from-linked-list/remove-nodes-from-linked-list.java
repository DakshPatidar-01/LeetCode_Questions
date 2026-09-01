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
    public ListNode removeNodes(ListNode head) {
        Stack<ListNode> st = new Stack<>();
        ListNode curr = head;
        ListNode del =null;
        while(curr!=null){
            while(!st.isEmpty() && st.peek().val<curr.val){
                del =st.pop();
                del=curr;
            }
            if(!st.isEmpty())st.peek().next=curr;
            else head=curr;
            st.push(curr);
            curr=curr.next;
        }
        if(!st.isEmpty())st.peek().next=null;
        else head=null;
        return head;
    }
}