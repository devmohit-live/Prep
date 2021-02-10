// import java.util.*;

// class Josephus {
//     // N persons are sitting on a round table, at every move we kill the kth person,
//     // initially we start counting from 1st person and after killing the kth person,
//     // the counting for k will start from k+1th person
//     // that is k+1 the will become first person now(k-1th will become n-1(last
//     // person)), and n is decreased by 1
//     public static void main(String[] args) {
//         // default killing every third person
//         // String[]
//         // arr={"Mohit","Ravi","Harsh","Shubham","Himanshu","Abhishek","Kuldeep"};
//         ArrayList<String> a = new ArrayList<>();
//         a.add("Mohit");
//         a.add("Ravi");
//         a.add("Harsh");
//         a.add("Shubham");
//         a.add("Himanshu");
//         a.add("Abhishek");
//         a.add("Kuldeep");
//         killPerson(a, a.size(), 2); // 3rd person
//         // System.out.println(a);
//     }

//     static int killPerson(ArrayList<String> a, int n, int k) {
//         // int l=arr.lengthl;
//         if (n == 1) // only 1 person left
//             return n;
//         a.remove(k % n);
//         System.out.println(a);
//         return ((killPerson(a, n - 1, k) + k) % n) + 1;
//         // since ext counting starts from k+1, and this is a circular table(+1,%), but
//         // indexing starts from 0(-1)
//     }
// }

import java.util.*;

public class Josephus {
    public static void main(String[] args) {
        // arr={"Mohit","Ravi","Harsh","Shubham","Himanshu","Abhishek","Kuldeep"};
        ArrayList<String> a = new ArrayList<>();
        a.add("Mohit");
        a.add("Ravi");
        a.add("Harsh");
        a.add("Shubham");
        a.add("Himanshu");
        a.add("Abhishek");
        a.add("Kuldeep");
        int i = killPerson(7, 3); // 3rd person
        // int i = killPerson(7, 2); // 3rd person
        System.out.println(a.get(i));
    }

    // o based indexing
    static int killPerson(int n, int k) {
        if (n == 1) // only 1 person left
            return 0;
        int x = killPerson(n - 1, k); // recursive call
        int y = (x + k) % n; // translated address as after killing every person the translate the index,
        // also when we return the survivor it will be 0 or 1 in last phase , but we
        // have to re-traslate it to actual index, y expression does that for us
        return y; // that's how indexes are changed
    }

    /*
     * gfg
     * 
     * 1 based indexing: if (n == 1) return 1;
     * 
     * return (josephus(n-1,k) +k-1)%n +1;
     */
}
