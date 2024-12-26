package Graphs;

import java.util.*;

public class CourseSchedule {

    private boolean dfs(int course, int[] state, List<Integer>[] graph, Stack<Integer> result) {
        if (state[course] == 1) { // Node is currently in the recursion stack (cycle detected)
            return false;
        }
        if (state[course] == 2) { // Node has already been processed
            return true;
        }

        // Mark the current node as being visited (in the recursion stack)
        state[course] = 1;

        // Recur for all the courses that depend on the current course
        for (int nextCourse : graph[course]) {
            if (!dfs(nextCourse, state, graph, result)) {
                return false;
            }
        }

        // Mark the node as processed and add it to the result stack
        state[course] = 2;
        result.push(course);

        return true;
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // Step 1: Build the graph
        List<Integer>[] graph = new ArrayList[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList<>();
        }

        // Fill the graph with the course dependencies (prerequisites)
        for (int[] prereq : prerequisites) {
            int course = prereq[0];
            int prerequisite = prereq[1];
            graph[prerequisite].add(course);
        }

        // Step 2: Perform DFS to find topological order
        int[] state = new int[numCourses]; // 0: unvisited, 1: visiting, 2: visited
        Stack<Integer> result = new Stack<>();

        // Step 3: Call DFS for every course to get the topological order
        for (int i = 0; i < numCourses; i++) {
            if (state[i] == 0) { // If the course is not visited
                if (!dfs(i, state, graph, result)) {
                    return new int[0]; // Cycle detected, return empty array
                }
            }
        }

        // Step 4: Convert the stack to an array and return the result
        int[] order = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            order[i] = result.pop();
        }

        return order;
    }

    public static void main(String[] args) {
        CourseSchedule solution = new CourseSchedule();

        // Test case 1
        int numCourses1 = 2;
        int[][] prerequisites1 = {{1, 0}};
        System.out.println(Arrays.toString(solution.findOrder(numCourses1, prerequisites1))); // Output: [0, 1]

        // Test case 2
        int numCourses2 = 4;
        int[][] prerequisites2 = {{1, 0}, {2, 0}, {3, 1}, {3, 2}};
        System.out.println(Arrays.toString(solution.findOrder(numCourses2, prerequisites2))); // Output: [0, 2, 1, 3]

        // Test case 3 (Cycle present)
        int numCourses3 = 2;
        int[][] prerequisites3 = {{1, 0}, {0, 1}};
        System.out.println(Arrays.toString(solution.findOrder(numCourses3, prerequisites3))); // Output: []
    }
}
