class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int num = gas.length;
        if (num != cost.length) return -1;
        int total = 0, min = Integer.MAX_VALUE, start = 0;
        for (int i = 0; i < num; i++) {
            total += gas[i] - cost[i];
            if (total < min) {
                min = total;
                start = i + 1;
            }
        }
        return total < 0 ? -1 : (start % num);
    }
}