// import java.util.*;

// class Josephur {
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

public class Josephur {
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
        int i = killPerson(a, 0, 7, 3); // 3rd person
        System.out.println(a.get(0));
    }

    static int killPerson(ArrayList<String> a, int s, int n, int k) {
        if (n == 1) // only 1 person left
            return n;
        a.remove((s + k - 1) % n);
        // System.out.println(a);
        return killPerson(a, (s + k - 1) % n, n - 1, k);
    }
}
