public class LCAinBinaryTree {
    static class Node {
        int data;
        Node left, right;

        public Node(int val) {
            data = val;
            left = right = null;
        }
    }

    public static class LCAInBinaryTree {

        // Function to find the LCA of two nodes p and q
        public static Node findLCA(Node root, Node p, Node q) {
            // Base case: If root is null, or root is either p or q
            if (root == null || root == p || root == q) {
                return root;
            }

            // Recursively find LCA in the left and right subtrees
            Node leftLCA = findLCA(root.left, p, q);
            Node rightLCA = findLCA(root.right, p, q);

            // If both left and right subtrees return non-null, root is the LCA
            if (leftLCA != null && rightLCA != null) {
                return root;
            }

            // Otherwise, return the non-null child (either leftLCA or rightLCA)
            return (leftLCA != null) ? leftLCA : rightLCA;
        }

        public static void main(String[] args) {
            // Creating a sample binary tree
            Node root = new Node(1);
            root.left = new Node(2);
            root.right = new Node(3);
            root.left.left = new Node(4);
            root.left.right = new Node(5);
            root.right.left = new Node(6);
            root.right.right = new Node(7);
            root.left.left.left = new Node(8);
            root.left.left.right = new Node(9);

            Node p = root.left.left; // Node 4
            Node q = root.left.right; // Node 5

            Node lca = findLCA(root, p, q);
            if (lca != null) {
                System.out.println("LCA of " + p.data + " and " + q.data + " is " + lca.data);
            } else {
                System.out.println("LCA does not exist.");
            }
        }
    }
}
