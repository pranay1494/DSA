package stack;

import java.util.Arrays;
import java.util.Stack;

public class StockSpann {

    public static void main(String[] args) {
        System.out.println("args = " + Arrays.toString(calculateSpan(new int[]{100,80 ,60, 70, 60, 75 ,85},7)));
    }

    public static int[] calculateSpan(int price[], int n)
    {
        // Your code here
        int[] ans = new int[n];
        Element[] ngl = nextGraterElement(price,n);

        for(int i=0;i<n;i++){
            ans[i] =  i-ngl[i].index;
        }
        return ans;
    }

    private static Element[] nextGraterElement(int price[], int n){
        Stack<Element> s = new Stack<>();
        Element[] ans = new Element[n];

        for(int i=0;i<n;i++){
            while(!s.isEmpty() && s.peek().ngl <= price[i]){
                s.pop();
            }
            ans[i] = (!s.isEmpty())?s.peek():(new Element(-1,-1));
            s.push(new Element(i,price[i]));
        }
        return ans;
    }
}
class Element{
    int index;
    int ngl;
    public Element(int index, int ngl) {
        this.index = index;
        this.ngl = ngl;
    }
}
