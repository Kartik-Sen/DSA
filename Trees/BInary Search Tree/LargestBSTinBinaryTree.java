public class LargestBSTinBinaryTree {
    static class Node {
        int data;
        Node left, right;

        Node(int val) {
            data = val;
            left = null;
            right = null;
        }
    }

    // Information about the subtree: Minimum value,
    // Maximum value, and Size of the largest BST
    static class BSTInfo {
        int min;
        int max;
        int mxSz;

        BSTInfo(int mn, int mx, int sz) {
            min = mn;
            max = mx;
            mxSz = sz;
        }
    }

    // Function to determine the largest BST in the binary
    // tree
    static BSTInfo largestBstBt(Node root) {
        if (root == null)
            return new BSTInfo(Integer.MAX_VALUE,
                    Integer.MIN_VALUE, 0);

        BSTInfo left = largestBstBt(root.left);
        BSTInfo right = largestBstBt(root.right);

        // Check if the current subtree is a BST
        if (left.max < root.data && right.min > root.data) {
            return new BSTInfo(Math.min(left.min, root.data),
                    Math.max(right.max, root.data),
                    1 + left.mxSz + right.mxSz);
        }

        return new BSTInfo(Integer.MIN_VALUE,
                Integer.MAX_VALUE,
                Math.max(left.mxSz, right.mxSz));
    }

    // Function to return the size of the largest BST
    static int largestBst(Node root) {
        return largestBstBt(root).mxSz;
    }

    public static void main(String[] args) {

        // Constructed binary tree looks like this:
        // 60
        // / \
        // 65 70
        // /
        // 50
        Node root = new Node(60);
        root.left = new Node(65);
        root.right = new Node(70);
        root.left.left = new Node(50);

        System.out.println(largestBst(root));
    }

}
