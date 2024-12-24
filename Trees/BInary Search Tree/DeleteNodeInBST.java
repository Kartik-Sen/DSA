public class DeleteNodeInBST {

    // Definition for a binary tree node
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    // Method to delete a node in BST
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }

        // Find the node to be deleted
        if (key < root.val) {
            root.left = deleteNode(root.left, key); // Recur on left subtree
        } else if (key > root.val) {
            root.right = deleteNode(root.right, key); // Recur on right subtree
        } else {
            // Case 1: Node with only one child or no child
            if (root.left == null) {
                return root.right; // If no left child, return right child
            } else if (root.right == null) {
                return root.left; // If no right child, return left child
            }

            // Case 2: Node with two children, get the inorder successor (smallest in the
            // right subtree)
            TreeNode successor = getMin(root.right); // Find the inorder successor (smallest in the right subtree)
            root.val = successor.val; // Replace node's value with the successor's value
            root.right = deleteNode(root.right, successor.val); // Delete the inorder successor
        }

        return root;
    }

    // Helper function to find the minimum node in the tree (leftmost node)
    private TreeNode getMin(TreeNode node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    // Method to insert a node into the BST (for testing purposes)
    public TreeNode insert(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }

        if (val < root.val) {
            root.left = insert(root.left, val);
        } else {
            root.right = insert(root.right, val);
        }

        return root;
    }

    // Helper function for inorder traversal (to print the tree)
    public void inorderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        inorderTraversal(root.left);
        System.out.print(root.val + " ");
        inorderTraversal(root.right);
    }

    public static void main(String[] args) {
        DeleteNodeInBST bst = new DeleteNodeInBST();
        TreeNode root = null;

        // Insert nodes into the BST
        int[] values = { 5, 3, 8, 2, 4, 7, 9 };
        for (int val : values) {
            root = bst.insert(root, val);
        }

        System.out.println("Inorder traversal before deletion:");
        bst.inorderTraversal(root); // Expected output: 2 3 4 5 7 8 9
        System.out.println();

        // Delete node with key 3
        root = bst.deleteNode(root, 3);
        System.out.println("Inorder traversal after deleting 3:");
        bst.inorderTraversal(root); // Expected output: 2 4 5 7 8 9
        System.out.println();

        // Delete node with key 8 (node with two children)
        root = bst.deleteNode(root, 8);
        System.out.println("Inorder traversal after deleting 8:");
        bst.inorderTraversal(root); // Expected output: 2 4 5 7 9
        System.out.println();
    }
}
