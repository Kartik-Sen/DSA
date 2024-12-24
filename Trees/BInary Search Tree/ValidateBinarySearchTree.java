class ValidateBinarySearchTree {
    static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean isValidBST(TreeNode root) {
        TreeNode current = root, prev = null;

        while (current != null) {
            // If left child exists, make a thread to the current node
            if (current.left != null) {
                TreeNode pre = current.left;

                // Find the rightmost node in the left subtree
                while (pre.right != null && pre.right != current) {
                    pre = pre.right;
                }

                // If the rightmost node's right is null, make a thread to current
                if (pre.right == null) {
                    pre.right = current;
                    current = current.left;
                } else {
                    // If the rightmost node's right points to current, we've finished the left
                    // subtree
                    pre.right = null;

                    // Check if the previous node's value is greater than the current node's value
                    if (prev != null && current.val <= prev.val) {
                        return false;
                    }
                    prev = current; // Update prev to the current node

                    // Move to the right subtree
                    current = current.right;
                }
            } else {
                // No left child, so check current node and move to the right subtree
                if (prev != null && current.val <= prev.val) {
                    return false;
                }
                prev = current;
                current = current.right;
            }
        }

        return true; // If we reach here, the tree is a valid BST
    }

    public static void main(String[] args) {
        // Create a sample binary tree
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);

        ValidateBinarySearchTree solution = new ValidateBinarySearchTree();
        System.out.println("Is the tree a valid BST? " + solution.isValidBST(root)); // Output: true

        // Invalid BST example
        TreeNode root2 = new TreeNode(5);
        root2.left = new TreeNode(1);
        root2.right = new TreeNode(4);
        root2.right.left = new TreeNode(3);
        root2.right.right = new TreeNode(6);

        System.out.println("Is the tree a valid BST? " + solution.isValidBST(root2)); // Output: false
    }
}
