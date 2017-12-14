class Solution {
    public String largestNumber(int[] nums) {
        if (nums == null || nums.length == 0) return "";
        int n = nums.length;
        Comparator<Integer> cmp = new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                String s1 = String.valueOf(a) + String.valueOf(b);
                String s2 = String.valueOf(b) + String.valueOf(a);
                return s2.compareTo(s1);
            }
        };
        PriorityQueue<Integer> pq = new PriorityQueue<>(n, cmp);
        for (int i = 0; i < n; i++) {
            pq.offer(nums[i]);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(String.valueOf(pq.poll()));
        }
        if (sb.charAt(0) == '0') return "0";
        else return sb.toString();
    }
}