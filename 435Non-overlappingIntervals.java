/**
 * 435. Non-overlapping Intervals
 * First sort intervals using TreeMap
 * Greedy to update ans and prevValue
 * O(n)
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    public int eraseOverlapIntervals(Interval[] intervals) {
        Map<Integer, Integer> map = new TreeMap<Integer, Integer>();
        int len = intervals.length;
        int ans = 0;
        for (int i = 0; i < len; i++) {
            if (!map.containsKey(intervals[i].start)) {
                map.put(intervals[i].start, intervals[i].end);
            }
            else {
                ans++;
                if (map.get(intervals[i].start) > intervals[i].end) {
                    map.put(intervals[i].start, intervals[i].end);
                }
            }
        }
        int prevValue = Integer.MIN_VALUE;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int key = entry.getKey(), value = entry.getValue();
            if (prevValue > key) {
                ans++;
                prevValue = Math.min(prevValue, value);
            }
            else {
                prevValue = value;
            }
        }
        return ans;
    }
}