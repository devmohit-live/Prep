public class IsSubsequnce_492 {
    public boolean isSubsequence(String s, String t) {

        int i = 0, j = 0, count = 0;
        int al = s.length();
        int bl = t.length();
        while (i < al && j < bl) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
                j++;
                count++;
            } else {
                j++;
            }
        }

        return (count == al);
    }
}