class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode sl = dummy;
        for (int i = 1; i < left; i++) {
            sl = sl.next;
        }
        ListNode curr = sl.next;
        ListNode prev = null;
        for (int i = left; i <= right; i++) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        sl.next.next = curr;
        sl.next = prev;
        return dummy.next;
    }
}