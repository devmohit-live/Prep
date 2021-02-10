import java.io.*;
import java.util.*;

public class MaGetCommon2in {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        /*
         * // Approach 1 HashMap<Integer,Integer> set1=new HashMap<>();
         * HashMap<Integer,Integer> set2=new HashMap<>(); int n1=sc.nextInt(); int
         * arr[]=new int[n1]; for(int i=0;i<n1;i++){ arr[i]=sc.nextInt();
         * set1.put(arr[i],set1.getOrDefault(arr[i],0)+1); }
         * 
         * int n2=sc.nextInt(); int arr2[]=new int[n2]; for(int i=0;i<n2;i++){
         * arr2[i]=sc.nextInt(); set2.put(arr2[i],
         * Math.min(set1.getOrDefault(arr2[i],0),set2.getOrDefault(arr2[i],0)+1 )); } //
         * System.out.println(set2); // System.out.println(set1);
         * 
         * for(int item: arr2){ if(set2.get(item)>0){ System.out.println(item);
         * set2.put(item,set2.get(item)-1); } }
         */

        HashMap<Integer, Integer> hm = new HashMap<>();

        int n1 = sc.nextInt();
        int arr[] = new int[n1];
        for (int i = 0; i < n1; i++) {
            arr[i] = sc.nextInt();
            hm.put(arr[i], hm.getOrDefault(arr[i], 0) + 1);
        }

        int n2 = sc.nextInt();
        int arr2[] = new int[n2];
        for (int i = 0; i < n2; i++) {
            arr2[i] = sc.nextInt();
            if (hm.getOrDefault(arr2[i], 0) > 0) {
                System.out.println(arr2[i]);
                hm.put(arr2[i], hm.get(arr2[i]) - 1);
            }
        }

    }

}