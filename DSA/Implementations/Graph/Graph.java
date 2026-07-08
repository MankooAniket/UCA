import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.LinkedList;

class Graph {
  private int V;
  private int E;
  private List<List<Integer>> adj;

  Graph(int V) {
    this.V = V;
    this.E = 0;
    adj = new ArrayList<>();

    for (int i = 0; i < V; i++) {
      adj.add(new ArrayList<>());
    }
  }

  public void addEdge(int u, int v) {
    adj.get(u).add(v);
    adj.get(v).add(u);
    E++;
  }

  public void addDirectedEdge(int u, int v) {
    adj.get(u).add(v);
    E++;
  }

  public int size() {
    return V;
  }

  public int getEdges() {
    return E;
  }

  public List<Integer> getNeighbours(int v) {
    return adj.get(v);
  }

  public int degree(int v) {
    return adj.get(v).size();
  }

  public boolean hasEdge(int u, int v) {
    return adj.get(u).contains(v);
  }

  public void printGraph() {
    for (int i = 0; i < V; i++) {
      System.out.print(i + " -> ");
      for (int neighbour : adj.get(i)) {
        System.out.print(neighbour + " ");
      }
      System.out.println();
    }
  }

  public void bfs(int src) {
    Queue<Integer> q = new LinkedList<>();
    boolean[] visited = new boolean[V];

    visited[src] = true;
    q.offer(src);

    while (!q.isEmpty()) {
      int curr = q.poll();
      System.out.print(curr + " ");

      for (int neighbour : adj.get(curr)) {
        if (!visited[neighbour]) {
          visited[neighbour] = true;
          q.offer(neighbour);
        }
      }
    }
  }

  public void bfsAll() {
    Queue<Integer> q = new LinkedList<>();
    boolean[] visited = new boolean[V];

    for (int i = 0; i < V; i++) {
      if (!visited[i]) {
        visited[i] = true;
        q.offer(i);

        while (!q.isEmpty()) {
          int curr = q.poll();
          System.out.print(curr + " ");

          for (int neighbour : adj.get(curr)) {
            if (!visited[neighbour]) {
              visited[neighbour] = true;
              q.offer(neighbour);
            }
          }
        }
      }
    }
  }

  public void dfsAll() {
    boolean[] visited = new boolean[V];

    for (int i = 0; i < V; i++) {
      if (!visited[i]) {
        dfs(i, visited);
      }
    }
  }

  public void dfsHelper(int src) {
    boolean[] visited = new boolean[V];
    dfs(src, visited);
  }

  public void dfs(int src, boolean[] visited) {
    visited[src] = true;
    System.out.print(src + " ");
    for (int neighbour : adj.get(src)) {
      if (!visited[neighbour]) {
        dfs(neighbour, visited);
      }
    }
  }

  private void dfsMark(int src, boolean[] visited) {
    visited[src] = true;

    for (int neighbour : adj.get(src)) {
      if (!visited[neighbour]) {
        dfsMark(neighbour, visited);
      }
    }
  }

  public int connectedComponents() {
    boolean[] visited = new boolean[V];
    int components = 0;

    for (int i = 0; i < V; i++) {
      if (!visited[i]) {
        dfsMark(i, visited);
        components++;
      }
    }
    return components;
  }
}
