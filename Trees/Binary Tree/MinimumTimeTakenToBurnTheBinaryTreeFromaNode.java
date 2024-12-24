import java.util.*;

public class MinimumTimeTakenToBurnTheBinaryTreeFromaNode {
    static class Node {
        int data;
        Node left, right;

        Node(int x) {
            data = x;
            left = null;
            right = null;
        }
    }

    static int minTime(Node root, int target) {

        // Base case
        if (root == null)
            return -1;

        Queue<Node> q = new LinkedList<>();
        q.add(root);
        Node tar = null;

        // HashMap to map the child nodes to
        // their parent nodes
        Map<Node, Node> par = new HashMap<>();
        par.put(root, null);

        while (!q.isEmpty()) {
            Node curr = q.poll();

            // Set tar = curr if value is equal
            if (curr.data == target)
                tar = curr;

            // Map the left child to its parent
            if (curr.left != null) {
                par.put(curr.left, curr);
                q.add(curr.left);
            }

            // Map the right child to its parent
            if (curr.right != null) {
                par.put(curr.right, curr);
                q.add(curr.right);
            }
        }

        // HashMap to check if a node has
        // been visited or not
        Map<Node, Boolean> vis = new HashMap<>();

        int ans = -1;

        q.add(tar);

        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                Node curr = q.poll();
                vis.put(curr, true);

                // Push the left child node
                if (curr.left != null
                        && !vis.getOrDefault(curr.left, false))
                    q.add(curr.left);

                // Push the right child node
                if (curr.right != null
                        && !vis.getOrDefault(curr.right, false))
                    q.add(curr.right);

                // Push the parent node
                if (par.get(curr) != null
                        && !vis.getOrDefault(par.get(curr),
                                false))
                    q.add(par.get(curr));
            }

            // Increment the answer
            ans++;
        }

        return ans;
    }

    public static void main(String[] args) {

        // Create a hard coded tree
        // 10
        // / \
        // 5 50
        // / / \
        // 1 40 100
        Node root = new Node(10);
        root.left = new Node(5);
        root.right = new Node(50);
        root.left.left = new Node(1);
        root.right.left = new Node(40);
        root.right.right = new Node(100);

        int target = 50;

        System.out.println(minTime(root, target));
    }
}
