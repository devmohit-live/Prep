import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class checkcom {

    static class url implements Comparable<url> {
        String addr;
        int count;

        url(String addr, int count) {
            this.addr = addr;
            this.count = count;
        }

        public int compareTo(url o) {
            if (this.count == o.count) {
                String k = o.addr;
                return this.addr.compareTo(o.addr);
            } else {
                return -(this.count - o.count);
            }
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String[] urlsStrings = new String[n];
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String s = sc.next();
            map.put(s, map.getOrDefault(s, 0) + 1);
        }

        System.out.println(map.size());
        url[] ans = new url[map.size()];
        int i = 0;
        for (String k : map.keySet()) {
            ans[i] = new url(k, map.get(k));
            i++;
        }
        Arrays.sort(ans);
        for (url u : ans) {
            System.out.println(u.addr);
        }
    }
}
