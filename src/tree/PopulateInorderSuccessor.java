//package tree;
//https://practice.geeksforgeeks.org/problems/populate-inorder-successor-for-all-nodes/1
//
//public class PopulateInorderSuccessor {
//
//    Node prev = null;
//    public void populateNext(Node node){
//        //code here
//
//        if(node != null){
//            populateNext(node.right);
//
//            node.next = prev;
//            prev = node;
//
//            populateNext(node.left);
//        }
//    }
//}
