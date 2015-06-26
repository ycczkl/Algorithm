
public class CountCompleteTreeNodes {
	//if left height == right height, left subtree is fulltree. else right subtree is full tree
	//if left height == right height, left subtree is fulltree. else right subtree is full tree
    public int countNodes(TreeNode root) {
        if (root == null) return 0;
        int h = getHeight(root);
        if (h < 0) return 0;
        if (getHeight(root.right) == h-1) {
            return (1<<h) + countNodes(root.right);
        } else {
            return (1<<h-1) + countNodes(root.left);
        }
    }
    private int getHeight(TreeNode root) {
        int height = 0;
        while (root != null) {
            root = root.left;
            height++;
        }
        return height-1;
    }
}
