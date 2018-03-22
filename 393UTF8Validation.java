class Solution {
    public boolean validUtf8(int[] data) {
        int count = 0;
        for (int i = 0; i < data.length; i++) {
            int tmp = data[i];
            if (count == 0) {
                if ((tmp >> 5) == 6) count = 1;
                else if ((tmp >> 4) == 14) count = 2;
                else if ((tmp >> 3) == 30) count = 3;
                else if ((tmp >> 7) == 1) return false;
            } else {
                if ((tmp >> 6) != 2) return false;
                count--;
            }
        }
        return count == 0;
    }
}