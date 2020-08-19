class FloodFill{
    
    public static void main(String[] args) {
        int ar[][]={
        {1,1,1,1,1,1,1,1},
        {1,1,1,1,1,1,0,0},
        {1,0,0,1,1,0,1,1},
        {1,2,2,2,2,0,1,0},
        {1,1,1,2,2,0,1,0},
        {1,1,1,2,2,2,2,0},
        {1,1,1,1,1,2,1,1},
        {1,1,1,1,1,2,2,1}
    };
        // 1-->3 source of flood fill is 2,4
        floodfill(ar,2,4,3,1);
        for(int i=0;i<ar.length;i++){
            for(int j=0;j<ar[0].length;j++)
            System.out.print(ar[i][j]);
            System.out.println();
        }
        
    }


    static void floodfill(int[][]ar,int r ,int c,int tofill,int prevfill){
            int rows=ar.length-1;
            int columns=ar[0].length-1;
        //base
        if(r<0 || r>rows || c<0 || c>columns || ar[r][c]!=prevfill){
            return;
        }
            ar[r][c]=tofill;
        //all 4 directions cells containing same color has to be updated
            floodfill(ar,r-1,c,tofill,prevfill); //up
            floodfill(ar,r+1,c,tofill,prevfill); //down
            floodfill(ar,r,c-1,tofill,prevfill); //left
            floodfill(ar,r,c+1,tofill,prevfill); //right
    }
}