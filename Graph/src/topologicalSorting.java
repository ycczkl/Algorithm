import java.util.*;

class DirectedGraphNode {
	int label;
	ArrayList<DirectedGraphNode> neighbors;

	DirectedGraphNode(int x) {
		label = x;
		neighbors = new ArrayList<DirectedGraphNode>();
	}
};

/*
 * Given an directed graph, a topological order of the graph nodes is defined as
 * follow:
 * 
 * For each directed edge A-->B in graph, A must before B in the order list. The
 * first node in the order can be any node in the graph with no nodes direct to
 * it.
 * 
 * Find any topological order for the given graph
 */
public class topologicalSorting {
	/**
	 * @param graph
	 *            : A list of Directed graph node
	 * @return: Any topological order for the given graph.
	 */
	// DFS
	public ArrayList<DirectedGraphNode> topSort(
			ArrayList<DirectedGraphNode> graph) {
		ArrayList<DirectedGraphNode> res = new ArrayList<DirectedGraphNode>();
		if (graph == null || graph.size() == 0)
			return res;
		HashMap<DirectedGraphNode, Boolean> visit = new HashMap<DirectedGraphNode, Boolean>();
		for (int i = 0; i < graph.size(); i++) {
			if (!visit.containsKey(graph.get(i))) {
				dfs(graph.get(i), visit, res);
			}
		}
		Collections.reverse(res);
		return res;
	}

	private void dfs(DirectedGraphNode cur,
			HashMap<DirectedGraphNode, Boolean> visit,
			ArrayList<DirectedGraphNode> res) {
		visit.put(cur, true);
		for (DirectedGraphNode node : cur.neighbors) {
			if (!visit.containsKey(node)) {
				dfs(node, visit, res);
			}
		}
		res.add(cur);
		return;
	}

	// BFS
	public ArrayList<DirectedGraphNode> topSortBFS(
			ArrayList<DirectedGraphNode> graph) {
		ArrayList<DirectedGraphNode> res = new ArrayList<DirectedGraphNode>();
		if (graph == null || graph.size() == 0)
			return res;
		HashMap<DirectedGraphNode, Integer> map = new HashMap<DirectedGraphNode, Integer>();
		for (DirectedGraphNode n : graph) {
			if (!map.containsKey(n)) {
				map.put(n, 0);
			}
			for (DirectedGraphNode neighbor : n.neighbors) {
				if (map.containsKey(neighbor)) {
					map.put(neighbor, map.get(neighbor) + 1);
				} else {
					map.put(neighbor, 1);
				}
			}

		}
		Queue<DirectedGraphNode> queue = new LinkedList<DirectedGraphNode>();
		for (DirectedGraphNode n : graph) {
			if (map.get(n) == 0) {
				queue.offer(n);
				map.remove(n);
			}
		}
		while (!queue.isEmpty()) {
			DirectedGraphNode node = queue.poll();
			res.add(node);
			for (DirectedGraphNode n : node.neighbors) {
				if (map.containsKey(n)) {
					map.put(n, map.get(n) - 1);
					if (map.get(n) == 0) {
						queue.add(n);
						map.remove(n);
					}
				}
			}
		}
		return res;
	}
}
