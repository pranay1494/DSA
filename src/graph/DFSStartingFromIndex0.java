package graph;

import java.util.ArrayList;

//import java.util.ArrayList;https://practice.geeksforgeeks.org/problems/depth-first-traversal-for-a-graph/1

public class DFSStartingFromIndex0 {
    public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        ArrayList<Integer> ans = new ArrayList<Integer>();
        boolean visited[] = new boolean[adj.size()];
        for(int i=0;i<adj.size();i++){
            if(!visited[i])
                dfs(i,visited,ans,adj);
        }
        return ans;
    }

    private void dfs(int v, boolean[] visited, ArrayList<Integer> ans,ArrayList<ArrayList<Integer>> adj){
        visited[v] = true;
        ans.add(v);

        for(int i =0 ; i< adj.get(v).size();i++){
            int n = adj.get(v).get(i);
            if(!visited[n]){
                dfs(n,visited,ans,adj);
            }
        }
    }
}
