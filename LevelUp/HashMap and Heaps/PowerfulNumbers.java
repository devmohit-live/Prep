import java.util.*;

public class PowerfulNumbers {
    /**
     * https://www.youtube.com/watch?v=PniLCiboQ8E
     * 
     * Here the question does't focus on ds it is based on mathematics: Contrainst:
     * A number is powerful if it is equal to x^i + y^j for i >= 0 and j >= 0.
     * 
     * Constraints: 1 <=A,B <= 100 and 1 <= X <= 10^6 Time and Space:
     * O(logx(bound)logy(bound)) as x< bound and y< bound can't be equals also
     * mininnum value of x and y can be 1 only as i,j=0 min x^0=1
     * 
     * also the function is not defined for x,y=1 as logx(1)=logy(1)=0 ans n/0 =>
     * undefined
     */

    public static ArrayList<Integer> powerfulIntegers(int x, int y, int bound) {
        HashSet<Integer> set = new HashSet<>();

        for (int i = 1; i < bound; i *= x) { // logx(bound)
            for (int j = 1; j < bound; j *= y) { // logy(bound)
                if (y == 1)
                    break;

                if (i + j <= bound)
                    set.add(i + j);
            }
            if (x == 1)
                break;
        }

        return new ArrayList<>(set);
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int x = scn.nextInt();
        int y = scn.nextInt();
        int bound = scn.nextInt();
        ArrayList<Integer> ret = new ArrayList<>();
        ret = powerfulIntegers(x, y, bound);
        Collections.sort(ret);
        for (int i = 0; i < ret.size(); i++) {
            System.out.print(ret.get(i) + " ");
        }
    }

}