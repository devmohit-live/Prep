import java.util.*;
import java.lang.*;
import java.io.*;

class Solve {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s[] = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int k = Integer.parseInt(s[1]);

        // String inp[] = br.readLine().split(" ");
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (Integer.parseInt(br.readLine()) % k == 0)
                count++;
        }
        System.out.println(count);
    }
}