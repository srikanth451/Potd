class Solution {
public:
    int maximumSwap(int num) {
        
        string n1 = to_string(num);

        int n = n1.size();
        
        vector<int>maxRight(10,-1);

        for(int i=0; i<n; i++)
        {
            int idx = n1[i] -'0';
            maxRight[idx] = i;
        }
        
        for(int i=0; i<n; i++)
        {
           char currChar = n1[i];
           int currDigit = currChar -'0';

           for(int j=9; j>currDigit; j--)
           {
            if(maxRight[j]  > i)
            {
                swap(n1[i], n1[maxRight[j]]);
                return stoi(n1);
            }
           }
        }
        return num;
    }
};