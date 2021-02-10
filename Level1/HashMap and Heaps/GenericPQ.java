import java.io.*;
import java.util.*;

public class Main {

    static class Student implements Comparable<Student> {
        int roll;
        int wt;
        int ht;

        Student(int roll, int wt, int ht) {
            this.roll = roll;
            this.wt = wt;
            this.ht = ht;
        }

        public int compareTo(Student ot) {
            return this.roll - ot.roll;
        }

        public String toString() {
            return "Roll no is: " + this.roll + " Ht: " + this.ht + " Wt: " + this.wt;
        }
    }

    static class StudentWt implements Comparator<Student> {
        public int compare(Student s1, Student s2) {
            return s1.wt - s2.wt;
        }
    }

    static class StudentHt implements Comparator<Student> {
        public int compare(Student s1, Student s2) {
            return s1.ht - s2.ht;
        }
    }

    public static class PriorityQueue<T> {
        ArrayList<T> data;
        Comparator comp;

        public PriorityQueue() {
            data = new ArrayList<>();
            this.comp = null;
        }

        public PriorityQueue(Comparator comp) {
            data = new ArrayList<>();
            this.comp = comp;
        }

        private boolean isSmaller(int i, int j) {
            if (comp != null) {
                T ith = data.get(i);
                T jth = data.get(j);
                int res = comp.compare(ith, jth);
                if (res < 0)
                    return true;
                return false;
            } else {
                Comparable ith = (Comparable) data.get(i);
                Comparable jth = (Comparable) data.get(j);
                int res = ith.compareTo(jth);
                if (res < 0)
                    return true;
                return false;
            }
        }

        private void swap(int i, int j) {
            T temp = data.get(i);
            data.set(i, data.get(j));
            data.set(j, temp);
        }

        private void upheapify(int ci) {
            if (ci == 0)
                return;
            int pi = (ci - 1) / 2;
            if (isSmaller(ci, pi)) {
                swap(pi, ci);
                upheapify(pi);
            }
        }

        private void downheapify(int pi) {
            int lc = 2 * pi + 1;
            int rc = 2 * pi + 2;
            int min = pi;

            if (lc < data.size() && isSmaller(lc, min)) {
                min = lc;
            }
            if (rc < data.size() && isSmaller(rc, min)) {
                min = rc;
            }
            if (min != pi) {
                swap(min, pi);
                downheapify(min);
            }
        }

        public void add(T val) {
            data.add(val);
            upheapify(data.size() - 1);
        }

        public T remove() {
            if (this.size() == 0) {
                System.out.println("Underflow");
                return null;
            }

            T val = data.get(0);
            swap(0, data.size() - 1);
            data.remove(data.size() - 1);
            downheapify(0);
            return val;
        }

        public T peek() {
            if (this.size() == 0) {
                System.out.println("Underflow");
                return null;
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
        PriorityQueue<Student> pq = new PriorityQueue<>();
        PriorityQueue<Student> pqr = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Student> pqw = new PriorityQueue<>(new StudentWt());
        PriorityQueue<Student> pqh = new PriorityQueue<>(Collections.reverseOrder(new StudentHt()));
        pq.add(new Student(3, 90, 50));
        pqr.add(new Student(3, 90, 50));
        pqw.add(new Student(3, 90, 50));
        pqh.add(new Student(3, 90, 50));
        pq.add(new Student(5, 80, 20));
        pqr.add(new Student(5, 80, 20));
        pqw.add(new Student(5, 80, 20));
        pqh.add(new Student(5, 80, 20));
        pq.add(new Student(4, 60, 30));
        pqr.add(new Student(4, 60, 30));
        pqw.add(new Student(4, 60, 30));
        pqh.add(new Student(4, 60, 30));
        pq.add(new Student(6, 70, 40));
        pqr.add(new Student(6, 70, 40));
        pqw.add(new Student(6, 70, 40));
        pqh.add(new Student(6, 70, 40));
        pq.add(new Student(1, 100, 60));
        pqr.add(new Student(1, 100, 60));
        pqw.add(new Student(1, 100, 60));
        pqh.add(new Student(1, 100, 60));
        pq.add(new Student(2, 80, 40));
        pqr.add(new Student(2, 80, 40));
        pqw.add(new Student(2, 80, 40));
        pqh.add(new Student(2, 80, 40));

        while (pq.size() > 0) {
            System.out.println(pq.remove());
        }
        System.out.println("****** Reverse ******");
        while (pqr.size() > 0) {
            System.out.println(pqr.remove());
        }

        System.out.println("****** Wt ******");
        while (pqw.size() > 0) {
            System.out.println(pqw.remove());
        }

        System.out.println("****** Ht ******");
        while (pqh.size() > 0) {
            System.out.println(pqh.remove());
        }

    }
}