public class ConnectedComponents {
  private boolean[] marked;
  private int count;
  private int[] id;
  
  ConnectedComponents(Graph g) {
    this.marked = new boolean[g.V()];
    this.id = new int[g.V()];
    this.count = 0;
    
    for (int v = 0; v < g.V(); v++) {
      if (!marked[v]) {
        dfs(g, v);
        count++;
      }
    }
  }

  public boolean connected(int v, int w) {
    return this.id[v] == this.id[w];
  }
  
  public int count() {
    return this.count;
  }
  
  public int id(int v) {
    return this.id[v];
  }
  
  private void dfs(Graph g, int v) {
    marked[v] = true;
    id[v] = count;
    
    for (int w : g.adj(v)) {
      if (!marked[w]){
        dfs(g,w);
      }
    }
  }
  
  public static void main(String[] args) {
    Graph g = new Graph(8);
    g.addEdge(0,1);
    g.addEdge(1,2);
    g.addEdge(0,2);
    
    g.addEdge(3,4);
    g.addEdge(4,5);
    g.addEdge(5,3);
   
    g.addEdge(6,7);
    
    ConnectedComponents cc = new ConnectedComponents(g);
    
    assert cc.connected(0,2) == true;
    assert cc.connected(0,3) == false;
    assert cc.connected(6,3) == false;
    assert cc.connected(6,0) == false;
    assert cc.connected(6,7) == true;
    assert cc.connected(3,4) == true;
    
    assert cc.count() == 3;
  }
}
