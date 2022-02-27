
/**
 *
 * @author tourist
 */
public class DFS {
    private boolean[] marked;   // marked[v] = is there an s-v path?
    private int count;          // number of vertices connected to s
    
    // computes the vertices in graph that are connected to the source vertex
    public DFS(Graph G, int s){
        marked = new boolean[G.V()];
        validateVertex(s);
        dfs(G, s);
    }
    
    // depth first search from v
    public void dfs (Graph G, int v){
        count++;
        marked[v] = true;
        // recursively check v's adjacent vertices for path
        for (int w : G.adj(v)){
            if (!marked[w]){
                dfs(G, w);
            }
        }
    }
    
    // is there a path between the source vertex and vertex v?
    public boolean marked(int v){
        validateVertex(v);
        return marked[v];
    }
    
    // throw an IllegalArgumentException unless (0 <= v < V)
    private void validateVertex(int v){
        int V = marked.length;
        if (v < 0 || v >= V){
            throw new IllegalArgumentException("Vertex " + v + " is not between 0 and " + (V - 1));
        }
    }
    
}
