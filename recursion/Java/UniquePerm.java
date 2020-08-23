import java.util.*;

class UniquePerm {
    static HashSet<String> set = new HashSet<>();

    public static void main(String[] args) {
        System.out.println("For all distinct charachter ex abcd");
        perm("abcd", 0, 3);
        System.out.println("For string having repetion ex abcccd");
        perm("abcccd", 0, 3);
    }

    // swap method c++ have builtin swap function
    static String swap(String s, int i, int j) {
        char a[] = s.toCharArray();
        char t = a[i];
        a[i] = a[j];
        a[j] = t;
        return String.valueOf(a);
    }

    static void perm(String s, int l, int r) {
        // base
        if (l == r) {
            if (set.contains(s))
                return;
            else {
                // printing only unqiue strings
                set.add(s);
                System.out.println(s);
            }
            return;
        }
        // fix each character at leftmost place and apply perm to rest
        for (int i = l; i <= r; i++) {
            // setting each char at lefmost side abc => bac =>cba
            s = swap(s, i, r);
            perm(s, l + 1, r);
            // to gain the original string say "abc" as it is since we have destorted the
            // sequence in perm
            // so if we don't revert back the other recursive calls will aplly according to
            // the distorted string
            s = swap(s, i, r);
        }
    }

}