import java.util.ArrayList;
import java.util.Collections;

/**
 * The goal of this challenge is to design a cash register program. You will be
 * given two decimal numbers. The first is the purchase price (PP) of the item.
 * The second is the cash (CH) given by the customer. Your register currently
 * has the following bills/coins within it: 'PENNY': .01, 'NICKEL': .05, 'DIME':
 * .10, 'QUARTER': .25, 'HALF DOLLAR': .50, 'ONE': 1.00, 'TWO': 2.00, 'FIVE':
 * 5.00, 'TEN': 10.00, 'TWENTY': 20.00, 'FIFTY': 50.00, 'ONE HUNDRED': 100.00
 * The aim of the program is to calculate the change that has to be returned to
 * the customer. Input: Your program should read lines of text from standard
 * input. Each line contains two numbers which are separated by a semicolon. The
 * first is the Purchase price (PP) and the second is the cash(CH) given by the
 * customer. Output: For each line of input print a single line to standard
 * output which is the change to be returned to the customer. In case the CH <
 * PP, print out ERROR. If CH == PP, print out ZERO. For all other cases print
 * the amount that needs to be returned, in terms of the currency values
 * provided. The output should be alphabetically sorted.
 */

public class Discovery {

    public static void main(String[] args) {
        double question[][] = { { 14, 16 }, { 15, 15 }, { 16, 14 }, { 16.59, 14 }, { 15, 14.50 }, { 16.69, 12.35 },
                { 259.63, 23.1 } };
        for (double[] q : question) {
            solve(q[1], q[0]);
        }
    }

    public static void solve(double pp, double ch) {
        if (pp > ch) {
            System.out.println("ERROR");
            return;
        } else if (pp == ch) {
            System.out.println("ZERO");
            return;
        }

        double left = ch - pp;
        double deno[] = { 100.0, 50.0, 20.0, 10.0, 5.0, 2.0, 1.0, 0.50, 0.25, 0.10, 0.05, 0.01 };
        String name[] = { "ONE HUNDRED", "FIFTY", "TWENTY", "TEN", "FIVE", "TWO", "ONE", "HALF DOLLAR", "QUARTER",
                "DIME", "NICKEL", "PENNY" };
        ArrayList<String> arr = new ArrayList<>();
        for (int i = 0; i < deno.length; i++) {
            while (left >= deno[i]) {
                left -= deno[i];
                arr.add(name[i]);
            }
        }
        // sorting
        Collections.sort(arr);
        // printing
        for (int i = 0; i < arr.size() - 1; i++) {
            System.out.print(arr.get(i) + ",");
        }
        System.out.println(arr.get(arr.size() - 1));

    }
}