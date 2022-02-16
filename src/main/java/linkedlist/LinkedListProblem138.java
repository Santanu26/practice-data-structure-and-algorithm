package linkedlist;

import java.util.HashMap;

public class LinkedListProblem138 {

    // Key = OldNode, value = newNode
   public static HashMap<Node, Node> visited = new HashMap<>();

    public static void main(String[] args) {
       // Input: head = [[7,null],[13,0],[11,4],[10,2],[1,0]]

        Node head = new Node();
        head.val = 7;
        head.random = null;
        head.next = new Node(7);
        head.next.random = new Node(0);

    }

    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        Node oldNode = head;
        Node newNode = new Node(oldNode.val);
        this.visited.put(oldNode, newNode);

        while (oldNode!=null) {
            newNode.random = this.getClonedNode(oldNode.random);
            newNode.next = this.getClonedNode(oldNode.next);
            oldNode = oldNode.next;
            newNode = newNode.next;
        }

        return this.visited.get(head);
    }
    public Node getClonedNode(Node node) {

        if (node !=null) {
            if (this.visited.containsKey(node)) {
                this.visited.get(node);
            } else {
                this.visited.put(node, new Node(node.val,null, null));
                this.visited.get(node);
            }
        }
        return null;
    }

    public static class Node {
        int val;
        Node next;
        Node random;

        Node() {
        }

        Node(int val, Node next, Node random) {
            this.val = val;
            this.next = next;
            this.random = random;
        }

        Node(int val) {
            this.val = val;
        }
    }
}
