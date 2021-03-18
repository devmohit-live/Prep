import java.util.*;

public class UniqueDigits {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = 0;
        int l = sc.nextInt();
        int r = sc.nextInt();

        for (int i = l; i <= r; i++) {
            boolean visited[] = new boolean[10];
            int n = i;
            while (n > 0) {
                int a = n % 10;
                if (visited[a] == true)
                    break;
                visited[a] = true;
                n = n / 10;
            }
            if (n == 0)
                count++;
        }

        if (count == 0)
            System.out.println("No Unique Numbers found in this range");
        else {
            System.out.println(count);
        }

    }
}
