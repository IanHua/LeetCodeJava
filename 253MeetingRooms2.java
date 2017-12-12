/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
class Solution {
    public int minMeetingRooms(Interval[] intervals) {
        if (intervals == null || intervals.length == 0) return 0;
        int n = intervals.length;
        Comparator<Interval> cmp = new Comparator<Interval>() {
            @Override
            public int compare(Interval a, Interval b) {
                if (a.start == b.start) {
                    return a.end - b.end;
                } else {
                    return a.start - b.start;
                }
            }
        };
        Comparator<Interval> cmp2 = new Comparator<Interval>() {
            @Override
            public int compare(Interval a, Interval b) {
                return a.end - b.end;
            }
        };
        Arrays.sort(intervals, cmp);
        PriorityQueue<Interval> pq = new PriorityQueue<Interval>(n, cmp2);
        pq.offer(intervals[0]);
        for (int i = 1; i < n; i++) {
            Interval interval = pq.poll();
            if (intervals[i].start >= interval.end) {
                interval.end = intervals[i].end;
            } else {
                pq.offer(intervals[i]);
            }
            pq.offer(interval);
        }
        return pq.size();
    }
}