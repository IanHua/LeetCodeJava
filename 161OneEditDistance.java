/*
 * 161. One Edit Distance
 * Divide and conquer
 * 1. n = m: update while others match
 * 2. n - m == 1: append or insert while others match
 * O(n)
 */
public boolean isOneEditDistance(String s, String t) {
	int m = s.length(), n = t.length();
	if (m > n) return isOneEditDistance(t, s);
	if (n - m > 1) return false;
	int i = 0, shift = n - m;
	while (i < m && s.charAt(i) == t.charAt(i)) i++;
	// Append
	if (i == m) return shift == 1;
	// Update
	if (shift == 0) i++;
	// Insert
	while (i < m && s.charAt(i) == t.charAt(i+shift)) i++;
	return i == m;
}