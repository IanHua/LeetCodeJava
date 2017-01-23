/*
 * 163. Missing Ranges
 * Traverse the array and test range by curr - prev 
 * Add -1 and 100 at head and tail
 * O(n)
 */
public List<String> findMissingRanges(int[] vals) {
	List<String> ranges = new ArrayList<String>();
	int curr, prev = -1;
	int end = 100;
	int i;
	int len = vals.length;
	for (i = 0; i <= len; i++) {
		curr = i == len ? end : vals[i];
		if (curr - prev >= 2) {
			renges.add(getRange(prev + 1, curr - 1));
		}
		prev = curr;
	}
	return ranges.toString();
}
private String getRange(int from, int to) {
	return (from == to) ? String.valueOf(from) : from + "->" + to;
}