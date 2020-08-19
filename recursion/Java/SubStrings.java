public class SubStrings {
    public static void main(String[] args) {
        subs("ABC");
    }

    static void subs(String s) {
        subs(s, "", 0);
    }

    staticvoid subs(String s, String curr, int index) {
        if (index == s.length()) {
            System.out.println(curr);
            return;
        }
        subs(s, curr, index + 1);
        subs(s, curr + s.charAt(index), index + 1);
    }
}