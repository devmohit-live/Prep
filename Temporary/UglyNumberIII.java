// GFG Article on set union for finding a nth number divisible by a or b or c : https://www.geeksforgeeks.org/find-the-nth-term-divisible-by-a-or-b-or-c/
// Leetcode 1201
//Using constraints
class Solution {
    public int nthUglyNumber(int n, int a, int b, int c) {
        long ab = lcm(a, b);
        long bc = lcm(b, c);
        long ca = lcm(c, a);
        long abc = lcm(ab, c);

        long s = 1, e = 2000000000, m;
        long x;
        while (s < e) {
            m = s / 2 + e / 2 + (s % 2 + e % 2) / 2;
            x = m / a + m / b + m / c - m / ab - m / bc - m / ca + m / abc;
            if (x >= n)
                e = m;
            else
                s = m + 1;
        }

        return (int) (s);
    }

    private long lcm(long a, long b) {
        return a * b / gcd(a, b);
    }

    private long gcd(long a, long b) {
        if (b == 0)
            return a;
        if (a < b)
            return gcd(b, a);
        return gcd(a % b, b);

    }
}

// explation 1:
// The idea here is to find the nth number divisible by a, or b or c and then
// checking if that number is divisble by the given n if it is then it is the
// answer

// Step0: low= min(a,b,c) ugly series start from their min, high = n* min=> this
// can be the maximum possible value of ugny series having n numbers or use can
// use constraints lo=1,high=2000000000

// Step 1: find the mid range to check k number of elemets divisible by a,b,c =>
// countfx

// Step2 : checkif k>=n then decrease the range or k<n then increase the range
// by changing mid

// Step4: while(lo<high) keep altering the range and then return lo;

class Solution {
    public int nthUglyNumber(int n, int a, int b, int c) {
        long lo = Math.min(a, Math.min(b, c));
        long hi = lo * n; // or high =constraint 2000000000
        while (lo < hi) {
            long mid = lo + (hi - lo) / 2;
            // k no of elements are divisible by a,b,c
            // is k>n , then our answer lies within k
            if (count(a, b, c, mid) >= n) // n given lies left
                hi = mid;
            else
                lo = mid + 1; // given n lies right => more values are needed so range is increased
        }
        return (int) lo;
    }

    // total number of ugly numbers less than **mid**
    public long count(int a, int b, int c, long mid) {
        // Refer GFG
        // remove multiples lcm(a,b), lcm(b,c), lcm(c,a) - since they are counted twice.
        // add multiples of lcm(a,b,c);
        // mid/a - > contains count including ->
        // mid/lcm(a,b)+mid/lcm(a,c)+mid/lcm(a,b,c) , similarly for b and c
        return mid / a + mid / b + mid / c - mid / lcm(a, b) - mid / lcm(b, c) - mid / lcm(a, c)
                + mid / lcm(lcm(a, b), c);

        // It will give all k elemets divisible by either a,b, or c
    }

    private long lcm(long a, long b) {
        return a * b / gcd(a, b);
    }

    private long gcd(long a, long b) {
        if (b == 0)
            return a;
        if (a < b)
            return gcd(b, a);
        return gcd(a % b, b);

    }
}
