class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {
        int n = nums.size();
        List<int[]> a = new ArrayList<>();

        for(int i=0; i<n; i++)
        {
            for(int j : nums.get(i))
            {
                a.add(new int[]{j,i});
            }
        }
        Collections.sort(a, (e1,e2) -> e1[0] - e2[0]);

        int diff = n;
        int[] mp = new int[n];
        int total = 0;
        int j = 0;
        int mini = Integer.MAX_VALUE;
       // Arrays.fill(mp,0);
        int[] ans = new int[2];

        for(int i=0; i<a.size(); i++)
        {
            mp[a.get(i)[1]]++;
            
            if(mp[a.get(i)[1]] == 1)
            {
              total++;
            }

            if(total == diff)
            {

                while(mp[a.get(j)[1]] > 1)
                {   
                       mp[a.get(j)[1]]--;
                       j++; 
                }
                if(a.get(i)[0] - a.get(j)[0] + 1 < mini)
                {
                    mini = a.get(i)[0] - a.get(j)[0] + 1;
                    ans[0] = a.get(j)[0];
                    ans[1] = a.get(i)[0];
                }
            }
        }
     return ans;
    }
}