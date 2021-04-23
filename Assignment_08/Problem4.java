public class Problem4 {
    public int numIslands(char[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++)
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    dfsFill(grid, i, j);
                    count++;
                }
            }
        return count;
    }

    private void dfsFill(char[][] grid, int i, int j) {
        if (i >= 0 && j >= 0 && i < grid.length && j < grid[0].length && grid[i][j] == '1') {
            grid[i][j] = '0';
            dfsFill(grid, i, j + 1);
            dfsFill(grid, i, j - 1);
            dfsFill(grid, i + 1, j);
            dfsFill(grid, i - 1, j);
        }
    }

    public static void main(String[] agrs) {
        Problem4 problem4 = new Problem4();

        // Test case 1
        char[][] grid1 = { { '1', '1', '1', '1', '0' }, { '1', '1', '0', '1', '0' }, { '1', '1', '0', '0', '0' },
                { '0', '0', '0', '0', '0' } };
        System.out.println("Number of Islands in grid1: " + problem4.numIslands(grid1));

        // Test case 2
        char[][] grid2 = { { '1', '1', '0', '0', '0' }, { '1', '1', '0', '0', '0' }, { '0', '0', '1', '0', '0' },
                { '0', '0', '0', '1', '1' } };

        System.out.println("Number of Islands in grid2: " + problem4.numIslands(grid2));
    }
}
