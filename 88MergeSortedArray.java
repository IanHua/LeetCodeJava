class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (nums1 == null) return;
        if (nums2 == null) return;
        int[] tmp = new int[m+n];
        int i = 0, j = 0;
        int idx = 0;
        while (i < m && j < n) {
            if (nums1[i] <= nums2[j]) {
                tmp[idx++] = nums1[i++];
            } else {
                tmp[idx++] = nums2[j++];
            }
        }
        while (i < m) tmp[idx++] = nums1[i++];
        while (j < n) tmp[idx++] = nums2[j++];
        for (i = 0; i < m + n; i++) {
            nums1[i] = tmp[i];
        }
        return;
    }
}