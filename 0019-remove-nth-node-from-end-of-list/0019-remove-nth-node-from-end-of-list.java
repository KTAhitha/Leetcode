class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || head.next == null)
            return null;
        int cnt = 0;
        ListNode temp = head;
        while (temp != null) {
            temp = temp.next;
            cnt++;
        }
        if (n == cnt) {
            ListNode delNode = head;
            head = head.next;
            return head;
        }
        int x = cnt - n;
        temp = head;
        while (--x > 0)
            temp = temp.next;
        ListNode delNode = temp.next;
        temp.next = temp.next.next;
        return head;
    }
}