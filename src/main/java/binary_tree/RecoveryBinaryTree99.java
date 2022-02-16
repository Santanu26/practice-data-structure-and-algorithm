package binary_tree;

public class RecoveryBinaryTree99 {

    static TreeNode firstElement = null;
    static TreeNode secondElement = null;

    static TreeNode prevElement = new TreeNode(Integer.MIN_VALUE);

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(5);
        treeNode.left = new TreeNode(3);
        treeNode.right = new TreeNode(9);
        treeNode.left.left = new TreeNode(-2147483648);
        treeNode.left.right = new TreeNode(2);
        recoverTree(treeNode);

       // root = [1,3,null,null,2]
    }

    public static void recoverTree(TreeNode root) {

        traverse(root);

        int tmp = firstElement.val;
        firstElement.val = secondElement.val;
        secondElement.val = tmp;
    }


    public static void traverse(TreeNode root) {
        if (root == null) {
            return;
        }
        traverse(root.left);

        if (prevElement != null && prevElement.val >= root.val) {

            if (firstElement ==null) {
                firstElement = prevElement;
            }
            secondElement = root;
        }
        prevElement = root;
        traverse(root.right);
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

        @Override
        public String toString() {
            return "TreeNode{" +
                    "val=" + val +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }
    }
}
