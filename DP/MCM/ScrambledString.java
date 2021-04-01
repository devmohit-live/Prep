import java.util.*;

public class ScrambledString {

    public static void main(String[] args) {
        double start, end;
        int ans;
        String[] test_A = { "ABC", "great", "abcde" };
        String[] test_B = { "CAB", "rgeat", "caebd" };
        for (int i = 0; i < 3; i++) {
            start = System.currentTimeMillis();
            ans = isScramble(test_A[i], test_B[i]);
            end = System.currentTimeMillis();
            System.out.println("Using Approach 1 : " + ans + "   takes " + (end - start) + " milliseconds");
            start = System.currentTimeMillis();
            ans = isScramble2(test_A[i], test_B[i]);
            end = System.currentTimeMillis();
            System.out.println("Using Approach 2: " + ans + "   takes " + (end - start) + " milliseconds");
            System.out.println();
        }
    }

    static Map<String, Boolean> memorization;

    public static int isScramble(String A, String B) {
        /**
         * great / \ gr eat / \ / \ g r e at / \ a t Represent the String as a binary
         * tree(exactly two child). Now what question is asking, if they swap non leaf
         * nodes 'gr' we get "rgeat"
         *
         * rgeat / \ rg eat / \ / \ r g e at / \ a t
         *
         * rgtae / \ rg tae / \ / \ r g ta e / \ t a
         *
         *
         * So tell us if "rgeat" "rgtae" is a scramble string of "great". Also "great"
         * is also a scramble string of "great" when we choose to not do any swaps. This
         * might not make sense for the whole string but definitely for substring like :
         *
         * "g|reat" "reat|g" here just "g" is swaped but not "reat".
         *
         * Okay so now we know the problem, let's check some similarity. Since we have
         * to try to represent it on every index great / \ g reat.... and so on.......
         * Now if we think carefully we do something similar in MCM (where we try all
         * possible grouping at each index). Also there is a constraint in the question
         * that "we may represent it as a binary tree by partitioning it to two
         * "[non-empty]" substrings recursively. Non Empty is of essence here so we
         * can't divide string into non empty on either side of a tree.
         *
         */
        // Generic Base Conditions.
        // If length of input String is not similar they can never be a substring of
        // each other.
        if (B.length() != A.length())
            return 0;
        if (A.compareTo(B) == 0)
            return 1; // Both are already equal, so they are scramble strings without any swap.
        if (A.length() == 0 || B.length() == 0)
            return 0; // if either of them is empty they can't be scramble strings.

        // Memorization
        memorization = new HashMap<>();
        // Now at-least input is valid and a testable input.
        return isScrambleStrings(A, B) ? 1 : 0;
    }

    private static boolean isScrambleStrings(String A, String B) {
        String key = A + ":" + B;
        if (memorization.containsKey(key))
            return memorization.get(key);
        /**
         * // Smallest valid input, when both input are equal....
         * -----------------------/ Base condition / ---------------------/
         */
        if (A.compareTo(B) == 0) {
            memorization.put(key, true);
            return true;
        }

        /**
         * Okay now we have input which is not equal, so we have to try to divide them
         * at i=0....to i < A.length()-1 why <len-1 , since we have to keep at-least 1
         * child on either side so we will try upto only at the last character.
         */
        boolean scrambleStrings = false; // Initially assume they are not.
        int length = A.length(); // -1 because 0 based index.

        for (int i = 1; i < length; i++) {
          /**
         * Okay now we have input which is not equal, so we have to try to divide them at i=0....to i < A.length()-1
         * why <len-1 , since we have to keep at-least 1 child on either side so we will try upto only at the last character.
         */
        boolean scrambleStrings = false; // Initially assume they are not.
        int length = A.length(); // -1 because 0 based index.

        for (int i = 1; i < length; i++) {
            /**
             * Now when we are swapping strings:
             *
             *          G R E A T       ----->   T E A R G
             *          0 1 2 3 4                0 1 2 3 4
             * if I Swap at i = 1
             *
             *             GREAT       ------->  TEARG
             *            /    \                 /    \
             *           GR    EAT             TEA    RG
             *
             *  We have to compare
             *              (GR)EAT     --with-->  TEA(RG)   i.e GR of A is A scramble String of RG in B.
             *  and         GR(EAT)    ---with---> (TEA)RG   i.e. EAT is a Scramble string of TEA.
             */

            /**
             * When we are not swapping the Strings.
             *
             * then at that time we have to compare:
             *             GREAT     ------>      GTEAR
             *
             *             compare (G)REAT ----with---->  (G)TEAR
             *             and compare G(REAT) --with---> G(TEAR).
             */
            if ( // When Doing the Swap.
            (isScrambleStrings(A.substring(0, i), B.substring(length - i))
                    && isScrambleStrings(A.substring(i, length), B.substring(0, length - i))) ||
            // When not doing the swap.
                    (isScrambleStrings(A.substring(0, i), B.substring(0, i))
                            && isScrambleStrings(A.substring(i, length), B.substring(i, length)))) {
                scrambleStrings = true;
                break;
            }
        }
        memorization.put(key, scrambleStrings);
        return scrambleStrings;
    }

    // FASTEST, EASIEST WAY FOUND ON INTERVIWEBIT: USES SOTING OF TWO STRINGS AND
    // SUBSTRING CONCEPT:
    public static int isScramble2(final String A, final String B) {
        if (A.length() != B.length()) {
            return 0;
        }
        if (A.length() == 0 || A.equals(B)) {
            return 1;
        }
        char c1[] = A.toCharArray();
        char c2[] = B.toCharArray();
        Arrays.sort(c1);
        Arrays.sort(c2);
        if (!new String(c1).equals(new String(c2))) {
            return 0;
        }
        for (int i = 1; i < c1.length; i++) {
            String s1 = A.substring(0, i);
            String s2 = A.substring(i, c1.length);
            String s3 = B.substring(0, i);
            String s4 = B.substring(i, c1.length);
            String s5 = B.substring(0, c1.length - i);
            String s6 = B.substring(c1.length - i, c1.length);

            if (isScramble2(s1, s3) == 1 && isScramble2(s2, s4) == 1)
                return 1;
            if (isScramble2(s1, s6) == 1 && isScramble2(s2, s5) == 1)
                return 1;
        }
        return 0;
    }
}