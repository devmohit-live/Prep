class K_Concatanation_1191 {
    public int kConcatenationMaxSum(int[] arr, int k) {
        long sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }

        int ans = (int) solve(arr.length, k, arr, sum);
        return ans > 0 ? ans : 0;
    }

    public long solve(int n, int k, int[] arr, long sum) {
        final long mod = (long) (Math.pow(10, 9) + 7);
        if (k == 1) {
            return kadanes(n, arr) % mod;
        }

        else if (sum < 0) {
            return twoKadanes(arr) % mod;

        } else {

            return (twoKadanes(arr) % mod + sum % mod * (k - 2) % mod) % mod;

        }

    }

    public long twoKadanes(int[] arr) {
        int n = arr.length;
        int[] arr2 = new int[n + n];
        for (int i = 0; i < n; i++) {
            arr2[i] = arr[i];
        }
        for (int i = 0; i < n; i++) {
            arr2[i + n] = arr[i];
        }

        return kadanes(2 * n, arr2);

    }

    public long kadanes(int n, int[] arr) {

        long sum = arr[0];
        long max = arr[0];

        for (int i = 1; i < n; i++) {

            if (sum >= 0) {

                sum += arr[i];

            } else {
                sum = arr[i];
            }

            if (sum > max) {
                max = sum;
            }
        }
        return max > 0 ? max : 0;
    }
}