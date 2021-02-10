import java.io.*;

public class it {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String inp[] = br.readLine().split(" ");
        int n = Integer.parseInt(inp[0]);
        int a = Integer.parseInt(inp[1]);
        int b = Integer.parseInt(inp[2]);
        int nc = n;
        int turn = 0;
        int gcdres = 0;
        while (true) {
            if (turn == 0) {
                gcdres = gcd(n, b);
                if (n >= gcdres)
                    n -= gcdres;
                else
                    break;

                turn = 1;
            } else {
                gcdres = gcd(n, a);
                if (n >= gcdres)
                    n -= gcdres;
                else
                    break;
                turn = 0;
            }
        }
        System.out.println(turn == 0 ? 1 : 0);
    }

    private static int gcd(int a, int b) {
        if (b == 0)
            return a;
        if (a == 0)
            return b;
        if (a % b == 0)
            return b;
        return gcd(b, a % b);
    }
}
