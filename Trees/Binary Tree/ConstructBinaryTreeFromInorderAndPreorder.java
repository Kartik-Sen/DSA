import java.util.*;

public class ConstructBinaryTreeFromInorderAndPreorder {
    // Node structure for the binary tree
    static class Node {
        int data;
        Node left;
        Node right;

        // Constructor to initialize the node with a value
        public Node(int val) {
            data = val;
            left = null;
            right = null;
        }
    }

    // Method to build the tree from preorder and inorder traversals
    public static Node buildTree(int[] preOrder, int[] inOrder) {
        Map<Integer, Integer> inOrderIndexMap = new HashMap<>();
        // Store the index of each value in the inorder array for quick lookup
        for (int i = 0; i < inOrder.length; i++) {
            inOrderIndexMap.put(inOrder[i], i);
        }

        // Start the recursion to build the tree
        return splitTree(preOrder, inOrderIndexMap, 0, 0, inOrder.length - 1);
    }

    // Helper method to recursively build the tree
    private static Node splitTree(int[] preOrder, Map<Integer, Integer> inOrderIndexMap,
            int rootIndex, int left, int right) {
        // Base case: if there are no nodes to process
        if (left > right) {
            return null;
        }

        // Create the root node from the preorder array
        Node root = new Node(preOrder[rootIndex]);

        // Find the root index in the inorder array
        int mid = inOrderIndexMap.get(preOrder[rootIndex]);

        // Recursively build the left subtree
        root.left = splitTree(preOrder, inOrderIndexMap, rootIndex + 1, left, mid - 1);

        // Recursively build the right subtree
        // The rootIndex for the right subtree is calculated by moving past the left
        // subtree
        root.right = splitTree(preOrder, inOrderIndexMap,
                rootIndex + (mid - left + 1), mid + 1, right);

        return root;
    }

    // Helper function for printing the tree (inorder traversal)
    public static void printTree(Node root) {
        if (root != null) {
            printTree(root.left);
            System.out.print(root.data + " ");
            printTree(root.right);
        }
    }

    public static void main(String[] args) {
        // Example preorder and inorder traversals
        int[] preOrder = { 3, 9, 20, 15, 7 };
        int[] inOrder = { 9, 3, 15, 20, 7 };

        // Build the tree
        Node root = buildTree(preOrder, inOrder);

        // Print the inorder traversal of the constructed tree
        System.out.println("Inorder of the constructed tree:");
        printTree(root); // Expected output: 9 3 15 20 7
    }
}
