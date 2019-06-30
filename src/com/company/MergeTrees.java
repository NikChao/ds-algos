package com.company;

public class MergeTrees {
    public class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) return null;
        int leftVal = t1 == null ? 0 : t1.val;
        int rightVal = t2 == null ? 0 : t2.val;
        TreeNode root = new TreeNode(leftVal + rightVal);

        if ((t1 == null || t1.left == null) && (t2 == null || t2.left == null)) {
            root.left = null;
        } else if (t1 == null || t1.left == null) {
            root.left = t2 == null ? null : t2.left;
        } else if (t2 == null || t2.left == null ) {
            root.left = t1 == null ? null : t1.left;
        } else {
            root.left = mergeTrees(t1.left, t2.left);
        }

        if ((t1 == null || t1.right == null) && (t2 == null || t2.right == null)) {
            root.right = null;
        } else if (t1 == null || t1.right == null) {
            root.right = t2 == null ? null : t2.right;
        } else if (t2 == null || t2.right == null ) {
            root.right = t1 == null ? null : t1.right;
        } else {
            root.right = mergeTrees(t1.right, t2.right);
        }
        return root;
    }
}
