/**
 * 561. Array Partition I
 * The first C++ solution in LeetCode
 * Just sort and pick every minimum
 * O(nlogn) 
 */
class Solution {
public:
    int arrayPairSum(vector<int>& nums) {
        int len = nums.size();
        if (len % 2 == 1) {
            return 0;
        }
        sort(nums.begin(), nums.end());
        int sum = 0;
        for (int i = 0; i < len; i += 2) {
            sum += nums[i];
        }
        return sum;
    }
};