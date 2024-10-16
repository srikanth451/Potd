class Solution {
public:
    string longestDiverseString(int a, int b, int c) {
        priority_queue<pair<int,char>> maxHeap ;
        string ans = "";
        if(a > 0)
        {
            maxHeap.push({a,'a'});
        }
        if(b > 0)
        {
            maxHeap.push({b,'b'});

        }
        if(c > 0)
        {
            maxHeap.push({c,'c'});
        }

        while(!maxHeap.empty())
        {
            int currCount = maxHeap.top().first;
            int currChar = maxHeap.top().second;
            maxHeap.pop();

            if(ans.size() >= 2 && ans[ans.size()-1] == currChar && ans[ans.size()-2] == currChar)
            {
                if(maxHeap.empty())
                {
                    break;
                }
                 int nextCount = maxHeap.top().first;
                int nextChar = maxHeap.top().second;
                maxHeap.pop();

                ans += nextChar;
                nextCount--;
                if(nextCount > 0)
                {
                  maxHeap.push({nextCount,nextChar});
                }
                
            }
            else{
                ans += currChar;
                currCount--;
            }
            if(currCount > 0)
            {
                maxHeap.push({currCount,currChar});
            }

        }

        return ans;
        
    }
};