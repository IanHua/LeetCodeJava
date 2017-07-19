class Solution {
public:
    int firstUniqChar(string s) {
        if (s.empty()) {
            return -1;
        }
        int len = s.length();
        map<char, int> char_pos;
        for (int i = 0; i < len; i++) {
            char c = s[i];
            map<char, int>::iterator iter = char_pos.find(c);
            if (iter != char_pos.end()) {
                char_pos[c] = char_pos[c] + 1;
            } else {
                char_pos[c] = 1;
            }
        }
        for (int i = 0; i < len; i++) {
            if (char_pos[s[i]] == 1) {
                return i;
            }
        }
        return -1;
    }
};