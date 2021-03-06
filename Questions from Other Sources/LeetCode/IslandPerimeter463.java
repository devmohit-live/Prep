pubic class IslandPerimeter463{
    /**
     * 
     * 
     */

     //Checking for each edge contribution adjacent to water: 
     public static int perimeter1(int[][] grid){
         int sum = 0;
        if (grid == null || grid.length == 0 || grid[0].length == 0) return sum;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0)
                    continue;
                if (i == 0 || grid[i-1][j] == 0) sum++;
                if (i == grid.length - 1 || grid[i+1][j] == 0) sum++;
                if (j == 0 || grid[i][j-1] == 0) sum++;
                if (j == grid[0].length - 1 || grid[i][j+1] == 0) sum++;
            }
        }
        return sum;
     }

     //Using Internal and External Land contributing to perimeter
     public static int perimeter2(int[][] grid) {
         for(int i=0;i<m;i++){
        for(int j=0;j<n;j++){
          
          if(grid[i][j]==1){
            perimeter+=4;
            //internal lands  -> surrounded by other lands looses 2 edges
            //checking for previous row and columns as we have been moving from 0 to n
            if(i>0 && grid[i-1][j]==1) perimeter-=2;
            if(j>0 && grid[i][j-1]==1) perimeter-=2;
          }
          
        }
      }
      return perimeter;
     }
     
     //Using dfs approach(old method) dfs in all 4 directions (classic)
     // but increases the runtime in this case
     public static int perimeter3(int[][] grid) {
         int result=0;
         boolean visited[][] =new boolean[grid.length][grid[0].length];
         for (int i = 0; i < grid.length; i++) {
             for (int j = 0; j < grid[0].length; j++) {
                 if(grid[i][j]!=0 && !visited[i][j]){
                     return dfs(grid,i,j,visited);
                 }
             }
            }
        }
        
        private static int dfs(int[][] grid,int i,int j,boolean[][] visited) {
             // check if the cell is already visisted and return 0
            if (visited[row][col]) {
                return 0;
            }
            // Check boundary conditions and return 1, since it is water
            if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length) {
                return 1;
            }

            // Check if the cell is water and return 1. No need to do a DFS
            if (grid[row][col] == 0) {
                return 1;
            }
            // mark cuurent cell as visted
            visited[row][col] = true;
            
            // calculate perimeter in all four directions, do not add one here since we are return 1 from the base case if it is water.
            int count = getPerimeterDFS(grid, visited, row + 1, col)
                    + getPerimeterDFS(grid, visited, row - 1, col)
                    + getPerimeterDFS(grid, visited, row, col - 1)
                    + getPerimeterDFS(grid, visited, row, col + 1);
            
            //return the perimeter
             return count;
     }

}