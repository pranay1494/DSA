package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class TopologicalSort {
    public static void main(String[] args) {
        List<List<Integer>> list = new ArrayList<>();
        list.add(new ArrayList<>());
        list.add( Arrays.asList(0));
        list.add( Arrays.asList(0));
        list.add( Arrays.asList(0));
        topoSort(3,list);
    }

    static int[] topoSort(int V, List<List<Integer>> adj)
    {
        // add your code here

        boolean[] visited = new boolean[adj.size()];
        Stack<Integer> stack = new Stack<>();

        for(int i=0;i<adj.size();i++){
            if(!visited[i]){
                topoSortUtil(i,visited,adj,stack);
            }
        }

        int[] ans = new int[stack.size()];
        int k=0;
        while(!stack.isEmpty()){
            int val = stack.peek();
            stack.pop();
            ans[k] = val;
            k++;
        }

        return ans;
    }

    private static void topoSortUtil(int v, boolean[] visited, List<List<Integer>> adj, Stack<Integer> ans){
        if(visited[v]) return;
        visited[v] = true;


        for(int i=0; i<adj.get(v).size();i++){
            if(!visited[adj.get(v).get(i)]){
                topoSortUtil(adj.get(v).get(i),visited,adj,ans);
            }
        }
        ans.push(v);
    }
}
