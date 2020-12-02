public class PriorityQUsingHeap {
    
}

import java.io.*;
import java.util.*;

public class Main {

    public static class PriorityQueue {
        ArrayList<Integer> data;

        // O(1)
        private void swap(int i, int j) {
            int temp = data.get(i);
            data.set(i, data.get(j));
            data.set(j, temp);
        }

        // log n
        private void upheapify(int ci) {
            if (ci == 0)
                return;
            int pi = (ci - 1) / 2;
            if (data.get(ci) < data.get(pi)) {
                swap(pi, ci);
                upheapify(pi);
            }
        }

        // log n
        private void downheapify(int pi) {
            int lc = 2 * pi + 1;
            int rc = 2 * pi + 2;
            int min = pi;

            if (lc < data.size() && data.get(lc) < data.get(min)) {
                min = lc;
            }
            if (rc < data.size() && data.get(rc) < data.get(min)) {
                min = rc;
            }
            if (min != pi) {
                swap(min, pi);
                downheapify(min);
            }
        }

        public PriorityQueue() {
            data = new ArrayList<>();
        }

        public void add(int val) { // log n
            data.add(val);
            upheapify(data.size() - 1);
        }

        public int remove() {
            if (this.size() == 0) {
                System.out.println("Underflow");
                return -1;
            }

            int val = data.get(0);
            swap(0, data.size() - 1);
            data.remove(data.size() - 1);
            downheapify(0); // log n
            return val;
        }

        // O(1)
        public int peek() {
            if (this.size() == 0) {
                System.out.println("Underflow");
                return -1;
            }
            return data.get(0);
        }

        public int size() {
            return data.size();
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue qu = new PriorityQueue();

        String str = br.readLine();
        while (str.equals("quit") == false) {
            if (str.startsWith("add")) {
                // called n time => n log n
                int val = Integer.parseInt(str.split(" ")[1]);
                qu.add(val);
            } else if (str.startsWith("remove")) {
                // called n time => n log n
                int val = qu.remove();
                if (val != -1) {
                    System.out.println(val);
                }
            } else if (str.startsWith("peek")) {
                int val = qu.peek();
                if (val != -1) {
                    System.out.println(val);
                }
            } else if (str.startsWith("size")) {
                System.out.println(qu.size());
            }
            str = br.readLine();
        }
    }
}