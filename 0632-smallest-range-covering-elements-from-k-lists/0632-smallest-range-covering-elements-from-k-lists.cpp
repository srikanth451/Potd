class Solution {
public:
    vector<int> smallestRange(vector<vector<int>>& nums) {
        
        vector<pair<int,int>>a;
        int n = nums.size();
        for(int i=0; i<n; i++)
        {
            for(int j : nums[i])
            {
                a.push_back({j,i});
            }
        }

        sort(a.begin(),a.end());

        int mini = 1e9;
        int diff = nums.size();
        int mp[diff];
        int total = 0;
        int j = 0;
        vector<int>ans;

        memset(mp,0,sizeof(mp));

        for(int i=0; i<a.size(); i++)
        {
            mp[a[i].second]++;
            if(mp[a[i].second] == 1)
            {
                total++;
            } 
            if(total == diff)
            {
                if(a[i].first - a[j].first + 1 < mini)
                {
                    mini = a[i].first - a[j].first + 1;
                    ans = {a[j].first, a[i].first};
                }
            }
            if(total == diff)
            {
                while(total == diff)
                {
                    if(mp[a[j].second] > 1) mp[a[j].second]--,j++;
                    else
                        break; 
                }
                if(a[i].first - a[j].first + 1 < mini)
                {
                    mini = a[i].first - a[j].first + 1;
                    ans = {a[j].first, a[i].first};
                }
            }
        }
        return ans;

    }
};