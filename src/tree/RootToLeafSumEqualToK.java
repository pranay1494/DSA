//package tree;
//https://practice.geeksforgeeks.org/problems/root-to-leaf-path-sum/1
//public class RootToLeafSumEqualToK {
//    boolean hasPathSum(Node root, int S) {
//        // Your code here
//        if(root !=null ){
//            int sum = S - root.data;
//            if(root.left == null && root.right == null && sum == 0) return true;
//
//            return hasPathSum(root.left,sum)||hasPathSum(root.right,sum);
//        }
//        return false;
//    }
//}
