package linkedlist;

public class MergeKLinkedList708 {
    public static void main(String[] args) {

        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(5);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);

        ListNode l3 = new ListNode(2);
        l3.next = new ListNode(6);

        ListNode[] lists = new ListNode[] {l1, l2, l3};


        System.out.println(mergeKLinkedList(lists));

    }

    public static ListNode mergeKLinkedList(ListNode[] lists) {
        return mergeKLinkedList(lists, 0, lists.length - 1);
    }

    public static ListNode mergeKLinkedList(ListNode[] listNode, int start, int end) {

        if (start > end) {
            return null;
        }
        if (start == end) {
            return listNode[start];
        }
        int mid = (start + end) / 2;
        ListNode left = mergeKLinkedList(listNode, start, mid);
        ListNode right = mergeKLinkedList(listNode, mid + 1, end);
        return mergeSortLists(left, right);
    }

    public static ListNode mergeSortLists(ListNode list1, ListNode list2) {

        if (list2 == null) {
            return list1;
        }
        if (list1 == null) {
            return list2;
        }

        if (list1.val < list2.val) {
            list1.next = mergeSortLists(list1.next, list2);
            return list1;
        } else {
            list2.next = mergeSortLists(list2.next, list1);
            return list2;
        }
    }
}
