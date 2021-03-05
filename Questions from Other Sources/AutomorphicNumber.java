import java.util.*;

public class AutomorphicNumber{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        long n = sc.nextLong();
        long sq= n*n;
        String num = Long.toString(n);
        String square = Long.toString(sq);

        if(square.endsWith(num)) System.out.println("automorphic number");
        else System.out.println("Not an automorphic number");
    }
}