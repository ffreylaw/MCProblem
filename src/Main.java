import java.util.Iterator;
import java.util.LinkedList;

public class Main {
	
	private Graph graph;
	private LinkedList<State> visited;
	private State goalState;
	
	public static void main(String[] args) {
		Main prog = new Main();
		prog.run();
	}
	
	public Main() {
		State initState = new State(3, 3, 0, 0, true);
		Node rootNode = new Node(initState);
		graph = new Graph(rootNode);
		visited = new LinkedList<State>();
		goalState = new State(0, 0, 3, 3, false);
	}
	
	public void run() {
		bfs();
	}
	
	private void bfs() {
		LinkedList<Node> queue = new LinkedList<Node>();
		Node current_node = graph.getRootNode();
		
		queue.add(current_node);
		visited.add(current_node.getState());
		
		while (!queue.isEmpty()) {
			current_node = queue.poll();
			System.out.println("visit: " + current_node.getState());
			if (current_node.getState().compare(goalState)) {
				System.out.println("done!");
				break;
			} else {
				expand(current_node);
			}
			
			Iterator<Node> iterator = current_node.getChildNodes().listIterator();
			while (iterator.hasNext()) {
				Node node = iterator.next();
				if (!isVisited(node.getState())) {
					visited.add(node.getState());
					queue.add(node);
				}
			}
			System.out.println("");
		}
	}
	
	private void expand(Node node) {
		State s = node.getState();
		if (s.boatOnLeft()) {
			if (s.getMLeft() - 1 >= 0) {
				State state = new State(s.getMLeft()-1, s.getCLeft(), s.getMRght()+1, s.getCRght(), !s.boatOnLeft());
				if (isValidState(state)) {
					Node n = new Node(state);
					node.addChild(n);
					System.out.println("-- expand: " + n.getState());
				}
			}
			if (s.getCLeft() - 1 >= 0) {
				State state = new State(s.getMLeft(), s.getCLeft()-1, s.getMRght(), s.getCRght()+1, !s.boatOnLeft());
				if (isValidState(state)) {
					Node n = new Node(state);
					node.addChild(n);
					System.out.println("-- expand: " + n.getState());
				}
			}
			if (s.getMLeft() - 1 >= 0 && s.getCLeft() - 1 >= 0) {
				State state = new State(s.getMLeft()-1, s.getCLeft()-1, s.getMRght()+1, s.getCRght()+1, !s.boatOnLeft());
				if (isValidState(state)) {
					Node n = new Node(state);
					node.addChild(n);
					System.out.println("-- expand: " + n.getState());
				}
			}
			if (s.getMLeft() - 2 >= 0) {
				State state = new State(s.getMLeft()-2, s.getCLeft(), s.getMRght()+2, s.getCRght(), !s.boatOnLeft());
				if (isValidState(state)) {
					Node n = new Node(state);
					node.addChild(n);
					System.out.println("-- expand: " + n.getState());
				}
			}
			if (s.getCLeft() - 2 >= 0) {
				State state = new State(s.getMLeft(), s.getCLeft()-2, s.getMRght(), s.getCRght()+2, !s.boatOnLeft());
				if (isValidState(state)) {
					Node n = new Node(state);
					node.addChild(n);
					System.out.println("-- expand: " + n.getState());
				}
			}
		} else {
			if (s.getMRght() - 1 >= 0) {
				State state = new State(s.getMLeft()+1, s.getCLeft(), s.getMRght()-1, s.getCRght(), !s.boatOnLeft());
				if (isValidState(state)) {
					Node n = new Node(state);
					node.addChild(n);
					System.out.println("-- expand: " + n.getState());
				}
			}
			if (s.getCRght() - 1 >= 0) {
				State state = new State(s.getMLeft(), s.getCLeft()+1, s.getMRght(), s.getCRght()-1, !s.boatOnLeft());
				if (isValidState(state)) {
					Node n = new Node(state);
					node.addChild(n);
					System.out.println("-- expand: " + n.getState());
				}
			}
			if (s.getMRght() - 1 >= 0 && s.getCRght() - 1 >= 0) {
				State state = new State(s.getMLeft()+1, s.getCLeft()+1, s.getMRght()-1, s.getCRght()-1, !s.boatOnLeft());
				if (isValidState(state)) {
					Node n = new Node(state);
					node.addChild(n);
					System.out.println("-- expand: " + n.getState());
				}
			}
			if (s.getMRght() - 2 >= 0) {
				State state = new State(s.getMLeft()+2, s.getCLeft(), s.getMRght()-2, s.getCRght(), !s.boatOnLeft());
				if (isValidState(state)) {
					Node n = new Node(state);
					node.addChild(n);
					System.out.println("-- expand: " + n.getState());
				}
			}
			if (s.getCRght() - 2 >= 0) {
				State state = new State(s.getMLeft(), s.getCLeft()+2, s.getMRght(), s.getCRght()-2, !s.boatOnLeft());
				if (isValidState(state)) {
					Node n = new Node(state);
					node.addChild(n);
					System.out.println("-- expand: " + n.getState());
				}
			}
		}
	}
	
	private boolean isVisited(State state) {
		for (State s: visited) {
			if (state.compare(s)) {
				return true;
			}
		}
		return false;	
	}
	
	private boolean isValidState(State state) {
		if (!isVisited(state) && (state.getMLeft() >= state.getCLeft() || state.getMLeft() == 0) && (state.getMRght() >= state.getCRght() || state.getMRght() == 0)) {
			return true;
		} else {
			return false;
		}
	}

}
