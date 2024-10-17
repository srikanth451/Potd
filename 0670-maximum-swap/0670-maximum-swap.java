class Solution {
    public int maximumSwap(int num) {
        String n1 = Integer.toString(num);
        int n = n1.length();

        int[] maxRight = new int[10];

        for(int i=0; i<10; i++)
        {
            maxRight[i] = -1; 
        }

        for(int i=0; i<n; i++)
        {
            int idx = (int)n1.charAt(i) -'0';
            maxRight[idx] = i;
        }

        for(int i=0; i<n; i++)
        {
            //char currChar = n1.charAt(i);
            int currDigit =  n1.charAt(i)-'0';

            for(int j=9; j>currDigit; j--)
            {
                if(i < maxRight[j])
                {
                    char[] n1arr= n1.toCharArray();

                    char temp = n1arr[i];
                    n1arr[i] = n1arr[maxRight[j]];
                    n1arr[maxRight[j]] = temp;

                    return Integer.parseInt(new String(n1arr));
                }
            }
        }
        return num;
    }
}