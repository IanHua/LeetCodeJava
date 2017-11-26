class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null) return 0;
        int len1 = nums1.length;
        int len2 = nums2.length;
        List<Integer> array = new ArrayList<>();
        int cur1 = 0, cur2 = 0;
        int len = (len1 + len2) / 2 + 1;
        while (array.size() < len && (cur1 < len1 || cur2 < len2)) {
            if (cur1 < len1 && cur2 < len2) {
                if (nums1[cur1] <= nums2[cur2]) {
                    array.add(nums1[cur1]);
                    cur1++;
                } else {
                    array.add(nums2[cur2]);
                    cur2++;
                } 
            } 
            else if (cur1 == len1 && cur2 < len2) array.add(nums2[cur2++]);
            else if (cur1 < len1 && cur2 == len2) array.add(nums1[cur1++]);
        }
        if ((len1 + len2) % 2 == 1) {
            return array.get(array.size() - 1);
        } else {
            return (array.get(array.size() - 1) + array.get(array.size() - 2)) / 2.0;
        }
    }
}
/*class Solution {
    public double findMedianSortedArrays(int[] A, int[] B) {
        int m = A.length;
        int n = B.length;
        if (m > n) { // to ensure m<=n
            int[] temp = A; A = B; B = temp;
            int tmp = m; m = n; n = tmp;
        }
        int iMin = 0, iMax = m, halfLen = (m + n + 1) / 2;
        while (iMin <= iMax) {
            int i = (iMin + iMax) / 2;
            int j = halfLen - i;
            if (i < iMax && B[j-1] > A[i]){
                iMin = iMin + 1; // i is too small
            }
            else if (i > iMin && A[i-1] > B[j]) {
                iMax = iMax - 1; // i is too big
            }
            else { // i is perfect
                int maxLeft = 0;
                if (i == 0) { maxLeft = B[j-1]; }
                else if (j == 0) { maxLeft = A[i-1]; }
                else { maxLeft = Math.max(A[i-1], B[j-1]); }
                if ( (m + n) % 2 == 1 ) { return maxLeft; }

                int minRight = 0;
                if (i == m) { minRight = B[j]; }
                else if (j == n) { minRight = A[i]; }
                else { minRight = Math.min(B[j], A[i]); }

                return (maxLeft + minRight) / 2.0;
            }
        }
        return 0.0;
    }
}*/