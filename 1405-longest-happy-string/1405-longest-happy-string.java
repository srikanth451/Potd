class Solution {

    public static class Pair{
        int count ;
        char ch;

        Pair(int count, char ch)
        {
            this.count = count;
            this.ch = ch;
        }
    }
    public String longestDiverseString(int a, int b, int c) {
        
        PriorityQueue<Pair> maxHeap = new PriorityQueue<>((x, y) -> y.count - x.count);

        StringBuilder ans = new StringBuilder();
        
        if(a > 0)
        {
            maxHeap.offer(new Pair(a,'a'));
        }
        if(b > 0)
        {
            maxHeap.offer(new Pair(b, 'b'));
        }
        if(c > 0)
        {
            maxHeap.offer(new Pair(c, 'c'));
        }

        while(!maxHeap.isEmpty())
        {
            Pair curr = maxHeap.poll();

            if(ans.length() >= 2 && ans.charAt(ans.length()-1) == curr.ch && ans.charAt(ans.length()-2) == curr.ch)
            {
                if(maxHeap.isEmpty())
                {
                    break;
                }
                Pair next = maxHeap.poll();
                next.count--;
                ans.append(next.ch);

                if(next.count > 0)
                {
                    maxHeap.offer(next);
                }
            }
            else{
                ans.append(curr.ch);
                curr.count--;
            }
            if(curr.count > 0)
            {
                maxHeap.offer(curr);
            }

        }
        return ans.toString();
    }

}