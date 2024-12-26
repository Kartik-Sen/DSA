package Graphs;

import java.util.*;

public class CloneGraph {

    static class Node {
        public int val;
        public List<Node> neighbors;

        public Node(int val) {
            this.val = val;
            this.neighbors = new ArrayList<>();
        }
    }

    // Function to clone the graph using DFS
    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }

        // HashMap to store the mapping between original nodes and their clones
        Map<Node, Node> visited = new HashMap<>();

        // Call DFS to start cloning
        return dfs(node, visited);
    }

    // Helper DFS function to clone the graph
    private Node dfs(Node node, Map<Node, Node> visited) {
        // If the node has already been cloned, return the clone
        if (visited.containsKey(node)) {
            return visited.get(node);
        }

        // Create a new node with the same value as the original node
        Node clone = new Node(node.val);
        visited.put(node, clone); // Store the clone in the map

        // Recursively clone all the neighbors
        for (Node neighbor : node.neighbors) {
            clone.neighbors.add(dfs(neighbor, visited));
        }

        return clone;
    }

    public static void main(String[] args) {
        CloneGraph solution = new CloneGraph();

        // Create an example graph:
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);

        node1.neighbors.add(node2);
        node1.neighbors.add(node4);
        node2.neighbors.add(node1);
        node2.neighbors.add(node3);
        node3.neighbors.add(node2);
        node3.neighbors.add(node4);
        node4.neighbors.add(node1);
        node4.neighbors.add(node3);

        // Clone the graph
        Node clonedGraph = solution.cloneGraph(node1);

        // Output the cloned graph (simple printout for demonstration)
        System.out.println("Cloned Graph:");
        solution.printGraph(clonedGraph);
    }

    // Helper function to print the graph (for testing purposes)
    private void printGraph(Node node) {
        Set<Node> visited = new HashSet<>();
        dfsPrint(node, visited);
    }

    private void dfsPrint(Node node, Set<Node> visited) {
        if (node == null || visited.contains(node)) {
            return;
        }

        visited.add(node);
        System.out.print("Node " + node.val + " -> Neighbors: ");
        for (Node neighbor : node.neighbors) {
            System.out.print(neighbor.val + " ");
        }
        System.out.println();

        for (Node neighbor : node.neighbors) {
            dfsPrint(neighbor, visited);
        }
    }
}
