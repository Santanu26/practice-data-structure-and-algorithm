package binary_tree;

public class BSTtoSortedDoublyLinkedList426 {

    static Node head = null;
    static Node previous = null;

    public static void main(String[] args) {

        Node node = new Node(4);
        node.left = new Node(2);
        node.left.left = new Node(1);
        node.left.right = new Node(3);
        node.right = new Node(5);

        System.out.println(treeToDoublyLinkedList(node));

    }

    public static Node treeToDoublyLinkedList(Node root) {

        dfs(root);

        if (head == null) {
            return null;
        }
        head.left = previous;
        previous.right = head;
        return head;
    }

    public static void dfs(Node currentNode) {

        if (currentNode == null) {
            return;
        }
        dfs(currentNode.left);

        if (head == null) {
            head = currentNode;
        } else {
            previous.right = currentNode;
            currentNode.left = previous;
        }
        previous = currentNode;

        dfs(currentNode.right);
    }

    public static class Node {
        Node left;
        Node right;
        int value;

        Node() {
        }

        Node(int val) {
            this.value = val;
        }

        @Override
        public String toString() {
            return "Node{" +

                    " value=" + value +
                    '}';
        }
    }
}
