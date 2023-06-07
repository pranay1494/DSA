package gojek;

import java.util.*;

public class DiagonalSumInBinaryTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(7);
        root.left = new TreeNode(7);
        root.right = new TreeNode(4);
        root.left.left = new TreeNode(8);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(9);
        root.right.left.right = new TreeNode(5);
        root.left.left.left = new TreeNode(5);
        root.left.left.right = new TreeNode(6);
        DiagonalSumInBinaryTree tree = new DiagonalSumInBinaryTree();
        tree.diagonalSum(root);
    }

    HashMap<Integer,Integer> map = new LinkedHashMap<>();

    private void diagonalSumUtil(TreeNode root, int level) {
        if (root == null) return ;

        map.put(level,map.getOrDefault(level,0) + root.data);

        diagonalSumUtil(root.left, level + 1);
        diagonalSumUtil(root.right, level);
    }

    private ArrayList<Integer> diagonalSum(TreeNode root){
        ArrayList<Integer> list = new ArrayList<>();
        diagonalSumUtil(root,0);
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            System.out.println("root = " + entry.getValue());
            list.add(entry.getValue());
        }
        return list;
    }
}
class TreeNode{
    int data;
    TreeNode left,right;
    TreeNode(int d){
        data=d;
        left=right=null;
    }
}
