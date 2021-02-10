import java.io.*;
import java.util.*;

public class MedianPriorityQ {
    public static class MedianPriorityQueueNaive {
        PriorityQueue<Integer> left;
        PriorityQueue<Integer> right;
        int n;

        public MedianPriorityQueue() {
            left = new PriorityQueue<>();
            right = new PriorityQueue<>(Collections.reverseOrder());
            n = 0;
        }

        public void add(int val) { // O(1)
            left.add(val);
            this.n++;
        }

        public int remove() { // O(N)
            if (left.size() == 0) {
                System.out.println("Underflow");
                return -1;
            }

            int mid = 0;
            if ((n & 1) == 1) {
                mid = (n + 1) / 2;
            } else {
                mid = (int) Math.floor(n / 2);
            }

            if (mid == 0)
                return left.remove();

            for (int i = 0; i < mid; i++) {
                right.add(left.remove());
            }

            int val = right.remove();
            while (right.size() > 0) {
                left.add(right.remove());
            }
            this.n--;
            return val;
        }

        public int peek() { // O(N)
            int mid = 0;
            if (left.size() == 0) {
                System.out.println("Underflow");
                return -1;
            }

            if ((n & 1) == 1) {
                mid = (n + 1) / 2;
            } else {
                mid = (int) Math.floor(n / 2);
            }

            if (mid == 0) {
                return left.peek();
            }

            for (int i = 0; i < mid; i++) {
                right.add(left.remove());
            }

            int val = right.peek();
            while (right.size() > 0) {
                left.add(right.remove());
            }
            return val;
        }

        public int size() {
            // return left.size() + right.size();
            return n;
        }
    }

    public static class MedianPriorityQueueOptimal {
        PriorityQueue<Integer> left;
        PriorityQueue<Integer> right;

        public MedianPriorityQueue() {
            left = new PriorityQueue<>(Collections.reverseOrder());
            right = new PriorityQueue<>();
        }

        public void add(int val) { // O(1)
            if (right.size() > 0 && val > right.peek()) {
                right.add(val);
            } else {
                left.add(val);
            }

            if (left.size() - right.size() == 2) {
                right.add(left.remove());
            } else if (right.size() - left.size() == 2)
                left.add(right.remove());
        }

        public int remove() { // O(1)
            if (/* this.size()==0 */ left.size() + right.size() == 0) {
                System.out.println("Underflow");
                return -1;
            } else if (left.size() >= right.size()) {
                return left.remove();
            } else {
                return right.remove();
            }
        }

        public int peek() { // O(1)
            if (this.size() == 0) {
                System.out.println("Underflow");
                return -1;
            } else if (left.size() >= right.size()) {
                return left.peek();
            } else {
                return right.peek();
            }
        }

        public int size() {
            return left.size() + right.size();
            // return this.size();
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        MedianPriorityQueueNaive qn = new MedianPriorityQueueNaive();
        MedianPriorityQueueOptimal qo = new MedianPriorityQueueOptimal();
        String str = br.readLine();
        while (str.equals("quit") == false) {
            if (str.startsWith("add")) {
                int val = Integer.parseInt(str.split(" ")[1]);
                qu.add(val);
                qo.add(val);
            } else if (str.startsWith("remove")) {
                int val = qu.remove();
                int val2 = qo.remove();
                if (val != -1) {
                    System.out.println("Naive " + val);
                }
                if (val2 != -1) {
                    System.out.println("Optimal: " + val);
                }
            } else if (str.startsWith("peek")) {
                int val = qu.peek();
                int val2 = qo.peek();
                if (val != -1) {
                    System.out.println("Naive " + val);
                }
                if (val2 != -1) {
                    System.out.println("Optimal: " + val);
                }
            } else if (str.startsWith("size")) {
                System.out.println("Naive " + qu.size());
                System.out.println("Optimal: " + qo.size());
            }
            str = br.readLine();
        }
    }
}
