package com.program.daa;

import java.util.ArrayList;

public class CurrencyArbitrage {

	void currencyArbitrage(double[][] rates, String[] currencies)
	{
		int V =currencies.length;
		int parent[] = new int[V];
		double weights[][] = rateConvertor(rates);
		int src = 0;
		double dist[] = new double[V];
		ArrayList<Integer> path = new ArrayList<Integer>();
		boolean negativeWeightCycleExist = false;
		
		for (int i = 0; i < V; ++i) {
			dist[i] = Integer.MAX_VALUE;
			parent[i]=-1;
		}
		
		dist[src] = 0;
		
		for (int i = 0; i < V - 1; ++i) {
			for (int source = 0; source < V; ++source) {
				for (int destination = 0; destination < V; ++destination) {
					double weight = weights[source][destination];
					if (dist[source] + weight < dist[destination]) {
						dist[destination] = dist[source] + weight;
						parent[destination] = source;
					}
				}
			}
		}

		for (int source = 0; source < V; ++source) {
			for (int destination = 0; destination < V; ++destination) {
				double weight = weights[source][destination];
				if (dist[source] + weight < dist[destination]) {
					//negative cycle
					negativeWeightCycleExist = true;
					path.add(destination);
					path.add(source);
					getCycle(source, destination, parent, path);
					displayCycle(V, path, currencies);
				}
			}
		}
		
		if(!negativeWeightCycleExist)
			System.out.println("there is no negative weight cycle");
	
	
	}

	private double[][] rateConvertor(double[][] rates) {
		int length = rates[0].length;
		double weights[][] = new double[length][length];
		for(int i = 0; i< length; i++) {
			for(int j = 0; j< length; j++) {
				weights[i][j] = -(Math.log(rates[i][j])); 
			}
		}
		return weights;
	}
	
	private void getCycle(int source, int destination, int[] parent, ArrayList<Integer> path) {
		while(!path.contains(parent[source])) {
			path.add(parent[source]);
			source = parent[source];
		}	
		path.add(parent[source]);
	}

	void displayCycle(int V, ArrayList<Integer> path, String[] currencies) {
		System.out.println("Graph contains negative weight cycle");
		for(int index: path) {
			System.out.print(currencies[index]+" ");
		}
	}

	public static void main(String[] args)
	{
		CurrencyArbitrage graph = new CurrencyArbitrage();
		
		double rates[][] = {
				{1,64,111.1},
				{0.015,1,1.8},
				{0.009,0.55,1}
		};
		String currencies[] = {"USD", "INR", "JPY"};
		
		graph.currencyArbitrage(rates, currencies);
	}


}
