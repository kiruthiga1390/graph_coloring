package org.uw.algo;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;


public class GenerateGraph {

	public static void main(String[] args) {
		GenerateGraph obj = new GenerateGraph();
		List<Node> graph = obj.generategraph(50, .2);
		// printadj(graph);

	}

	/* This method creates a graph with given number of node and density(0 to 1) */
	public List<Node> generategraph(int n, double prob) {
		Node[] node_array = new Node[n];
		List<Node> graph = new ArrayList<Node>();
		int k = 0;
		for (int i = 0; i < node_array.length; i++) {
			node_array[i] = new Node(i);
		}
		Random r = new Random();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (j == i) {
					continue;
				}
				double randomValue = r.nextDouble();
				if(randomValue<prob){
					if (!node_array[i].adjList.contains(node_array[j])) {
						k++;
						node_array[i].adjList.add(node_array[j]);
						node_array[j].adjList.add(node_array[i]);
					}
				}
			}

		}
		// System.out.println("no of edges " + k);
		graph = Arrays.asList(node_array);

		return graph;

	}
	
	public static void printadj(Node[] node_array) {
		for (int i = 0; i < node_array.length; i++) {
			for (Node l1 : node_array[i].adjList) {
				// System.out.println("adjacency list of " + i + ":" + l1.id);

			}
		}
	}

}
