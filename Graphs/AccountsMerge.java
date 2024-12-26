package Graphs;

import java.util.*;

class AccountsMerge {

    // Disjoint Set Union (Union-Find) with path compression and union by rank
    class UnionFind {
        Map<String, String> parent;
        Map<String, Integer> rank;

        public UnionFind() {
            parent = new HashMap<>();
            rank = new HashMap<>();
        }

        // Find the root of the email (with path compression)
        public String find(String email) {
            if (!parent.containsKey(email)) {
                parent.put(email, email);
                rank.put(email, 0);
            }
            if (!parent.get(email).equals(email)) {
                parent.put(email, find(parent.get(email))); // Path compression
            }
            return parent.get(email);
        }

        // Union two emails into the same group
        public void union(String email1, String email2) {
            String root1 = find(email1);
            String root2 = find(email2);

            if (!root1.equals(root2)) {
                // Union by rank: attach the smaller tree under the larger one
                if (rank.get(root1) > rank.get(root2)) {
                    parent.put(root2, root1);
                } else if (rank.get(root1) < rank.get(root2)) {
                    parent.put(root1, root2);
                } else {
                    parent.put(root2, root1);
                    rank.put(root1, rank.get(root1) + 1);
                }
            }
        }
    }

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        UnionFind uf = new UnionFind();
        Map<String, String> emailToName = new HashMap<>();

        // Step 1: Process each account
        for (List<String> account : accounts) {
            String name = account.get(0);
            String firstEmail = account.get(1);
            emailToName.put(firstEmail, name);

            // Union all emails in the current account
            for (int i = 2; i < account.size(); i++) {
                uf.union(firstEmail, account.get(i));
                emailToName.put(account.get(i), name); // All emails are associated with the same name
            }
        }

        // Step 2: Group emails by their root email
        Map<String, List<String>> rootToEmails = new HashMap<>();
        for (String email : emailToName.keySet()) {
            String root = uf.find(email);
            rootToEmails.computeIfAbsent(root, k -> new ArrayList<>()).add(email);
        }

        // Step 3: Prepare the result
        List<List<String>> result = new ArrayList<>();
        for (List<String> emails : rootToEmails.values()) {
            Collections.sort(emails); // Sort emails lexicographically
            String name = emailToName.get(emails.get(0)); // Get the name from the first email
            List<String> mergedAccount = new ArrayList<>();
            mergedAccount.add(name);
            mergedAccount.addAll(emails);
            result.add(mergedAccount);
        }

        return result;
    }

    public static void main(String[] args) {
        AccountsMerge solution = new AccountsMerge();

        // Example accounts:
        List<List<String>> accounts = new ArrayList<>();
        accounts.add(Arrays.asList("John", "johnsmith@mail.com", "john00@mail.com"));
        accounts.add(Arrays.asList("John", "johnnybravo@mail.com"));
        accounts.add(Arrays.asList("John", "johnsmith@mail.com", "john_newyork@mail.com"));
        accounts.add(Arrays.asList("Mary", "mary@mail.com"));

        // Call the function
        List<List<String>> mergedAccounts = solution.accountsMerge(accounts);

        // Print the merged accounts
        for (List<String> account : mergedAccounts) {
            System.out.println(account);
        }
    }
}
