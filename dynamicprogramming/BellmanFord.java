package com.program.dynamicprogramming;

import java.util.ArrayList;

public class BellmanFord {
	
	class Edge {
		int src, dest, weight;

		Edge() {
			src = dest = weight = 0;
		}
	};

	int V, E;
	Edge edge[];

	BellmanFord(int v, int e) {
		V = v;
		E = e;
		edge = new Edge[e];
		for (int i = 0; i < e; ++i)
			edge[i] = new Edge();
	}

	void bellmanFord(BellmanFord graph, int src) {
		
		int V = graph.V, E = graph.E;
		int dist[] = new int[V];
		int parent[] = new int[V];

		for (int i = 0; i < V; ++i)
			dist[i] = Integer.MAX_VALUE;
		dist[src] = 0;

		for (int i = 0; i < V - 1; ++i) {
			for (int j = 0; j < E; ++j) {
				int u = graph.edge[j].src;
				int v = graph.edge[j].dest;
				int weight = graph.edge[j].weight;
				if (dist[u] != Integer.MAX_VALUE && dist[u] + weight < dist[v]) {
					dist[v] = dist[u] + weight;
					parent[v] = u;
				}
			}
		}

		for (int j = 0; j < E; ++j) {
			int u = graph.edge[j].src;
			int v = graph.edge[j].dest;
			int weight = graph.edge[j].weight;
			if (dist[u] != Integer.MAX_VALUE && dist[u] + weight < dist[v]) {
				System.out.println("Graph contains negative weight cycle");
				return;
			}
		}
		displayShortestPath(V, parent, dist);
	}

	private void getPath(int[] parent, int vertex, ArrayList<Integer> path) {
		if (vertex <= 0) {
			path.add(0);
			return;
		}
		getPath(parent, parent[vertex], path);
		path.add(vertex);
	}

	void displayShortestPath(int V, int[] parent, int[] dist) {
		System.out.println("shortest path from Source");
		System.out.println("vertex" + "\t\tdistance from source\t"+ "path");
		System.out.println("------\t\t----------\t\t----");
		for (int i = 0; i < V; ++i) {
			ArrayList<Integer> path = new ArrayList<Integer>();
			if (i != 0) {
				getPath(parent, i, path);
			}
			System.out.println(i + "\t\t"+dist[i]+"\t\t\t" + path);
		}
	}

	public static void main(String[] args) {
		int V = 5; // Number of vertices in graph
		int E = 8; // Number of edges in graph

		BellmanFord graph = new BellmanFord(V, E);

        graph.edge[0].src = 0;
        graph.edge[0].dest = 1;
        graph.edge[0].weight = -1;

        graph.edge[1].src = 0;
        graph.edge[1].dest = 2;
        graph.edge[1].weight = 4;
 
        graph.edge[2].src = 1;
        graph.edge[2].dest = 2;
        graph.edge[2].weight = 3;

        graph.edge[3].src = 1;
        graph.edge[3].dest = 3;
        graph.edge[3].weight = 2;

        graph.edge[4].src = 1;
        graph.edge[4].dest = 4;
        graph.edge[4].weight = 2;

        graph.edge[5].src = 3;
        graph.edge[5].dest = 2;
        graph.edge[5].weight = 5;

        graph.edge[6].src = 3;
        graph.edge[6].dest = 1;
        graph.edge[6].weight = 1;
 
        graph.edge[7].src = 4;
        graph.edge[7].dest = 3;
        graph.edge[7].weight = -3;
         
        // Function call
        graph.bellmanFord(graph, 0);
	}
}
