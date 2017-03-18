import java.util.LinkedList;

public class Node {
	
	private State state;
	private LinkedList<Node> childNodes;
	
	public Node(State state) {
		this.state = state;
		this.childNodes = new LinkedList<Node>();
	}
	
	public void addChild(Node node) {
		childNodes.add(node);
	}
	
	public State getState() {
		return state;
	}
	
	public LinkedList<Node> getChildNodes() {
		return childNodes;
	}
	
	@Override
	public String toString() {
		return state.toString();
	}

}
