/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */
/**
 * 278. First Bad Version
 * Binary Search with slightly difference
 * Notice add overflow
 * O(logn)
 */
public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int base = 1, top = n, mid;
        if (isBadVersion(base)) return base;
        while (top - base > 1) {
            mid = base + (top - base) / 2;
            if (!isBadVersion(mid)) {
                base = mid;
            }
            else {
                top = mid;
            }
        }
        return top;
    }
}