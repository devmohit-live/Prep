public class MaxAreaOfIsland_695 {

    int size = 0;

    public int maxAreaOfIsland(int[][] grid) {
        boolean visited[][] = new boolean[grid.length][grid[0].length];
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] != 0 && !visited[i][j]) {
                    size = 0;
                    connected(grid, i, j, visited);
                    res = Math.max(res, size);
                }
            }
        }
        return res;
    }

    void connected(int[][] grid, int i, int j, boolean[][] visited) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[i].length || grid[i][j] == 0 || visited[i][j] == true) {
            return;
        } else {
            size++;
            visited[i][j] = true;
        }

        connected(grid, i + 1, j, visited);
        connected(grid, i, j + 1, visited);
        connected(grid, i - 1, j, visited);
        connected(grid, i, j - 1, visited);

    }

}