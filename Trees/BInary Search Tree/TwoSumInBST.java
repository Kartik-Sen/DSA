import java.util.*;

public class TwoSumInBST {
    static class Node {
        int data;
        Node left, right;

        public Node(int val) {
            data = val;
            left = right = null;
        }
    }

    // Helper function to perform inorder traversal and store the elements in a list
    public static void inorderTraversal(Node root, List<Integer> result) {
        if (root == null)
            return;
        inorderTraversal(root.left, result);
        result.add(root.data);
        inorderTraversal(root.right, result);
    }

    // Function to find if there are two numbers in the BST that add up to the
    // target
    public static boolean twoSum(Node root, int target) {
        // Step 1: Get the inorder traversal of the BST
        List<Integer> inorderList = new ArrayList<>();
        inorderTraversal(root, inorderList);

        // Step 2: Use two pointers to find two elements that sum up to the target
        int left = 0;
        int right = inorderList.size() - 1;

        while (left < right) {
            int sum = inorderList.get(left) + inorderList.get(right);

            if (sum == target) {
                // Found the pair
                System.out.println(
                        "Found pair: " + inorderList.get(left) + " + " + inorderList.get(right) + " = " + target);
                return true;
            } else if (sum < target) {
                // Increase the sum by moving the left pointer to the right
                left++;
            } else {
                // Decrease the sum by moving the right pointer to the left
                right--;
            }
        }

        // No pair found
        System.out.println("No such pair found.");
        return false;
    }

    public static void main(String[] args) {
        // Creating the BST from the given input
        Node root = new Node(5);
        root.left = new Node(3);
        root.right = new Node(6);
        root.left.left = new Node(2);
        root.left.right = new Node(4);
        root.right.right = new Node(7);

        int target = 9;
        boolean found = twoSum(root, target);

        if (!found) {
            System.out.println("No two sum found for the target " + target);
        }
    }
}
