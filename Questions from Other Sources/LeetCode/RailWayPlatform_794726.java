public class RailWayPlatfrom_794726 {
    // LeetCode hidden problem : 794726 (Subscribtion/Paid)
    // GFG Link to question:
    // https://practice.geeksforgeeks.org/problems/minimum-platforms-1587115620/1#

    // Time: O(2*nlogn + 2*n) => nlogn

    int findPlatform(int arr[], int dep[], int n) {
        int max_platform = 1;
        int platform = 1;
        // We are just worried about the arrival and departure of trains => the time
        // not about train's serial no
        Arrays.sort(arr);
        Arrays.sort(dep);
        // we just compare arrival and depature at a instant for different time to find
        // min no. of platforms needed to built
        int i = 1, j = 0;
        while (i < n && j < n) {
            // some train timing is before the current train leaves
            if (arr[i] <= dep[j]) {
                platform++;
                i++;
                if (platform > max_platform) {
                    max_platform = platform;
                }
            } else if (arr[i] > depA[j]) {
                // 1 platform is now vacant so currentplatform-=1
                platform--;
                j++;
            }

        }
        return max_platform;
    }
}
