class Solution {
public:
    int countPrimes(int n) {
        if (n <= 2) return 0;
        vector<bool> passed(n, false);
        // Start from 2
        int cnt = 1;
        int upper = sqrt(n);
        for (int i = 3; i < n; i += 2) {
            if (!passed[i]) {
                cnt++;
                if (i > upper) continue;
                for (int j = i * i; j < n; j += i) {
                    passed[j] = true;
                }
            }
        }
        return cnt;
    }
};