public class Disc {

    private static String getSortedDenomination(double amount) {
        StringBuilder result = new StringBuilder();
        while (amount > 0.01f) {
            if (amount >= 100.0) {
                result.append("ONE HUNDRED");
                amount -= 100.0;
            } else if (amount >= 50.0) {
                result.append("FIFTY");
                amount -= 50.0;
            } else if (amount >= 20.0) {
                result.append("TWENTY");
                amount -= 20.0;
            } else if (amount >= 10.0) {
                result.append("TEN");
                amount -= 10.0;
            } else if (amount >= 5.0) {
                result.append("FIVE");
                amount -= 5.0;
            } else if (amount >= 2.0) {
                result.append("TWO");
                amount -= 2.0;
            } else if (amount >= 1.0) {
                result.append("ONE");
                amount -= 1.0;
            } else if (amount >= 0.5) {
                result.append("HALF DOLLAR");
                amount -= 0.5;
            } else if (amount >= 0.25) {
                result.append("QUARTER");
                amount -= 0.25;
            } else if (amount >= 0.1) {
                result.append("DIME");
                amount -= 0.1;
            } else if (amount >= 0.05) {
                result.append("NICKEL");
                amount -= 0.05;
            } else {
                result.append("PENNY");
                amount -= 0.01;
            }
            result.append(",");
        }

        result.setLength(result.length() - 1);

        return result.toString();
    }

    public static void main(String[] args) {
        double question[][] = { { 14, 16 }, { 15, 15 }, { 16, 14 }, { 16.59, 14 }, { 15, 14.50 }, { 16.69, 12.35 },
                { 259.63, 23.1 } };
        for (double[] q : question) {
            double b = q[0];
            double a = q[1];
            if (a > b) {
                System.out.println("ERROR");
            } else if (a == b) {
                System.out.println("ZERO");
            } else {
                String s = getSortedDenomination(b - a);
                System.out.println(s);
            }
        }
    }
}
