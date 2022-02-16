package linkedlist;

public class PartitionList86 {

    public static void main(String[] args) {

        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(4);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(2);
        listNode.next.next.next.next = new ListNode(5);
        listNode.next.next.next.next.next = new ListNode(2);

        System.out.println(method(listNode, 3));

       // head = [1,4,3,2,5,2], x = 3



    }
    public static ListNode method(ListNode head, int x) {
        ListNode lTail, left = new ListNode();
        ListNode rTail, right = new ListNode();
        lTail = left;
        rTail = right;

        while (head !=null) {
            if (head.val < x) {
                lTail.next = head;
                lTail = lTail.next;
            } else {
                rTail.next = head;
                rTail = rTail.next;
            }
            head = head.next;
        }

        lTail.next = right.next;
        rTail.next = null;
        return left.next;
    }
}
