package binary_tree;

public class BinarySearchTree {

    Node root;

    BinarySearchTree() {
        root = null;
    }

    public void insert(int key) {
        root = insert(root, key);
    }

    public Node insert(Node node, int key) {
        if (node == null) {
            node = new Node(key);
            return node;
        }

        if (key < node.key) {
            node.left = insert(node.left, key);
        } else {
            node.right = insert(node.right, key);
        }
        return node;
    }

    public void inorder() {
        root = inOrder(root);
    }

    public Node inOrder(Node root) {
        if (root != null) {
            inOrder(root.left);
            System.out.print(root.key + " ");
            inOrder(root.right);
        }
        return root;
    }

    public boolean search(int key) {
        root = search(root, key);

        return root != null;
    }

    public Node search(Node root, int key) {

        if (root == null || root.key == key) {
            return root;
        }
        if (key < root.key) {
            return search(root.left, key);
        }
        return search(root.right, key);
    }

    public static class Node {
        int key;

        Node left;
        Node right;

        Node(int key) {
            this.key = key;
            this.left = this.right = null;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "key=" + key +
                    '}';
        }
    }
}
