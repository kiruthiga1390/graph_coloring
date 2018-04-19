package org.uw.algo;

import java.util.ArrayList;
import java.util.List;

public class Node {

	int id = 0;
	List<Node> adjList = new ArrayList<Node>();
	int saturation_degree = 0;
	int adjacency_degree = 0;
	int color = 0;

	public Node(int id) {
		this.id = id;
	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<Node> getAdjList() {
		return adjList;
	}

	public void setAdjList(List<Node> adjList) {
		this.adjList = adjList;
	}

	public int getSaturation_degree() {
		return saturation_degree;
	}

	public void setSaturation_degree(int saturation_degree) {
		this.saturation_degree = saturation_degree;
	}

	public int getAdjacency_degree() {
		return adjacency_degree;
	}

	public void setAdjacency_degree(int adjacency_degree) {
		this.adjacency_degree = adjacency_degree;
	}

	public int getColor() {
		return color;
	}

	public void setColor(int color) {
		this.color = color;
	}
	
	
//	static Comparator<Node> adjcomparator = new Comparator<Node>() {
//		@Override
//		public int compare(Node o1, Node o2) {
//			// TODO Auto-generated method stub
//
//			if (o1.getAdjacency_degree() > o2.getAdjacency_degree()) {
//				return -1;
//			} else if (o1.getAdjacency_degree() == o2.getAdjacency_degree()) {
//				return 0;
//			} else {
//				return 1;
//			}
//		}
//
//	};
//	
//	private static Comparator<Node> satcomparator = new Comparator<Node>() {
//		@Override
//		public int compare(Node o1, Node o2) {
//			// TODO Auto-generated method stub
//
//			if (o1.getSaturation_degree() > o2.getSaturation_degree()) {
//				return -1;
//			} else if (o1.getSaturation_degree() == o2.getSaturation_degree()) {
//				return 0;
//			} else {
//				return 1;
//			}
//		}

	// };

}
