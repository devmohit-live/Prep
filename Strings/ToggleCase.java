import java.util.Scanner;

class ToggleCase {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder(sc.nextLine());
        for (int i = 0; i < sb.length(); i++) {
            char x = sb.charAt(i);
            // check wheteer it is in lower case or not
            if ('a' <= x && x <= 'z') {
                // difference between 'a'-'A' = 'p'-'P' => ith-a+A => captialized ith
                x = (char) (x - 'a' + 'A');
                sb.setCharAt(i, x);
            } else {
                x = (char) (x - 'A' + 'a');
                sb.setCharAt(i, x);
            }
        }
        System.out.println(sb.toString());
    }
}