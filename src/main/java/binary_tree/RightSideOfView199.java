package binary_tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RightSideOfView199 {

    public static void main(String[] args) {
        // Input: root = [1,2,3,null,5,null,4]
        //Output: [1,3,4]

        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(3);
        treeNode.left.left = null;
        treeNode.left.right = new TreeNode(5);

        treeNode.right.left = null;
        treeNode.right.right = new TreeNode(4);

        System.out.println(rightSideView(treeNode));
    }

    public static List<Integer> rightSideView(TreeNode root) {

        if (root == null) {
            return null;
        }
        List<Integer> result = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            int size = q.size();
            TreeNode currentRoot = null;
            for (int i = 0; i < size; i++) {
                 currentRoot = q.poll();
                if (currentRoot.left != null) {
                    q.offer(currentRoot.left);
                }
                if (currentRoot.right != null) {
                    q.offer(currentRoot.right);
                }
            }
            result.add(currentRoot.val);
        }
        return result;
    }

    public static class TreeNode {
        int val;

        TreeNode left;
        TreeNode right;

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
