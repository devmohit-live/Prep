import java.io.*;
import java.util.*;

public class MaxFreq {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();

        HashMap<Character, Integer> hm = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            // if(hm.containsKey(ch)){
            // hm.put(ch, hm.get(ch)+1);
            // }else{
            // hm.put(ch,0);
            // }

            hm.put(ch, hm.getOrDefault(ch, 0) + 1);
        }
        char res = s.charAt(0);
        for (char c : hm.keySet()) {
            if (hm.get(c) > hm.get(res)) {
                res = c;
            }
        }

        System.out.println("" + res);
    }

}