import java.util.*;

public class Bipartite {
    private boolean[] marked;
    private boolean[] color;
    private boolean isBipartite = true;

    public Bipartite(Graph g) {
        marked = new boolean[g.V()];
        color = new boolean[g.V()];

        for (int v = 0; v < g.V(); v++) {
            if (!marked[v]) {
                bfs(g, v);
            }
        }
    }

    private void bfs(Graph g, int s) {
        Queue<Integer> q = new LinkedList<>();
        marked[s] = true;
        q.add(s);

        while (!q.isEmpty()) {
            int v = q.poll();

            for (int w : g.adj(v)) {
                if (!marked[w]) {
                    marked[w] = true;
                    color[w] = !color[v];   // alternate color
                    q.add(w);
                } else {
                    if (color[w] == color[v]) {
                        isBipartite = false;
                    }
                }
            }
        }
    }

    public boolean isBipartite() {
        return isBipartite;
    }
}
