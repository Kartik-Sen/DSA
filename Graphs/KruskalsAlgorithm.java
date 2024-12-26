package Graphs;

import java.util.*;

class KruskalsAlgorithm {

    // Disjoint Set (Union-Find) class to handle connected components
    static class DisjointSet {
        List<Integer> rank = new ArrayList<>();
        List<Integer> parent = new ArrayList<>();
        List<Integer> size = new ArrayList<>();

        public DisjointSet(int n) {
            for (int i = 0; i <= n; i++) {
                rank.add(0);
                parent.add(i);
                size.add(1);
            }
        }

        public int findUPar(int node) {
            // Path compression
            if (node == parent.get(node)) {
                return node;
            }
            int ulp = findUPar(parent.get(node)); // Find the ultimate parent
            parent.set(node, ulp); // Path compression: set the parent to the ultimate parent
            return parent.get(node);
        }

        public void unionByRank(int u, int v) {
            int ulp_u = findUPar(u);
            int ulp_v = findUPar(v);
            if (ulp_u == ulp_v) {
                return; // Same component, no need to unite
            }
            if (rank.get(ulp_u) < rank.get(ulp_v)) {
                parent.set(ulp_u, ulp_v); // Attach u's tree under v's
            } else if (rank.get(ulp_v) < rank.get(ulp_u)) {
                parent.set(ulp_v, ulp_u); // Attach v's tree under u's
            } else {
                parent.set(ulp_v, ulp_u); // Arbitrarily make u root of v
                int rankU = rank.get(ulp_u);
                rank.set(ulp_u, rankU + 1); // Increase the rank of u
            }
        }

        public void unionBySize(int u, int v) {
            int ulp_u = findUPar(u);
            int ulp_v = findUPar(v);
            if (ulp_u == ulp_v) {
                return; // Same component, no need to unite
            }
            if (size.get(ulp_u) < size.get(ulp_v)) {
                parent.set(ulp_u, ulp_v);
                size.set(ulp_v, size.get(ulp_v) + size.get(ulp_u)); // Merge the smaller set to the bigger set
            } else {
                parent.set(ulp_v, ulp_u);
                size.set(ulp_u, size.get(ulp_u) + size.get(ulp_v)); // Merge the smaller set to the bigger set
            }
        }
    }

    // Edge class to represent an edge
    static class Edge implements Comparable<Edge> {
        int src, dest, weight;

        Edge(int _src, int _dest, int _wt) {
            this.src = _src;
            this.dest = _dest;
            this.weight = _wt;
        }

        // Comparator function used for sorting edges based on their weight
        public int compareTo(Edge compareEdge) {
            return this.weight - compareEdge.weight; // Compare based on weight
        }
    }

    static class Solution {
        // Function to find the sum of weights of edges of the Minimum Spanning Tree
        // (MST)
        int spanningTree(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj) {
            List<Edge> edges = new ArrayList<>();

            // Build the edge list
            for (int i = 0; i < V; i++) {
                for (int j = 0; j < adj.get(i).size(); j++) {
                    int adjNode = adj.get(i).get(j).get(0);
                    int wt = adj.get(i).get(j).get(1);
                    if (i < adjNode) { // Add each edge only once (undirected graph)
                        edges.add(new Edge(i, adjNode, wt));
                    }
                }
            }

            // Create DisjointSet (Union-Find) instance for V vertices
            DisjointSet ds = new DisjointSet(V);

            // Sort edges based on weight
            Collections.sort(edges);

            int mstWt = 0;

            // Traverse all edges in sorted order
            for (Edge edge : edges) {
                int wt = edge.weight;
                int u = edge.src;
                int v = edge.dest;

                // If u and v are not connected, include this edge in MST
                if (ds.findUPar(u) != ds.findUPar(v)) {
                    mstWt += wt;
                    ds.unionBySize(u, v); // Union by size (or you can use union by rank)
                }
            }

            return mstWt; // Return the total weight of the MST
        }
    }

    public static void main(String[] args) {
        int V = 5; // Number of vertices
        ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<>();

        int[][] edges = {
                { 0, 1, 2 }, { 0, 2, 1 }, { 1, 2, 1 }, { 2, 3, 2 }, { 3, 4, 1 }, { 4, 2, 2 }
        };

        // Initialize adjacency list for the graph
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // Add edges to the adjacency list
        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            int w = edges[i][2];

            ArrayList<Integer> tmp1 = new ArrayList<>();
            ArrayList<Integer> tmp2 = new ArrayList<>();
            tmp1.add(v);
            tmp1.add(w);

            tmp2.add(u);
            tmp2.add(w);

            adj.get(u).add(tmp1);
            adj.get(v).add(tmp2);
        }

        Solution obj = new Solution();
        int mstWt = obj.spanningTree(V, adj);
        System.out.println("The sum of all the edge weights in the MST: " + mstWt);
    }
}
