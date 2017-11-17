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
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> ans = new ArrayList<>();
        if (intervals == null || intervals.size() == 0) return ans;
        int len = intervals.size();
        Comparator<Interval> cmp = new Comparator<Interval>() {
            @Override
            public int compare(Interval a, Interval b) {
                return a.start - b.start;
            }
        };
        Collections.sort(intervals, cmp);
        int start = intervals.get(0).start, end = intervals.get(0).end;
        for (int i = 0; i < len; i++) {
            if (i == len - 1) {
                ans.add(new Interval(start, end));
                break;
            }
            if (end < intervals.get(i+1).start) {
                // not overlap
                ans.add(new Interval(start, end));
                start = intervals.get(i+1).start;
                end = intervals.get(i+1).end;
            } else {
                end = Math.max(end, intervals.get(i+1).end);
            }
        }
        return ans;
    }
}