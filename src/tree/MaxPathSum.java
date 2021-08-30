package tree;

import java.util.ArrayList;
import java.util.Arrays;

class MaxNode{
    int data;
    MaxNode left;
    MaxNode right;
    public MaxNode(int data){
        this.data=data;
        left=null;
        right=null;
    }
}
public class MaxPathSum {
    MaxNode root;
    public static void main(String[] args) {
        MaxPathSum tree=new MaxPathSum();
        tree.root = new MaxNode(10);
        tree.root.left = new MaxNode(-2);
        tree.root.right = new MaxNode(7);
        tree.root.left.left = new MaxNode(8);
        tree.root.left.right = new MaxNode(-4);
        int sum=tree.findmaxSum(tree.root);
        System.out.println("Max sum is "+sum);
        System.out.println("Print path is: ");

        ArrayList<Integer> list = new ArrayList<>();

        boolean b = printPath(tree.root, sum, list, 0);
        if (!b){
            System.out.println("found = " + b);
        }

    }
    private static boolean printPath(MaxNode node, int sum, ArrayList<Integer> list, int pathLen) {
        if(node == null) return false;

        int k = sum - node.data;
        list.add(pathLen,node.data);
        pathLen++;

        if(node.left == null && node.right == null && k == 0){
            printData(list,pathLen);
            return true;
        }
        return printPath(node.left, k, list, pathLen) || printPath(node.right, k, list, pathLen);

    }

    private static void printData(ArrayList<Integer> list, int pathLen){
        for (int i = 0;i<pathLen ; i++){
            System.out.print(list.get(i)+" ");
        }
    }


    private int findmaxSum(MaxNode node) {
        if(node==null)
            return 0;
        int left=findmaxSum(node.left);
        int right=findmaxSum(node.right);
        return (left>right?left:right)+node.data;
    }

}
