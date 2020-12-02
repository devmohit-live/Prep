import java.io.*;
import java.util.*;

public class HashMapImplemetation {

    public static class HashMap<K, V> {
        private class HMNode {
            K key;
            V value;

            HMNode(K key, V value) {
                this.key = key;
                this.value = value;
            }
        }

        private int size; // n
        private LinkedList<HMNode>[] buckets; // N = buckets.length

        final double Th = 2.0; // threshold for lambda

        public HashMap() {
            initbuckets(4);
            size = 0;
        }

        private void initbuckets(int N) {
            buckets = new LinkedList[N];
            for (int bi = 0; bi < buckets.length; bi++) {
                buckets[bi] = new LinkedList<>();
            }
        }

        private int hashFn(K key) {
            int hash = key.hashCode();
            return Math.abs(hash) % buckets.length;
        }

        private void reHash() throws Exception {
            int len = buckets.length;
            LinkedList<HMNode> temp[] = buckets;
            initbuckets(2 * len);

            size = 0;
            for (int i = 0; i < len; i++) {
                for (HMNode node : temp[i]) {
                    put(node.key, node.value);
                }
            }

        }

        private int indexWithinBucket(int i, K key) {
            int di = 0;
            for (HMNode node : buckets[i]) {
                if (node.key.equals(key)) {
                    return di;
                }
                di++;
            }

            return -1;
        }

        public void put(K key, V value) throws Exception {
            int bi = hashFn(key);
            int di = indexWithinBucket(bi, key);
            if (di != -1) {
                // update
                HMNode node = buckets[bi].get(di);
                node.value = value;
            } else {
                buckets[bi].add(new HMNode(key, value));
                size++;
            }

            // lambda calculation & check
            double lambda = (size * 1.0) / buckets.length;
            if (lambda > Th) {
                reHash();
            }

        }

        public V get(K key) throws Exception {
            int bi = hashFn(key);
            int di = indexWithinBucket(bi, key);
            if (di != -1)
                return buckets[bi].get(di).value;

            return null;
        }

        public boolean containsKey(K key) throws Exception {
            int bi = hashFn(key);
            int di = indexWithinBucket(bi, key);
            if (di != -1) {
                return true;
            }
            return false;
        }

        public V remove(K key) throws Exception {
            int bi = hashFn(key);
            int di = indexWithinBucket(bi, key);
            if (di != -1) {
                V value = buckets[bi].remove(di).value;
                size--;
                return value;
            }

            return null;
        }

        public ArrayList<K> keyset() throws Exception {
            ArrayList<K> keys = new ArrayList<>();
            for (int i = 0; i < buckets.length; i++) {
                for (HMNode node : buckets[i]) {
                    keys.add(node.key);
                }
            }
            return keys;
        }

        public int size() {
            return size;
        }

        public void display() {
            System.out.println("Display Begins");
            for (int bi = 0; bi < buckets.length; bi++) {
                System.out.print("Bucket" + bi + " ");
                for (HMNode node : buckets[bi]) {
                    System.out.print(node.key + "@" + node.value + " ");
                }
                System.out.println(".");
            }
            System.out.println("Display Ends");
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashMap<String, Integer> map = new HashMap();

        String str = br.readLine();
        while (str.equals("quit") == false) {
            if (str.startsWith("put")) {
                String[] parts = str.split(" ");
                String key = parts[1];
                Integer val = Integer.parseInt(parts[2]);
                map.put(key, val);
            } else if (str.startsWith("get")) {
                String[] parts = str.split(" ");
                String key = parts[1];
                System.out.println(map.get(key));
            } else if (str.startsWith("containsKey")) {
                String[] parts = str.split(" ");
                String key = parts[1];
                System.out.println(map.containsKey(key));
            } else if (str.startsWith("remove")) {
                String[] parts = str.split(" ");
                String key = parts[1];
                System.out.println(map.remove(key));
            } else if (str.startsWith("size")) {
                System.out.println(map.size());
            } else if (str.startsWith("keyset")) {
                System.out.println(map.keyset());
            } else if (str.startsWith("display")) {
                map.display();
            }
            str = br.readLine();
        }
    }
}