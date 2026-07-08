public class Main {

    public static void main(String[] args) {

        Graph g = new Graph(5);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 3);
        g.addEdge(2, 4);

        System.out.println("Graph:");
        g.printGraph();

        System.out.println();

        System.out.println("Vertices: " + g.size());
        System.out.println("Edges: " + g.getEdges());

        System.out.println();

        System.out.println("Neighbours of 0: " + g.getNeighbours(0));
        System.out.println("Degree of 0: " + g.degree(0));

        System.out.println();

        System.out.println("Has edge (0,2): " + g.hasEdge(0, 2));
        System.out.println("Has edge (1,4): " + g.hasEdge(1, 4));

        System.out.println();

        System.out.println("BFS Traversal from 0:");
        g.bfs(0);

        System.out.println();

        System.out.println("DFS Traversal from 0:");
        g.dfsHelper(0);

        System.out.println();

        System.out.println("DFS Traversal of Entire Graph:");
        g.dfsAll();

        System.out.println();

        System.out.println("BFS Traversal of Entire Graph:");
        g.bfsAll();

        System.out.println();

        System.out.println("Connected Components: "
                + g.connectedComponents());

        System.out.println();

        // ---------------- WEIGHTED GRAPH ----------------

        WeightedGraph wg = new WeightedGraph(5);

        wg.addEdge(0, 1, 5);
        wg.addEdge(0, 2, 2);
        wg.addEdge(1, 3, 7);
        wg.addEdge(2, 4, 4);

        System.out.println("Weighted Graph:");
        wg.printGraph();

        System.out.println();

        System.out.println("Vertices = " + wg.size());
        System.out.println("Edges = " + wg.getEdges());

        System.out.println();

        System.out.println("Neighbours of 0 = "
                + wg.getNeighbours(0));

        System.out.println("Neighbours of 1 = "
                + wg.getNeighbours(1));

        System.out.println();

        System.out.println("Degree of 0 = "
                + wg.degree(0));

        System.out.println("Degree of 3 = "
                + wg.degree(3));

        System.out.println();

        System.out.println("Has Edge (0,2) ? "
                + wg.hasEdge(0, 2));

        System.out.println("Has Edge (1,4) ? "
                + wg.hasEdge(1, 4));
    }
}