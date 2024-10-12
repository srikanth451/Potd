class Solution {
public:
    int minGroups(vector<vector<int>>& intervals) {
        
        int n = intervals.size();

        sort(intervals.begin(), intervals.end());

        priority_queue<int, vector<int>, greater<int>> minEnd;

        for(int i=0; i<n; i++)
        {
            int start = intervals[i][0];
            int end = intervals[i][1];

            if(!minEnd.empty() && start > minEnd.top())
            {
                minEnd.pop();
            }
            minEnd.push(end);

        }
        return minEnd.size();
    }
};