//package tree;
//https://leetcode.com/problems/sum-root-to-leaf-numbers/
//public class SumR2LNumber {
//    int ans = 0;
//    public int sumNumbers(TreeNode root) {
//        ArrayList<Integer> list = new ArrayList<>();
//        sumNumbers(root,list,0);
//        return ans;
//    }
//
//    private void sumNumbers(TreeNode root, ArrayList<Integer> list, int pathLen){
//        if(root == null) return;
//
//        list.add(pathLen,root.val);
//        pathLen++;
//
//        if(root.left == null && root.right == null){
//            ans+=processAns(list,pathLen);
//        }
//        else{
//            sumNumbers(root.left,list,pathLen);
//            sumNumbers(root.right,list,pathLen);
//        }
//
//    }
//
//    private int processAns(ArrayList<Integer> list, int len){
//        int temp = 0;
//        for(int i = 0;i<len ; i++){
//            if(i==0){
//                temp = list.get(i);
//            }else{
//                temp = (temp * 10) + list.get(i);
//            }
//        }
//        return temp;
//    }
//}
