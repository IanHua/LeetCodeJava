/*
 * 157. Read N Characters Given Read4
 * Repeatedly read 4 bytes every time from a file which can be called multiple times
 * Notice the bytes in buffer remained from last call
 * O(n)
 */
public class Solution extends Reader4 {
	char[] buffer = new char[4];
	int offset = 0, bufsize = 0;
	public int read (char[] buf, int n) {
		int readBytes = 0;
		boolean eof = false;
		int toRead;
		int ch;
		while (!eof && readBytes < n) {
			// Available bytes in buffer
			ch = (bufsize > 0) ? bufsize : read4(buffer);
			// Check EOF
			if (bufsize == 0 && ch < 4) eof = true;
			// Bytes to read this time
			toRead = Math.min(ch, n - readBytes);
			// Copy from buffer to buf
			System.arraycopy(buffer, offset, buf, readBytes, toRead);
			// Update buffer offset
			offset = (offset + toRead) % 4;
			// Update available size of buffer
			bufsize = ch - toRead;
			readBytes += toRead;
		}
		return readBytes;
	}
}