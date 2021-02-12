import java.io.*;
import java.util.*;

public class Main {

    static class Pair implements Comparable<Pair>{
        int row;
        long sum;

        Pair(int r,long s){
            this.row=r;
            this.sum=s;
        }

		@Override
		public int compareTo(Pair o) {
			return this.sum-o.sum;
        }
    }


    public static void main(String[] args)throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        int arr[][]=new int[n][n];
        boolean visited[]=new boolean[n]; //for columns
        Pair rsum[]=new Pair[n];
        
        //inp
        for (int i = 0; i < arr.length; i++) {
            long sum=0;
            String[] s=br.readLine().split(" ");
            for (int j = 0; j < arr.length; j++) {
                arr[i][j]=Integer.parseInt(s[j]);
                sum+=arr[i][j];
            }
            rsum[i]=new Pair(i,sum);
        }
        long netsum=0;

        Arrays.sort(rsum); //O(nlogn)
        //min sum wale row mw jaake uska max col value find krenge or us column ko visited mark kr denge

        findmax()
        while (true) {
        }
        
        
        // for (int i = 0; i < n; i++) {
            
        // }

    }
}