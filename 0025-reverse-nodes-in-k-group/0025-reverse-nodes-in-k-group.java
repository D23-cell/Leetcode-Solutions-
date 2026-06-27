class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 1) return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        ListNode prevGroupTail = dummy;
        ListNode curr = head;
        
        int count = 0;
        ListNode temp = head;
        while (temp != null) {
            count++;
            temp = temp.next;
        }

        while (count >= k) {
            ListNode groupStart = curr;
            ListNode prev = null;
            ListNode next = null;
            
            for (int i = 0; i < k; i++) {
                next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }
            
            prevGroupTail.next = prev;
            groupStart.next = curr;
            
            prevGroupTail = groupStart;
            count -= k;
        }
        
        return dummy.next;
    }
}