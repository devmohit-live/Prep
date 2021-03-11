public class GasStation_134 {
    // Gas Station proble - LeetCode 134
    // The idea here is to find the min starting index of the tour such that a
    // cyclic tour will be possible
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int start = 0; // index where to start
        int tank = 0; // gas in tank
        int deficient = 0; // collecting all the -ve's in the tour
        for (int i = 0; i < gas.length; i++) {
            int usage = gas[i] - cost[i];
            tank += usage;
            if (tank < 0) {
                start = (i + 1) % gas.length;
                // collecting all the -ve's till ith station
                deficient += tank;
                // restarting the tour with emty tank
                tank = 0;
            }
        }
        // checking if the gas left in tank will overcome all the -ve's(required gas
        // from 0 to i'th startion) then only circular tour will be possible
        return tank + deficient < 0 ? -1 : start;
    }
}
