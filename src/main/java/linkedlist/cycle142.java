package linkedlist;

public class cycle142 {
    public static void main(String[] args) {

        ListNode listNode = new ListNode(1);
        System.out.println(method(listNode));

    }
    public static ListNode method(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        boolean isCycle = false;
        while (fast!= null && fast.next!= null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                isCycle = true;
                break;
            }
        }
        if (isCycle) {
            ListNode s2 = head;

            while (slow != s2) {
                slow = slow.next;
                s2 = s2.next;
            }
            return s2;
        }
        return new ListNode(-1);
    }
}
