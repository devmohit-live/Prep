class Solution {
  
    int[][]dirs = {{0,-1},{0,1},{-1,0},{1,0}};
    public void solve(char[][] board) {
      int n = board.length, m = board[0].length;
        // turn all O to -
      for(int i=0;i<n;i++){
        for(int j=0;j<m;j++) if(board[i][j]=='O' ) board[i][j] = '-';
      }
      
        // apply floodfill to boundries -> change all - to 0 again who are in reach
        
      for(int i=0,j=0; j<m; j++) if(board[i][j]=='-') floodfill(board,i,j); 
      for(int i=n-1 ,j=0; j<m  ;j++) if(board[i][j]=='-') floodfill(board,i,j); 
      for(int i=0 ,j=0; i<n ;i++) if(board[i][j]=='-') floodfill(board,i,j); 
      for(int i=0 ,j=m-1; i<n ;i++) if(board[i][j]=='-') floodfill(board,i,j); 
       
      // Arrays.stream(board).forEach(arr->System.out.println(Arrays.toString(arr)));
     
      
        // now change all the left - to x
        for(int i=0;i<n;i++){
        for(int j=0;j<m;j++) if(board[i][j]=='-') board[i][j] = 'X';

      }
      
      
    }
   
  
    private void floodfill(char[][] board, int i,int j){
      board[i][j]='O';
      
      for(int[] d: dirs){
        int r = i +d[0];
        int c = j +d[1];
        if(r>=0 && r< board.length && c>=0 && c<board[0].length && board[r][c]=='-'){
                floodfill(board,r,c);
        }
           
      }
    }
  
  
  
}