package dp;

public class Knapsack01 {

    public static void main(String[] args) {
        System.out.println("args = " + knapSack(3,new int[]{4,5,6},new int[]{1,2,3},3));
    }

    static int knapSack(int W, int wt[], int val[], int n)
    {
        int[][] t = new int[n+1][W+1];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= W; j++) {
                if (i == 0 || j ==0){
                    t[i][j] = 0;
                    continue;
                }

                if (wt[i - 1] <= j) {
                    t[i][j] = Math.max(val[i-1] + t[i-1][j-wt[i-1]], t[i-1][j]);
                }else{
                    t[i][j] = t[i-1][j];
                }

            }
        }
        return t[n][W];
    }
}
