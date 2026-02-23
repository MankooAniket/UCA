import java.util.Stack;

public class DFS {
    private boolean[] marked;
    private int[] edgeTo;
    private int s;

    public DFS(Graph g, int s) {
        this.marked = new boolean[g.V()];
        this.edgeTo = new int[g.V()];
        this.s = s;
        dfs(g, s);
    }

    private void dfs(Graph g, int v) {
        marked[v] = true;

        for (int w : g.adj(v)) {
            if (!marked[w]) {
                edgeTo[w] = v;
                dfs(g, w);
            }
        }
    }

    public boolean connected(int v) {
        return marked[v];
    }

    public void printPath(int v) {
        if (!connected(v)) return;

        Stack<Integer> path = new Stack<>();

        for (int x = v; x != s; x = edgeTo[x]) {
            path.push(x);
        }
        path.push(s);

        while (!path.isEmpty()) {
            System.out.print(path.pop());
            if (!path.isEmpty()) System.out.print(" -> ");
        }
        System.out.println();
    }
}
