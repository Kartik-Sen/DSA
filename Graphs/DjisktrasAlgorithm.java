package Graphs;

import java.util.*;

public class DjisktrasAlgorithm {
    // Function to find the shortest distance of all the vertices
    // from the source vertex S.
    public int[] dijkstra(int V, List<List<int[]>> adj, int S) {
        // Create a set (priority queue) for storing the nodes as a pair {dist, node}
        // TreeSet in Java sorts elements based on the first element of the pair
        // (distance).
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));

        // Initialize the dist array with a large number to indicate that nodes are
        // unvisited initially.
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);

        // Source node has distance 0
        dist[S] = 0;

        // Insert the source node with a distance of 0 into the priority queue
        pq.offer(new int[] { 0, S });

        // Traverse the graph using Dijkstra's algorithm
        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int dis = current[0];
            int node = current[1];

            // If the current distance is greater than the recorded distance, skip this node
            if (dis > dist[node]) {
                continue;
            }

            // Traverse all adjacent nodes of the current node
            for (int[] neighbor : adj.get(node)) {
                int adjNode = neighbor[0];
                int edgeWeight = neighbor[1];

                // If a shorter path is found
                if (dis + edgeWeight < dist[adjNode]) {
                    dist[adjNode] = dis + edgeWeight;
                    pq.offer(new int[] { dist[adjNode], adjNode });
                }
            }
        }

        // Return the list containing shortest distances from source to all the nodes
        return dist;
    }

    public static void main(String[] args) {
        // Driver code.
        int V = 3, S = 2;

        // Create an adjacency list for the graph
        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // Adding edges to the adjacency list (edges: {node, weight})
        adj.get(0).add(new int[] { 1, 1 });
        adj.get(0).add(new int[] { 2, 6 });
        adj.get(1).add(new int[] { 2, 3 });
        adj.get(1).add(new int[] { 0, 1 });
        adj.get(2).add(new int[] { 0, 6 });
        adj.get(2).add(new int[] { 1, 3 });

        // Create the Solution object and run dijkstra
        DjisktrasAlgorithm obj = new DjisktrasAlgorithm();
        int[] res = obj.dijkstra(V, adj, S);

        // Output the result (shortest distances from the source to all nodes)
        for (int i = 0; i < V; i++) {
            if (res[i] == Integer.MAX_VALUE) {
                System.out.print("INF "); // If the node is unreachable
            } else {
                System.out.print(res[i] + " ");
            }
        }
        System.out.println();
    }
}
