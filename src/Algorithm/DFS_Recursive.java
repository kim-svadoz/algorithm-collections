package Algorithm;

import java.util.LinkedList;
import java.util.Stack;

import javax.xml.soap.Node;

public class DFS_Recursive {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

public class Queue<T> {

}

public class Graph {
	Class Node{
		int data;
		LinkedList<Node> adjacent;
		boolean marked;

	Node(int data){
			this.data = data;
			this.marked = false;
			adjacent = new LinkedList<Node>();
		}

	Node[] nodes;

	Graph(int size) {
		nodes = new Node[size];
		for (int i = 0; i < size; i++) {
			nodes[i] = new Node(i);
		}
	}
	void addEdge(int i1, int i2) {
		Node n1 = nodes[i1];
		Node n2 = nodes[i2];
		if(!n1.adjacent.contains(n2)) {
			n1.adjacent.add(n2);
		}
		if(!n2.adjacent.contains(n1)) {
			n2.adjacent.add(n1);
		}
	}
	
	void dfs() {
		
	}
	
	void dfs(int index) {
		Node root = nodes[index];
		Stack<Node> stack = new Stack<Node>();
		stack.push(root);
		root.marked = true;
		while(!stack.isEmpty()) {
			Node r = stack.pop();
			for(Node n: r.adjacent) {
				if(n.marked==false) {
					n.marked=true;
					stack.push(n);
				}
			}
			visittt(r);
		}
	}
	
}
