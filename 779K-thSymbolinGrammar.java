class Solution {
    public int kthGrammar(int N, int K) {
        if (N == 1) return 0;
        int r = K % 2;
        int d = K / 2;
        int res;
        if (r == 1) res = kthGrammar(N - 1, d + 1);
        else res = kthGrammar(N - 1, d);
        if (res == 1) return r == 0 ? 0 : 1;
        else return r == 0 ? 1 : 0;
    }
}