public class LCAinBinarySearchTree {
    static class Node {
        int data;
        Node left, right;

        public Node(int val) {
            data = val;
            left = right = null;
        }
    }

    // Iterative method to find the LCA of two nodes p and q in a BST
    public static Node findLCA(Node root, Node p, Node q) {
        while (root != null) {
            // If both p and q are smaller than root, LCA must be in the left subtree
            if (p.data < root.data && q.data < root.data) {
                root = root.left;
            }
            // If both p and q are larger than root, LCA must be in the right subtree
            else if (p.data > root.data && q.data > root.data) {
                root = root.right;
            }
            // If one of p or q is smaller and the other is larger, root is the LCA
            else {
                return root;
            }
        }
        return null; // If root is null, return null (LCA doesn't exist)
    }

    public static void main(String[] args) {
        // Creating a sample BST
        Node root = new Node(20);
        root.left = new Node(10);
        root.right = new Node(30);
        root.left.left = new Node(5);
        root.left.right = new Node(15);
        root.right.left = new Node(25);
        root.right.right = new Node(35);

        Node p = root.left.left; // Node 5
        Node q = root.left.right; // Node 15

        Node lca = findLCA(root, p, q);
        if (lca != null) {
            System.out.println("LCA of " + p.data + " and " + q.data + " is " + lca.data);
        } else {
            System.out.println("LCA does not exist.");
        }
    }
}
