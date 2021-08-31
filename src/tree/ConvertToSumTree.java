//package tree;
// https://practice.geeksforgeeks.org/problems/transform-to-sum-tree/1
//public class ConvertToSumTree {
//    public void toSumTree(Node root){
//        //add code here.
//
//        toSumTreeUtil(root);
//    }
//
//    public int toSumTreeUtil(Node root){
//        //add code here.
//
//        if(root == null){
//            return 0;
//        }
//
//        int oldValue = root.data;
//
//        root.data = toSumTreeUtil(root.left) + toSumTreeUtil(root.right) ;
//
//        return root.data + oldValue;
//    }
//}
