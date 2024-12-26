package Graphs;

import java.util.*;

public class GraphValidTree {

    // Function to check if the graph is a valid tree
    public boolean validTree(int n, int[][] edges) {
        // If there are not exactly n - 1 edges, it cannot be a tree
        if (edges.length != n - 1) {
            return false;
        }

        // Create an adjacency list for the graph
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        // Build the graph from the edges
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        // Visited array to keep track of visited nodes
        boolean[] visited = new boolean[n];

        // Perform DFS to check if the graph is connected and has no cycles
        if (hasCycle(graph, 0, visited, -1)) {
            return false;
        }

        // Check if all nodes are visited (graph should be connected)
        for (boolean v : visited) {
            if (!v) {
                return false;
            }
        }

        return true;
    }

    // DFS helper function to detect cycle
    private boolean hasCycle(List<List<Integer>> graph, int node, boolean[] visited, int parent) {
        // Mark the current node as visited
        visited[node] = true;

        // Explore all the neighbors of the current node
        for (int neighbor : graph.get(node)) {
            // If the neighbor is not visited, do a DFS on it
            if (!visited[neighbor]) {
                if (hasCycle(graph, neighbor, visited, node)) {
                    return true;
                }
            }
            // If the neighbor is visited and is not the parent, then there's a cycle
            else if (neighbor != parent) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        GraphValidTree solution = new GraphValidTree();

        // Example 1: Valid Tree
        int n1 = 5;
        int[][] edges1 = { { 0, 1 }, { 0, 2 }, { 0, 3 }, { 1, 4 } };
        System.out.println(solution.validTree(n1, edges1)); // Output: true

        // Example 2: Invalid Tree (has a cycle)
        int n2 = 5;
        int[][] edges2 = { { 0, 1 }, { 0, 2 }, { 0, 3 }, { 1, 4 }, { 2, 4 } };
        System.out.println(solution.validTree(n2, edges2)); // Output: false

        // Example 3: Invalid Tree (not connected)
        int n3 = 4;
        int[][] edges3 = { { 0, 1 }, { 0, 2 } };
        System.out.println(solution.validTree(n3, edges3)); // Output: false
    }
}
