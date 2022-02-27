
/**
 *
 * @author tourist
 */
// This graph implementation maintains a vertex-indexed array of lists of integers.
// Every edge appears twice: if an edge connects v and w, then w appears in v's list
// and v appears in w's list. The second constructor reads a graph from an input stream,
// in the format V followed by E followed by a list of pairs of int values between 0 and V-1
public class Graph {

    private int V;                          // number of vertices
    private int E;                          // number of edges
    private final Bag<Integer>[] adj;       // adjacency list using bag datatype

    // constructor - create an empty graph with V vertices
    public Graph(int V) {
        if (V < 0) {
            throw new IllegalArgumentException("Number of vertices must be non-negative");
        }
        this.V = V;
        this.E = 0;
        // create an array of size V of Bag Integer
        adj = (Bag<Integer>[]) new Bag[V];
        for (int v = 0; v < V; v++) {
            adj[v] = new Bag<Integer>();
        }
    }

    // return the number of vertices in this graph
    public int V() {
        return V;
    }

    // return the number of edges in this graph
    public int E() {
        return E;
    }

    // throw an IllegalArgumentException unless (0 <= v < V)
    private void validateVertex(int v) {
        if (v < 0 || v >= V) {
            throw new IllegalArgumentException("Vertex " + v + " is not between 0 and " + (V - 1));
        }
    }

    // add edge v - w (parallel edges allowed)
    public void addEdge(int v, int w) {
        adj[v].add(w);      // Add w to v's list
        adj[w].add(v);      // Add v to w's list
        E++;
    }

    // iterator for vertices adjacent to v
    public Iterable<Integer> adj(int v) {
        validateVertex(v);
        return adj[v];
    }

    // return the degree of vertex
    public int degree(int v) {
        validateVertex(v);
        return adj[v].size();
    }

    // Return a String representation of this graph
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append(V).append(" vertices, ").append(E).append(" edges ").append("\n");
        for (int v = 0; v < V; v++) {
            s.append(v).append(" : ");
            for (int w : adj[v]) {
                s.append(w).append(" ");
            }
            s.append("\n");
        }
        return s.toString();
    }

    // driver code for testing
    public static void main(String[] args) {
        Graph G = new Graph(5);
        System.out.println(G);
    }
}
