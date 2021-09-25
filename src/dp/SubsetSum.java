package dp;

import java.util.Arrays;

public class SubsetSum {
    public static void main(String[] args) {
        System.out.println("args = " + isSubsetSum(6, new int[]{3, 34, 4, 12, 5, 2}, 9));
    }

    static Boolean isSubsetSum(int n, int wt[], int sum) {

        boolean[][] t = new boolean[n + 1][sum + 1];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= sum; j++) {
                if (i == 0) {
                    t[i][j] = false;
                }
                if (j == 0) {
                    t[i][j] = true;
                }

            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {
                if (wt[i - 1] <= j) {
                    t[i][j] = t[i - 1][j - wt[i - 1]] || t[i - 1][j];
                } else {
                    t[i][j] = t[i - 1][j];
                }
            }
        }

//        for (int i = 0; i <= n; i++) {
//            for (int j = 0; j <= sum; j++) {
//                System.out.print(""+t[i][j]+" ");
//            }
//            System.out.print("\n");
//        }
        return t[n][sum];
    }
}
