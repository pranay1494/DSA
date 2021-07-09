package backtracking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NQueen {
    public static void main(String[] args) {
        NQueen nqueen = new NQueen();
        nqueen.solveNQueens(4);
    }
    public List<List<String>> solveNQueens(int n) {
        Postion[] postions = new Postion[n];
        solveNQueenUtil(n,0,postions);
        return solution(postions);
    }

    private List<List<String>> solution(Postion[] postions) {
        List<List<String>> ans = new ArrayList<>();
        for (int i = 0; i < postions.length; i++) {
            List<String> list = new ArrayList<>();
            Collections.fill(list,"");
        }
        return null;
    }

    private boolean solveNQueenUtil(int n, int rowsRepresentinQueens, Postion[] postions) {
        if (n == rowsRepresentinQueens){
            return true;
        }
        for (int i = 0; i < n; i++) {
            boolean safe = true;

            for (int j = 0; j < rowsRepresentinQueens; j++) {
                if (!isSafe(j,rowsRepresentinQueens,i,postions)){
                    safe = false;
                    break;
                }
            }
            if (safe){
                Postion element = new Postion(rowsRepresentinQueens, i);
                postions[rowsRepresentinQueens] = element;
                if (solveNQueenUtil(n, rowsRepresentinQueens + 1,postions)){
                    return true;
                }
            }
        }

        return false;
    }

    private boolean isSafe(int queen, int row, int column, Postion[] postions) {
        return !( postions[queen].column == column && postions[queen].row == row && postions[queen].row - postions[queen].column == row - column && postions[queen].row + postions[queen].column == row + column );
    }

    class Postion{
        int row;
        int column;

        public Postion(int row, int column) {
            this.row = row;
            this.column = column;
        }
    }
}
