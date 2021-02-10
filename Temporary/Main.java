import java.io.BufferedReader;
import java.io.IOException;

import jdk.internal.org.jline.utils.InputStreamReader;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        int arr[][]=new int[n][n];
        boolean visited[][]=new boolean[n][n];
        int rsum[]=new int[n];
        int 
        //min sum wale row mw jaake uska max find krenge or us column ko visited mark kr denge
        //inp
        for (int i = 0; i < arr.length; i++) {
            String[] s=br.readLine().split(" ");
            for (int j = 0; j < arr.length; j++) {
                arr[i][j]=Integer.parseInt(s[j])
            }
        }


    }
}