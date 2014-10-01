class TreeNode {
	public int data;      
	public TreeNode left;    
	public TreeNode right; 
	public TreeNode parent;
	private int size = 0;

	public TreeNode(int d) {
		data = d;
		size = 1;
	}
	
	public void setLeftChild(TreeNode left) {
		this.left = left;
		if (left != null) {
			left.parent = this;
		}
	}
	
	public void setRightChild(TreeNode right) {
		this.right = right;
		if (right != null) {
			right.parent = this;
		}
	}
	
	public void insertInOrder(int d) {
		if (d <= data) {
			if (left == null) {
				setLeftChild(new TreeNode(d));
			} else {
				left.insertInOrder(d);
			}
		} else {
			if (right == null) {
				setRightChild(new TreeNode(d));
			} else {
				right.insertInOrder(d);
			}
		}
		size++;
	}
	
	public int size() {
		return size;
	}
	
	public boolean isBST() {
		if (left != null) {
			if (data < left.data || !left.isBST()) {
				return false;
			}
		}
		
		if (right != null) {
			if (data >= right.data || !right.isBST()) {
				return false;
			}
		}		
		
		return true;
	}
	
	public int height() {
		int leftHeight = left != null ? left.height() : 0;
		int rightHeight = right != null ? right.height() : 0;
		return 1 + Math.max(leftHeight, rightHeight);
	}
	
	public TreeNode find(int d) {
		if (d == data) {
			return this;
		} else if (d <= data) {
			return left != null ? left.find(d) : null;
		} else if (d > data) {
			return right != null ? right.find(d) : null;
		}
		return null;
	}
	
	private static TreeNode createMinimalBST(int arr[], int start, int end){
		if (end < start) {
			return null;
		}
		int mid = (start + end) / 2;
		TreeNode n = new TreeNode(arr[mid]);
		n.setLeftChild(createMinimalBST(arr, start, mid - 1));
		n.setRightChild(createMinimalBST(arr, mid + 1, end));
		return n;
	}
	
	public static TreeNode createMinimalBST(int array[]) {
		return createMinimalBST(array, 0, array.length - 1);
	}
	
	public void print() {
		BTreePrinter.printNode(this);
	}
} 

public class Question4_1 {
	public static int checkHeight(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int leftHeight = checkHeight(root.left);
		if (leftHeight == -1) {
			return -1;
		}
		
		int rightHeight = checkHeight(root.right);
		if (rightHeight == -1) {
			return -1;
		}
		
		int hightDiff = leftHeight - rightHeight;
		if (Math.abs(hightDiff) > 1) {
			return -1;
		} else {
			return Math.max(leftHeight, rightHeight) + 1;
		}
		
	}
	public static boolean isBalanced(TreeNode root) {
		if (checkHeight(root) == -1) {
			return false;
		} else {
			return true;
		}
	}
	
	public static void main(String[] args) {
		// Create balanced tree
		int[] array = {0, 1, 2, 3, 5, 6, 7, 8, 9, 10};
		TreeNode root = TreeNode.createMinimalBST(array);

		
		System.out.println("Is balanced? " + isBalanced(root));
		
		root.insertInOrder(4); // Add 4 to make it unbalanced

		System.out.println("Is balanced? " + isBalanced(root));
	}
}
