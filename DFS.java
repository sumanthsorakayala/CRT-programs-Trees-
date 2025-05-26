// Java program to perform Iterative 
// Depth First Traversal of Graph
import java.util.*;

class DFS {

    // Start DFS from node 0.
    static ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> adj) {
        int n = adj.size();
        
        boolean[] visited = new boolean[n];
        ArrayList<Integer> res = new ArrayList<>();
        
        Stack<Integer> st = new Stack<>();
        st.push(0);
        
        while (!st.isEmpty()) {
            int node = st.pop();
            
            // If node is already visited, continue
            if (visited[node] == true) {
                continue;
            }
            
            // Mark this node as visited 
            visited[node] = true;
            res.add(node);
            
            // Traverse all edges (as stack is used, so 
            // push from right to left)
            int size = adj.get(node).size();
            for (int i = size - 1; i >= 0; i--) {
                int v = adj.get(node).get(i);
                if (!visited[v]) st.push(v);
            }
        }
        
        return res;
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        adj.add(new ArrayList<>(Arrays.asList(1, 2)));
        adj.add(new ArrayList<>(Arrays.asList(2)));
        adj.add(new ArrayList<>(Arrays.asList(0, 3)));
        adj.add(new ArrayList<>(Arrays.asList(3)));

        ArrayList<Integer> res = dfs(adj);
        for (int node : res) System.out.print(node + " ");
        System.out.println();
    }
}