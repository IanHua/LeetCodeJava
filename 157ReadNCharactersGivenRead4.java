/*
 * 157. Read N Characters Given Read4
 * Repeatedly read 4 bytes every time from a file
 * Notice the remaining bytes
 * O(n)
 */
public class Solution extends Reader4 {
	public int read (char[] buf, int n) {
		char buffer = new char[4];
		int readBytes = 0;
		boolean eof = false;
		int toRead;
		while (!eof && readBytes < n) {
			int ch = read4(buffer);
			if (ch < 4) eof = true;
			toRead = Math.min(ch, n - readBytes);
			System.arraycopy(buffer, 0, buf, readBytes, toRead);
			readBytes += toRead;
		}
		return readBytes;
	}
}