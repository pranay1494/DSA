//package tree;
//https://leetcode.com/problems/minimum-depth-of-binary-tree/submissions/
//public class MinDepth {
//    public int minDepth(TreeNode root) {
//        if(root == null) return 0;
//
//        if(root.left!=null && root.right == null) return minDepth(root.left) + 1;
//        if(root.right!=null && root.left == null) return minDepth(root.right) + 1;
//
//        int ls = minDepth(root.left);
//        int rs = minDepth(root.right);
//
//        return Math.min(ls + 1,rs + 1);
//    }
//}
