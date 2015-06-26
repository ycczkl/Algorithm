import java.util.*;
/*
 *  Clone an undirected graph. Each node in the graph contains a label and a list of its neighbors.

OJ's undirected graph serialization:

Nodes are labeled uniquely.
We use # as a separator for each node, and , as a separator for node label and each neighbor of the node.

As an example, consider the serialized graph {0,1,2#1,2#2,2}.

The graph has a total of three nodes, and therefore contains three parts as separated by #.

    First node is labeled as 0. Connect node 0 to both nodes 1 and 2.
    Second node is labeled as 1. Connect node 1 to node 2.
    Third node is labeled as 2. Connect node 2 to node 2 (itself), thus forming a self-cycle.

Visually, the graph looks like the following:

       1
      / \
     /   \
    0 --- 2
         / \
         \_/

 */
//与copy linked list with random pointer相似，此题为无向连通图，BFS+HashMap
public class cloneGraph {
	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
		if (node == null)
			return node;
		HashMap<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
		Queue<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
		queue.offer(node);
		map.put(node, new UndirectedGraphNode(node.label));
		while (!queue.isEmpty()) {
		    UndirectedGraphNode n = queue.poll();
			List<UndirectedGraphNode> list = n.neighbors;
			for (UndirectedGraphNode cur : list) {
				if (!map.containsKey(cur)) {
					map.put(cur, new UndirectedGraphNode(cur.label));
					queue.offer(cur);
				}
				map.get(n).neighbors.add(map.get(cur));
			}
		}
		return map.get(node);
	}
}
