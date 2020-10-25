import java.io.*;
import java.util.*;

// 2 5 9 3 1 12 6 8 7
public class StockSpan {
    public static void display(int[] a) {
        StringBuilder sb = new StringBuilder();

        for (int val : a) {
            sb.append(val + " ");
        }
        System.out.println(sb);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(br.readLine());
        }

        int[] span = solve(a);
        display(span);
    }

    public static int[] solve(int[] arr) {
        // solve
        // int[] span=new int[arr.length];
        int[] nge = new int[arr.length];
        Stack<Integer> s = new Stack<>();
        s.push(arr.length - 1); // pushing last index
        for (int i = arr.length - 2; i >= 0; i--) {
            while (s.size() > 0 && arr[i] > arr[s.peek()]) {
                int pos = s.peek();
                nge[pos] = pos - i;
                s.pop();
            }
            s.push(i);
        }
        // rest elements having no ngel

        for (int i = 0; i < arr.length; i++) {
            if (nge[i] == 0)
                nge[i] = i + 1;
        }

        // s.push(0);
        // span[0]=1;
        // for(int i=1;i<arr.length;i++){
        // while(s.size()>0 && arr[i]>arr[s.peek()] ){
        // s.pop();
        // }
        // if(s.size()==0){
        // span[i]=i+1;
        // }else{
        // span[i]=i-s.peek();
        // }
        // s.push(i);
        // }

        // return span;
        return nge;
    }

}