public class PointUpdateSqrt {
    /**
     * Here we are storing sum of each block instead of min and have 2 types of
     * queries: f: , u:update
     */
    private static int[] preprocess(int[] arr, int len) {
        int sqrt[] = new int[len];
        for (int i = 0; i < arr.length; i++) {
            sqrt[i / len] += arr[i];
        }
        return sqrt;
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] nums = br.readLine().split(" ");
        int[] arr = new int[n];
        for (int i = 0; i < nums.length; i++)
            arr[i] = Integer.parseInt(nums[i]);

        int q = Integer.parseInt(br.readLine());
        // len of sqrt array
        int len = (int) Math.ceil(Math.sqrt(arr.length));

        // preprocessing
        int[] srt = preprocess(arr, len);
        // System.out.println("Srt array : " + srt.length + " is the size and ");
        // for (int i : srt) {
        // System.out.print(i + " ");
        // }

        // executing queries
        for (int i = 0; i < q; i++) {
            String[] lr = br.readLine().split(" ");
            int ans = 0;
            String type = lr[0];
            if (type.equals("f")) {
                int l = Integer.parseInt(lr[1]);
                int r = Integer.parseInt(lr[2]);
                while (l <= r) {
                    if (l % len == 0 && l + len - 1 <= r) {
                        ans += srt[l / len];
                        l += len;
                    } else {
                        ans += arr[l];
                        l++;
                    }
                }
                System.out.println(ans);

            } else {
                int idx = Integer.parseInt(lr[1]);
                int delta = Integer.parseInt(lr[2]);
                int sqrtidx = idx / len;
                arr[idx] += delta;
                srt[sqrtidx] += delta;
            }

        }

    }
    /**
     * inp: 5 1 5 3 9 -2 3 f 0 4 u 2 3 f 0 4
     * 
     * op: 16,19
     */
}