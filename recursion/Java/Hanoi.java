import java.util.*;

public class Hanoi {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        char t1 = sc.next().charAt(0);
        char t2 = sc.next().charAt(0);
        char t3 = sc.next().charAt(0);
        toh(n, t1, t2, t3);
    }

    public static void toh(int n, int t1id, int t2id, int t3id) {
        if (n == 0)
            return;
        toh(n - 1, t1id, t3id, t2id); // shifting top n-1 disks to 3rd tower using tower2
        System.out.println(n + "[" + (char) t1id + " -> " + (char) t2id + "]"); // moving the last disk from tower 1 to
                                                                                // tower
        // 2(target)
        toh(n - 1, t3id, t2id, t1id); // shifting back n-1 disks from tower3 to tower2 using tower1
    }

}