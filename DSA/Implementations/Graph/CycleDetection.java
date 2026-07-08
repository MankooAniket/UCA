import java.util.Arrays;
import java.util.List;
import java.util.LinkedList;
import java.util.Queue;

public class CycleDetection {
    public boolean cycleDetectionBFS(int V, List<List<Integer>> adj) {
        boolean[] visited = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                if (bfs(i, V, visited, adj)) {
                    return true;
                }
            }
        }

        return false;
    }

    public boolean bfs(int src, int V, boolean[] visited, List<List<Integer>> adj) {
        Queue<Integer> q = new LinkedList<>();
        int[] parent = new int[V];

        Arrays.fill(parent, -1);

        visited[src] = true;
        q.offer(src);

        while (!q.isEmpty()) {
            int curr = q.poll();
            for (int neighbour : adj.get(curr)) {
                if (!visited[neighbour]) {
                    visited[neighbour] = true;
                    parent[neighbour] = curr;
                    q.offer(neighbour);
                } else if (neighbour != parent[curr]) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean cycleDetectionDFS(int V, List<List<Integer>> adj) {
        boolean[] visited = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                if (dfs(i, -1, visited, adj)) {
                    return true;
                }
            }
        }

        return false;
    }

    public boolean dfs(int src, int parent, boolean[] visited, List<List<Integer>> adj) {
        visited[src] = true;
        for (int neighbour : adj.get(src)) {
            if (!visited[neighbour]) {
                if (dfs(neighbour, src, visited, adj)) {
                    return true;
                }
            } else if (neighbour != parent) {
                return true;
            }
        }
        return false;
    }
}
