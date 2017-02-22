/* The guess API is defined in the parent class GuessGame.
   @param num, your guess
   @return -1 if my number is lower, 1 if my number is higher, otherwise return 0
      int guess(int num); */
/**
 * 374. Guess Number Higher or Lower
 * Binary Search
 * Optimize: move guess(mid) before if so that it only called once
 * base + (top - base) / 2 for avoiding overflow
 * O(logn)
 */
public class Solution extends GuessGame {
    public int guessNumber(int n) {
        int base = 1, top = n, mid, res;
        while (base <= top) {
            mid = base + (top - base) / 2;
            res = guess(mid);
            if (res == 0) return mid;
            else if (res == -1) {
                top = mid - 1;
            }
            else {
                base = mid + 1;
            }
        }
        return -1;
    }
}