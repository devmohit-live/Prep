import java.util.*;

public class cc {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Float> inp = new ArrayList<>();
        while (true) {
            float t = sc.nextFloat();
            if (!(t < 0)) {
                inp.add(t);
                t = 0;
            } else {
                break;
            }
        }

        System.out.println(inp);
    }
}