import java.util.ArrayList;
import java.util.List;

class Pair {
  int node;
  int weight;
  
  Pair(int node, int weight) {
    this.node = node;
    this.weight = weight;
  }
  
  @Override
  public String toString(){
    return "(" + node + ", " + weight + ")";
  }
}

class WeightedGraph {
  private int V;
  private int E;
  private List<List<Pair>> adj;

  WeightedGraph(int V) {
    this.V = V;
    this.E = 0;
    adj = new ArrayList<>();
    
    for (int i = 0; i < V; i++) { 
      adj.add(new ArrayList<>());
    }
  }

  public void addEdge(int u, int v, int weight) {
    adj.get(u).add(new Pair(v, weight));
    adj.get(v).add(new Pair(u, weight));
    E++;
  }

  public void addDirectedEdge(int u, int v, int weight) {
    adj.get(u).add(new Pair(v, weight));
    E++;
  }
  
  public int size() {
    return V;
  }
  
  public int getEdges() {
    return E;
  }
  
  public List<Pair> getNeighbours(int v) {
    return adj.get(v);
  }

  public int degree(int v) {
    return adj.get(v).size();
  }
  
  public boolean hasEdge(int u, int v) {
    for (Pair edge: adj.get(u)) {
      if (edge.node == v) {
        return true;
      }
    } 
    return false;
  }
  
  public void printGraph() {
    for (int i = 0; i < V; i++) {
      System.out.print(i + " -> ");
      for (Pair edge : adj.get(i)) {
        System.out.print(edge + " ");
      }
      System.out.println();
    }
  }
}

