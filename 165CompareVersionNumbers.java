class Solution {
    public int compareVersion(String version1, String version2) {
        if (version1.isEmpty() || version2.isEmpty()) return 0;
        String[] nums1 = version1.split("\\.");
        String[] nums2 = version2.split("\\.");
        int len = Math.max(nums1.length, nums2.length);
        for (int i = 0; i < len; i++) {
            int tmp1 = i < nums1.length ? Integer.parseInt(nums1[i]) : 0;
            int tmp2 = i < nums2.length ? Integer.parseInt(nums2[i]) : 0;
            if (tmp1 == tmp2) continue;
            else if (tmp1 > tmp2) return 1;
            else return -1;
        }
        return 0;
    }
}