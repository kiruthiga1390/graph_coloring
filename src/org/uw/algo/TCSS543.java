package org.uw.algo;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.TreeSet;


public class TCSS543 {

	public int i = 0;
	
	public static void main(String[] args) {
		/* Generate graph with number of nodes and desired density */
		GenerateGraph getgraph = new GenerateGraph();
		List<Node> graph = getgraph.generategraph(7, 0.55);
		// System.out.println("no of nodes :" + graph.size());
		/* call brelaz */
		int color = brelaz(graph);
		System.out.println("no of colors :" + color);


		// for (Node n : graph) {
		// System.out.print("N " + n.getId() + " C " + n.color + " -> ");
		// for (Node m : n.getAdjList()) {
		// System.out.print(" " + m.getId());
		// }
		// System.out.println();
		// }

	}

	public static int brelaz(List<Node> graph) {
		int max = 0;
		/* find the adjancency degree (no. of neighbors) of the nodes */
		fill_adjacency_degree(graph);
		/*
		 * Adding in priority queue which contains adjacency degree and saturation
		 * degree and sorts first based on saturation degree and then by adjacency
		 * degree
		 */
		Queue<Node> priority_queue = new PriorityQueue<Node>(graph.size(),
		    Comparator
		    .comparingInt(
		    Node::getSaturation_degree).thenComparing(Node::getAdjacency_degree));
		for (Node n : graph) {
			priority_queue.add(n);
		}

		Node next = priority_queue.poll();
		/* setting color of the node with highest adjacency degree to 1 */
		next.setColor(1);
		while (!priority_queue.isEmpty()) {
			next = priority_queue.poll();
			/* setting color of the next node to minimum available color */
			int color = getmincolor(next);
			next.setColor(color);
			if (color > max) {
				max = color;
			}
			/* update saturation degree of neighboring node after coloring a node */
			updatesaturationdegree(next, priority_queue);
		}
		return max;

	}

	/* This method finds the next minimum color available */

	public static int getmincolor(Node next) {
		TreeSet<Integer> neighbourcolors = new TreeSet<Integer>();
		int i = 1;
		for (Node n : next.getAdjList()) {
			if (n.getColor() != 0) {
			neighbourcolors.add(n.getColor());
			}
		}

		Integer checkcolor = neighbourcolors.pollFirst();

		while (checkcolor != null) {
			if (i != checkcolor) {
            return i;
			}
			checkcolor = neighbourcolors.pollFirst();
			i++;
		}
		return i;
	}

	/* This method adds the adjacency degree of all nodes */
	public static void fill_adjacency_degree(List<Node> graph) {
		for (Node n : graph) {
			n.setAdjacency_degree(n.getAdjList().size());
		}
	}

	/*
	 * This method updates the saturation degree (no. of unique neighboring
	 * colors)
	 */
	public static void updatesaturationdegree(Node n,
 Queue<Node> priority_queue) {
		for (Node neighbour : n.getAdjList()) {
			int sat_degree = neighbour.getSaturation_degree();
			neighbour.setSaturation_degree(sat_degree + 1);
			if (neighbour.getColor() == 0) {
				priority_queue.remove(neighbour);
				priority_queue.add(neighbour);
			}
		}
	}

	

}
