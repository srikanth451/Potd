class Solution {
    public int minGroups(int[][] intervals) {
        
        int n = intervals.length;
        
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        
        PriorityQueue<Integer> minEnd = new PriorityQueue<>();


        for(int i=0; i<n; i++)
        {
            
            int start = intervals[i][0];
            int end = intervals[i][1];

            if(!minEnd.isEmpty() && minEnd.peek() < start)
            {
                minEnd.poll();
            }
            minEnd.add(end);
           
        }
        return minEnd.size();
    }
}