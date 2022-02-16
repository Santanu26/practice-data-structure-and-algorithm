package linkedlist;

public class RemovedNthNode19 {


    public static void main(String[] args) {

    }

    public static ListNode method(ListNode head, int n) {

        int totalNodes = 0;

        ListNode tmp = head;

        while (tmp != null) {
            totalNodes++;
            tmp = tmp.next;
        }
        if (totalNodes == 1) return null;
        if (n == totalNodes) {return head.next;}
        tmp = head;


        for (int idx = 1; idx< totalNodes -n ;idx++) {
            tmp = tmp.next;
        }
        tmp.next = tmp.next.next;
        return head;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}