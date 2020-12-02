import java.io.*;
import java.util.*;

public class MergeKSortedLists {

    static class Pair implements Comparable<Pair> {
        int val;
        int li;
        int di;

        Pair(int li, int di, int val) {
            this.li = li;
            this.di = di;
            this.val = val;
        }

        public int compareTo(Pair ot) {
            return this.val - ot.val;
        }
    }

    public static ArrayList<Integer> mergeKSortedLists(ArrayList<ArrayList<Integer>> lists) {
        ArrayList<Integer> rv = new ArrayList<>();
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        // add first elemets of each list
        for (int i = 0; i < lists.size(); i++) {
            Pair p = new Pair(i, 0, lists.get(i).get(0));
            pq.add(p);
        }

        // remove and add while q is empty
        while (pq.size() > 0) {
            Pair rm = pq.remove();
            rv.add(rm.val);
            rm.di++;

            if (rm.di < lists.get(rm.li).size()) {
                // rm.val= lists.get(rm.li).get(rm.di);
                // pq.add(rm);
                Pair p = new Pair(rm.li, rm.di, lists.get(rm.li).get(rm.di));
                pq.add(p);
            }

        }

        return rv;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());
        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            ArrayList<Integer> list = new ArrayList<>();

            int n = Integer.parseInt(br.readLine());
            String[] elements = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                list.add(Integer.parseInt(elements[j]));
            }

            lists.add(list);
        }

        ArrayList<Integer> mlist = mergeKSortedLists(lists);
        for (int val : mlist) {
            System.out.print(val + " ");
        }
        System.out.println();
    }

}