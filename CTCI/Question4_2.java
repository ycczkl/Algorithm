import java.util.LinkedList;

class Node {
    private Node adjacent[];
    public int adjacentCount;
    private String vertex;    
    public Question4_2.State state;
    public Node(String vertex, int adjacentLength) {
        this.vertex = vertex;                
        adjacentCount = 0;        
        adjacent = new Node[adjacentLength];
    }
    
    public void addAdjacent(Node x) {
        if (adjacentCount < 30) {
            this.adjacent[adjacentCount] = x;
            adjacentCount++;
        } else {
            System.out.print("No more adjacent can be added");
        }
    }
    public Node[] getAdjacent() {
        return adjacent;
    }
    public String getVertex() {
        return vertex;
    }
}

class Graph {
	private Node vertices[];
	public int count;
	public Graph() {
		vertices = new Node[6];
		count = 0;
    }
	
    public void addNode(Node x) {
		if (count < 30) {
			vertices[count] = x;
			count++;
		} else {
			System.out.print("Graph full");
		}
    }
    
    public Node[] getNodes() {
        return vertices;
    }
}
public class Question4_2 {
	public enum State {
		Unvisited, Visited, Visiting;
	}
	
	public static boolean search(Graph g, Node start, Node end) {
		LinkedList<Node> list = new LinkedList<Node>();
		for (Node n : g.getNodes()) {
			n.state = State.Unvisited;
		}
		start.state = State.Visiting;
		list.add(start);
		Node u;
		while (!list.isEmpty()) {
			u = list.remove();
			if (u != null) {
				for (Node v : u.getAdjacent()) {
					if (v.state == State.Unvisited) {
						if (v == end) {
							return true;
						} else {
							v.state = State.Visiting;
							list.addFirst(v);
						}
						
					}					
				}
				u.state = State.Visited;
			}
		}
		return false;
	}
}
