class Solution {
public:
    int arrayNesting(vector<int>& nums) {
        int len = nums.size();
        bool visited[len] = {false};
        int max = 0;
        int size_s;
        for (int i = 0; i < len; i++) {
            size_s = getSize(visited, nums, i, len);
            if (max < size_s) {
                max = size_s;
            }

        }
        return max;
    }
    int getSize(bool *visited, vector<int>& nums, int pos, int len) {
        int curpos = pos;
        int size = 0;
        while (!visited[curpos]) {
            visited[curpos] = true;
            curpos = nums[curpos];
            size++;
        }
        return size;
    }
};