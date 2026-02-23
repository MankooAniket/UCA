import java.util.Queue;
import java.util.LinkedList;

public class Graph {
  private int V;
  private int E;
  private LinkedList<Integer>[] adj;
  
  @SuppressWarnings("unchecked")
  public Graph(int V) {
    this.V = V;
    this.adj = (LinkedList<Integer>[]) new LinkedList[V];
    this.E = 0;
    for (int i = 0; i < V; i++) {
      this.adj[i] = new LinkedList<Integer>();
    }
  }
  
  public void addEdge(int v, int w) {
    this.adj[v].add(w);
    this.adj[w].add(v);
    this.E++;
  }
  
  public int V() {
    return this.V;
  }
  
  public int E() {
    return this.E;
  }
  
  public Iterable<Integer> adj(int v) {
    return this.adj[v];
  }
}
