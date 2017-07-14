class Solution {
public:
    bool wordBreak(string s, vector<string>& wordDict) {
        if (wordDict.size() == 0) return false;
        bool dp[s.length()+1] = {false};
        dp[0] = true;
        
        for (int i = 1; i <= s.length(); i++) {
            for(int j = i - 1; j >= 0; j--) {
                if(dp[j]) {
                    string word = s.substr(j, i-j);
                    if(find(wordDict, word)) {
                        dp[i] = true;
                        break;
                    }
                }
            }
        }
        return dp[s.size()];
    }
    
    
    bool find(vector<string>& wordDict, string word) {
        for (vector<string>::iterator iter = wordDict.begin(); iter != wordDict.end(); iter++) {
            if (*iter == word) {
                return true;
            }
        }
        return false;
    }
};