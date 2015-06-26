import java.util.*;
/*
 * Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).

Example
Given binary tree {3,9,20,#,#,15,7},

    3
   / \
  9  20
    /  \
   15   7
 */

public class binaryTreeZigzagLevelOrderTraversal {
	//思路与level order traverse一致，加一个数查看层数，偶数翻转。
	public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if (root == null)
            return res;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        int level = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            ArrayList<Integer> list = new ArrayList<Integer>();
            for (int i = 0; i < size; i++) {
                TreeNode n = queue.poll();
                list.add(n.val);
                if (n.left != null) {
                    queue.offer(n.left);
                }
                if (n.right != null) {
                    queue.offer(n.right);
                }
            }
            if (level++ % 2 == 0)
                Collections.reverse(list);
            res.add(list);    
        }
        return res;
    }
}

