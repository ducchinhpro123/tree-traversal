package utils;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
    }

    public static ListNode arrToLinkedList(int[] arr) {
        ListNode dum = new ListNode(0);
        ListNode head = dum;

        for (int v : arr) {
            head.next = new ListNode(v);
            head = head.next;
        }
        return dum.next;
    }
}
