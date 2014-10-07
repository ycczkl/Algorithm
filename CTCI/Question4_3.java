
public class Question4_3 {
	TreeNode creatMinimalBST(int arr[], int start, int end) {
		if (end < start) {
			return null;
		}
		int mid = (start + end)/2;
		TreeNode n = new TreeNode(arr[mid]);
		n.setLeftChild(creatMinimalBST(arr, start, mid - 1));
		n.setRightChild(creatMinimalBST(arr, mid + 1, end));
		return n;
	}
	
	TreeNode creatMinimalBST(int arr[]) {
		return creatMinimalBST(arr, 0, arr.length - 1);
	}
	
	public static void main(String[] args) {
		int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		
		// We needed this code for other files, so check out the code in the library
		TreeNode root = TreeNode.createMinimalBST(array);
		System.out.println("Root? " + root.data);
		System.out.println("Created BST? " + root.isBST());
		System.out.println("Height: " + root.height());
	}
}
