public class FindTheNumberOfIslands {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        
        int rows = grid.length;
        int cols = grid[0].length;
        int islandCount = 0;
        
        // Iterate through each cell in the grid
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == '1') { // Start of a new island
                    islandCount++;
                    dfs(grid, r, c); // Visit all land cells in the island
                }
            }
        }
        
        return islandCount;
    }

    // DFS to mark all cells of the island as visited (turn them into water '0')
    private void dfs(char[][] grid, int r, int c) {
        // Check boundaries and if the current cell is water ('0')
        if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length || grid[r][c] == '0') {
            return;
        }
        
        // Mark current cell as visited by changing it to water
        grid[r][c] = '0';
        
        // Explore in all 4 directions (down, up, right, left)
        dfs(grid, r + 1, c);  // down
        dfs(grid, r - 1, c);  // up
        dfs(grid, r, c + 1);  // right
        dfs(grid, r, c - 1);  // left
    }

    public static void main(String[] args) {
        FindTheNumberOfIslands solution = new FindTheNumberOfIslands();
        
        // Example grid
        char[][] grid = {
            {'1', '1', '0', '0', '0'},
            {'1', '1', '0', '0', '0'},
            {'0', '0', '1', '0', '0'},
            {'0', '0', '0', '1', '1'}
        };
        
        int result = solution.numIslands(grid);
        System.out.println("Number of islands: " + result); // Output should be 3
    }
}
