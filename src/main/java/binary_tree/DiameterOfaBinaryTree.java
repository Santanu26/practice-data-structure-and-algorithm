package binary_tree;


//Definition for a binary tree node.


public class DiameterOfaBinaryTree {

    static int counter = 0;

    public static void main(String[] args) {

        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        /*treeNode.right = new TreeNode(3);
        treeNode.left.left = new TreeNode(4);
        treeNode.left.right = new TreeNode(5);*/

        System.out.println(diameterOfBinaryTree(treeNode));

    }

    public static int diameterOfBinaryTree(TreeNode root) {

        if (root == null) {
            return 0;
        }
        height(root);

        return counter;
    }

    public static int height(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left_height = height(root.left);
        int right_height = height(root.right);
        counter = Math.max(counter, left_height + right_height);

        return 1 + Math.max(left_height, right_height);
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
    }
}
