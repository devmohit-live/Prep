import java.io.*;
import java.util.*;

public class EfficientPQConstructor {

    public static class PriorityQueue {
        ArrayList<Integer> data;

        public PriorityQueue() {
            data = new ArrayList<>();
        }

        public PriorityQueue(int arr[]) {
            // O(N) => proved mathematicaly
            // runtime => N + logN + 2
            // add all
            data = new ArrayList<>();
            for (int val : arr) {
                data.add(val);
            }
            // not calling heapify for last nodes/leaves
            for (int i = data.size() / 2 - 1; i >= 0; i--) {
                downheapify(i);
            }

            // previously we were calling add()
        }

        private void swap(int i, int j) {
            int temp = data.get(i);
            data.set(i, data.get(j));
            data.set(j, temp);
        }

        private void upheapify(int ci) {
            if (ci == 0)
                return;
            int pi = (ci - 1) / 2;
            if (data.get(ci) < data.get(pi)) {
                swap(pi, ci);
                upheapify(pi);
            }
        }

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

        public void add(int val) { // NlogN
            data.add(val);
            upheapify(data.size() - 1);
            // upheapify at every level => most calls at last level having max elements
        }

        public int remove() {
            if (this.size() == 0) {
                System.out.println("Underflow");
                return -1;
            }

            int val = data.get(0);
            swap(0, data.size() - 1);
            data.remove(data.size() - 1);
            downheapify(0);
            return val;
        }

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
        // PriorityQueue qu = new PriorityQueue();
        int arr[] = { 10, 15, 78, 2, 4, 15, 3, 1, 25, 0 };
        PriorityQueue pq = new PriorityQueue(arr);
        while (pq.size() > 0) {
            System.out.println(pq.remove());
        }
    }
}