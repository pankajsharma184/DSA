/*
Check Whether the Graph is a Tree or Not
Description
Given a graph with N vertices. Check whether the graph is a tree or not.
 

Input Format:
The first line contains an integer representing a number N as the number of vertices of the graph.
The second contains an integer n representing the number of edges in the graph.
Each next n line will have two space-separated integers, representing two vertices of each edge.
For example: 
1 2 represents an edge from node 1 to node 2. 

Output Format:
Print ‘Yes’ (without quotes and with capital letter ‘Y’) if the graph is a tree, otherwise ‘No’ (without quotes and with capital letter ‘N’).

Sample Test Cases:
Input:
15
4
11 10
10 12
10 13
13 14

Output:
No

Input:
6
5
1 0
0 2  
0 3  
3 4
4 5

Output:
Yes

*/

import java.util.*;

public class Source {

    private int vertexCount;
    private static LinkedList<Integer> adj[];

    Source(int vertexCount) {
        this.vertexCount = vertexCount;
        this.adj = new LinkedList[vertexCount];
        for (int i = 0; i < vertexCount; ++i) {
            adj[i] = new LinkedList<Integer>();    
        }
    }

    public void addEdge(int v, int w) {
        if (!isValidIndex(v) || !isValidIndex(w)) {
            return;
        }
        adj[v].add(w);
        adj[w].add(v);
    }

    private boolean isValidIndex(int i) {
        // Write code here
        if(adj[i].contains(i)){
            return false;
        }
        else{
            return true;
        }
    }

    private boolean isCyclic(int v, boolean visited[], int parent) {
        // Write code here
        visited[v] = true;
        int node;

        Iterator<Integer> iterator = adj[v].iterator();
        while (iterator.hasNext())
        {
            node = iterator.next();

            if (visited[node] == false)
            {
                if (isCyclic(node, visited, v))
                    return true;
            }
            else if (node != parent){
                return true;
            }
        }
        return false;
    }

    public boolean isTree() {
        // Write Code here
        boolean visited[] = new boolean[vertexCount];
        for (int i = 0; i < vertexCount; i++)
            visited[i] = false;

        if (isCyclic(0, visited, -1))
            return false;

        for (int u = 0; u < vertexCount; u++)
            if (visited[u] == false)
                return false;
        return true;
        
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        // Get the number of nodes from the input.
        int noOfNodes =  sc.nextInt();
         // Get the number of edges from the input.
        int noOfEdges = sc.nextInt();

        Source graph = new Source(noOfNodes);
        // Adding edges to the graph
        for (int i = 0; i <noOfEdges; ++i) {
            graph.addEdge(sc.nextInt(),sc.nextInt());
        }
        if (graph.isTree()) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}